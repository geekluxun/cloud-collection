package com.geekluxun.pagecollection.service;

import com.geekluxun.dto.common.ResponseDto;
import com.geekluxun.pagecollection.domain.valobj.CollectionMember;
import com.geekluxun.pagecollection.domain.valobj.CollectionMemberTypeEnum;
import com.geekluxun.pagecollection.repo.dao.TCollectionMapper;
import com.geekluxun.pagecollection.repo.dao.TCollectionMemberMapper;
import com.geekluxun.pagecollection.repo.dao.TPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-09 9:41
 * @Description:
 * @Other:
 */
@Service
public class PageCollectionServiceImpl implements PageCollectionService{
    
    @Autowired
    private TCollectionMemberMapper memberMapper;
    
    @Autowired
    private TCollectionMapper collectionMapper;
    
    @Autowired
    private TPageMapper pageMapper;

    /**
     * 递归删除收藏夹
     * @param collectionId
     * @return
     */
    @Override
    public ResponseDto<Object> delectCollection(String collectionId) {
        ResponseDto<Object> responseDto = new ResponseDto<>();
        Set<CollectionMember> members = memberMapper.queryByCollectionId(collectionId);

        // 空收藏夹
        if (members.size() == 0) {
            collectionMapper.deleteByCollectionId(collectionId);
            return responseDto;
        }

        for (CollectionMember member : members) {
            if (member.getType().equals(CollectionMemberTypeEnum.PAGE)) {
                pageMapper.delectByPageId(member.getMemberId());
                memberMapper.delectByMemberId(member.getMemberId());
            } else if (member.getType().equals(CollectionMemberTypeEnum.COLLECTION)) {
                responseDto = delectCollection(member.getMemberId());
            }
        }

        return responseDto;
    }
}
