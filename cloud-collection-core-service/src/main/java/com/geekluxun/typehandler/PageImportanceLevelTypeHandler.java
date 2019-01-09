package com.geekluxun.typehandler;

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
 * @Create: 2019-01-07 15:14
 * @Description:
 * @Other:
 */
@MappedTypes(PageImportanceLevelEnum.class)
public class PageImportanceLevelTypeHandler implements TypeHandler<PageImportanceLevelEnum> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, PageImportanceLevelEnum pageImportanceLevelEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, pageImportanceLevelEnum.getLevel());

    }

    @Override
    public PageImportanceLevelEnum getResult(ResultSet resultSet, String s) throws SQLException {
        Integer level = resultSet.getInt(s);
        return PageImportanceLevelEnum.getPageImportanceLevelEnumByLevel(level);

    }

    @Override
    public PageImportanceLevelEnum getResult(ResultSet resultSet, int i) throws SQLException {
        Integer level = resultSet.getInt(i);
        return PageImportanceLevelEnum.getPageImportanceLevelEnumByLevel(level);
    }

    @Override
    public PageImportanceLevelEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        Integer level = callableStatement.getInt(i);
        return PageImportanceLevelEnum.getPageImportanceLevelEnumByLevel(level);
    }
}
