package com.geekluxun.pagecollection.application;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.geekluxun.constant.common.RetCodeEnum;
import com.geekluxun.dto.common.RequestDto;
import com.geekluxun.dto.common.ResponseDto;
import com.geekluxun.dto.pagecollection.*;
import com.geekluxun.pagecollection.domain.entity.Collection;
import com.geekluxun.pagecollection.domain.entity.Page;
import com.geekluxun.pagecollection.domain.valobj.*;
import com.geekluxun.pagecollection.repo.dao.TCollectionMapper;
import com.geekluxun.pagecollection.repo.dao.TCollectionMemberMapper;
import com.geekluxun.pagecollection.repo.dao.TPageMapper;
import com.geekluxun.pagecollection.service.PageCollectionService;
import com.geekluxun.pagecollection.service.PageService;
import com.geekluxun.service.IdService;
import com.geekluxun.service.PageCollctionApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-04 17:21
 * @Description: 网页收藏应用服务层(对应DDD的应用服务)
 * @Other: 应用服务层的主要职责包括事务控制、服务编排（调用内部领域服务或应用服务或者外部应用服务），一个方法对应一个用例流
 */
@Service
public class PageCollctionApplicationServiceImpl  implements PageCollctionApplicationService {

    @Autowired
    private TCollectionMapper collectionMapper;

    @Autowired
    private TPageMapper pageMapper;

    @Autowired
    private TCollectionMemberMapper memberMapper;

    @Reference
    private IdService idService;

    @Autowired
    private PageCollectionService collectionService;

    @Autowired
    private PageService pageService;

    /**
     * 网页收藏
     *
     * @param requestDto
     * @return
     */
    @Transactional
    public ResponseDto<Object> pageCollect(RequestDto<CollectPageDto> requestDto) {
        ResponseDto<Object> responseDto = new ResponseDto<>();
        PageBrowse pageBrowse = new PageBrowse(0, null, false);
        CollectPageDto requestParaDto = requestDto.getRequestPara();

        // 创建网页
        PageId id = new PageId("P" + idService.genId());
        Page page = new Page(id,
                requestParaDto.getName(),
                requestParaDto.getUrl(),
                null,
                PageImportanceLevelEnum.getPageImportanceLevelEnumByLevel(requestParaDto.getLevel()),
                pageBrowse);
        pageMapper.insert(page);

        // 把网页添加到上级收藏夹中
        CollectionMember member = new CollectionMember(
                page.getPageId().id(),
                page.getName(),
                CollectionMemberTypeEnum.PAGE,
                new CollectionId(requestParaDto.getParentCollectionId()));
        memberMapper.insert(member);

        return responseDto;
    }

    /**
     * 添加网页收藏夹
     *
     * @param requestDto
     * @return
     */
    @Transactional
    public ResponseDto<Object> addCollection(RequestDto<AddCollectionDto> requestDto) {
        ResponseDto responseDto = new ResponseDto();
        AddCollectionDto requestPara = requestDto.getRequestPara();

        // 创建收藏夹
        CollectionId id = new CollectionId("C" + idService.genId());
        Collection collection = new Collection(id, requestPara.getName(), requestPara.getTop(), null);
        collectionMapper.insert(collection);
        // validate
        if (!requestPara.getTop() && requestPara.getParentCollectionId() == null) {
            responseDto.setRetCode(RetCodeEnum.RET_FAILURE.getCode());
            responseDto.setRetMsg(RetCodeEnum.RET_FAILURE.getMsg());
            return responseDto;
        }

        // 把收藏夹添加到上级收藏夹中
        CollectionMember member = new CollectionMember(
                collection.getCollectionId().id(),
                collection.getName(),
                CollectionMemberTypeEnum.COLLECTION,
                new CollectionId(requestPara.getParentCollectionId()));
        memberMapper.insert(member);

        return responseDto;
    }

    /**
     * 修改收藏夹名字
     *
     * @param requestDto
     * @return
     */
    @Transactional
    public ResponseDto<Object> modifyCollectionName(RequestDto<ModifyCollectionNameDto> requestDto) {
        ResponseDto responseDto = new ResponseDto();
        ModifyCollectionNameDto requestPara = requestDto.getRequestPara();
        Collection collection = collectionMapper.queryByCollectionId(requestPara.getCollectionId());
        if (collection == null) {
            responseDto.setRetCode(RetCodeEnum.RET_FAILURE.getCode());
            responseDto.setRetMsg("修改的收藏夹不存在");
            return responseDto;
        }

        collectionMapper.updateById(collection);
        return responseDto;
    }

    /**
     * 删除收藏夹
     *
     * @param requestDto
     * @return
     */
    @Transactional
    public ResponseDto<Object> delectCollection(RequestDto<DeleteCollectionDto> requestDto) {
        ResponseDto responseDto = new ResponseDto();
        DeleteCollectionDto requestPara = requestDto.getRequestPara();
        responseDto = collectionService.delectCollection(requestPara.getCollectionId());

        return responseDto;
    }

    /**
     * 删除单个网页
     *
     * @return
     */
    @Transactional
    public ResponseDto<Object> deletePage(RequestDto<DeletePageDto> requestDto) {
        DeletePageDto requestPara = requestDto.getRequestPara();
        return pageService.deletePage(requestPara.getPageId());
    }

    /**
     * 修改网页
     *
     * @param requestDto
     * @return
     */
    @Transactional
    public ResponseDto<Object> modifyPage(RequestDto<ModifyPageDto> requestDto) {
        ResponseDto<Object> responseDto = new ResponseDto<>();
        ModifyPageDto requestPara = requestDto.getRequestPara();

        Page page = pageMapper.queryByPageId(requestPara.getPageId());
        // 修改网页重要性级别
        if (requestPara.getNewLevel() != null) {
            PageImportanceLevelEnum newLevel = PageImportanceLevelEnum.getPageImportanceLevelEnumByLevel(requestPara.getNewLevel());
            page.setLevel(newLevel);
        }

        // 修改网页名称 
        if (requestPara.getNewName() != null) {
            page.setName(requestPara.getNewName());
        }

        pageMapper.updateByPageId(page);
        return responseDto;
    }

    /**
     * 网页浏览
     *
     * @param requestDto
     * @return
     */
    @Transactional
    public ResponseDto<Object> browsePage(RequestDto<BrowsePageDto> requestDto) {
        ResponseDto responseDto = new ResponseDto();
        BrowsePageDto requestPara = requestDto.getRequestPara();
        
        Page page = pageMapper.queryByPageId(requestPara.getPageId());
        PageBrowse pageBrowse = page.getPageBrowse();
        if (!pageBrowse.isReaded()) {
            pageBrowse.setReaded(true);
        }
        int browseTotalCount = pageBrowse.getBrowseTotalCount() + 1;
        pageBrowse.setBrowseTotalCount(browseTotalCount);
        pageBrowse.setLastBrowseTime(new Date());
        page.setPageBrowse(pageBrowse);
        pageMapper.updateByPageId(page);

        return responseDto;
    }

    /**
     * 查询用户收藏的网页
     * @param request
     * @return
     */
    @Transactional
    @Override
    public ResponseDto<PageListDto> queryPages(RequestDto<QueryPageDto> request) {
        return pageService.queryPageOfCollection(request);
    }
}    