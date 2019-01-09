package com.geekluxun.pagecollection.service;

import com.geekluxun.dto.common.PageViewDto;
import com.geekluxun.dto.common.RequestDto;
import com.geekluxun.dto.common.ResponseDto;
import com.geekluxun.dto.pagecollection.PageBrowseDto;
import com.geekluxun.dto.pagecollection.PageDto;
import com.geekluxun.dto.pagecollection.PageListDto;
import com.geekluxun.dto.pagecollection.QueryPageDto;
import com.geekluxun.pagecollection.domain.entity.Page;
import com.geekluxun.pagecollection.domain.valobj.CollectionMember;
import com.geekluxun.pagecollection.domain.valobj.CollectionMemberTypeEnum;
import com.geekluxun.pagecollection.repo.dao.TCollectionMemberMapper;
import com.geekluxun.pagecollection.repo.dao.TPageMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-09 10:14
 * @Description:
 * @Other:
 */
@Service
public class PageServiceImpl implements PageService {

    private static final Integer PAGE_SIZE = 10;

    @Autowired
    private TCollectionMemberMapper memberMapper;

    @Autowired
    private TPageMapper pageMapper;


    @Override
    public ResponseDto<Object> deletePage(String pageId) {
        ResponseDto responseDto = new ResponseDto();

        memberMapper.delectByMemberId(pageId);
        pageMapper.delectByPageId(pageId);
        return responseDto;
    }

    @Override
    public ResponseDto<PageListDto> queryPageOfCollection(RequestDto<QueryPageDto> requestDto) {
        ResponseDto<PageListDto> responseDto = new ResponseDto<>();
        QueryPageDto requestPara = requestDto.getRequestPara();

        Integer pageNum = requestPara.getPageNum();
        String collectionId = requestPara.getCollectionId();

        // 分页
        PageHelper.startPage(pageNum, PAGE_SIZE);
        Set<CollectionMember> members = memberMapper.queryByCollectionId(collectionId);
        PageListDto pageListDto = new PageListDto();
        List<PageDto> pageDtos = new ArrayList<>();

        for (CollectionMember member : members) {
            if (isPage(member)) {
                PageDto pageDto = new PageDto();
                Page page = pageMapper.queryByPageId(member.getMemberId());
                pageDto.setPageId(page.getPageId().id());
                PageBrowseDto pageBrowseDto = new PageBrowseDto();
                BeanUtils.copyProperties(page.getPageBrowse(), pageBrowseDto);
                pageDto.setPageBrowse(pageBrowseDto);
                pageDto.setLevel(page.getLevel().getLevel());
                pageDto.setUrl(page.getUrl());
                pageDtos.add(pageDto);
            }

        }

        PageViewDto pageView = new PageViewDto();
        pageView.setPageNum(pageNum);
        pageView.setItemCount(pageDtos.size());
        pageView.setPageSize(PAGE_SIZE);

        pageListDto.setPageView(pageView);

        responseDto.setData(pageListDto);
        return responseDto;
    }


    public static Boolean isPage(CollectionMember member) {
        if (member != null && member.getType().equals(CollectionMemberTypeEnum.PAGE)) {
            return true;
        }
        return false;
    }

}
