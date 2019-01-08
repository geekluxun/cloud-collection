package com.geekluxun.typehandler;

import com.geekluxun.pagecollection.domain.valobj.CollectionMemberTypeEnum;
import com.geekluxun.pagecollection.domain.valobj.PageImportanceLevelEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Copyright,2018-2019,geekluxun Co.,Ltd.
 *
 * @Author: luxun
 * @Create: 2019-01-08 10:01
 * @Description:
 * @Other:
 */
@MappedTypes(CollectionMemberTypeEnum.class)
public class CollectionMemberTypeTypeHandler implements TypeHandler<CollectionMemberTypeEnum> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, CollectionMemberTypeEnum collectionMemberTypeEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, collectionMemberTypeEnum.getType());
    }

    @Override
    public CollectionMemberTypeEnum getResult(ResultSet resultSet, String s) throws SQLException {
        Integer type = resultSet.getInt(s);
        return CollectionMemberTypeEnum.getCollectionMemberTypeEnumByType(type);
    }

    @Override
    public CollectionMemberTypeEnum getResult(ResultSet resultSet, int i) throws SQLException {
        Integer type = resultSet.getInt(i);
        return CollectionMemberTypeEnum.getCollectionMemberTypeEnumByType(type);
    }

    @Override
    public CollectionMemberTypeEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        Integer type = callableStatement.getInt(i);

        return CollectionMemberTypeEnum.getCollectionMemberTypeEnumByType(type);
    }

}
