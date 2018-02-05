package com.common.model;

import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface CrudMapper<T extends CrudEntity, PK extends Serializable,
        EXAMPLE extends CrudEntityExample> {

    List<T> selectByExample(EXAMPLE example);

    T selectByPrimaryKey(PK primaryKey);

    void deleteByPrimaryKey(PK primaryKey);

    void deleteByExample(EXAMPLE example);

    void insert(T entity);

    void updateByPrimaryKey(T entity);

    void updateByPrimaryKeySelective(T entity);

    void updateByExample(@Param("record") T record, @Param("example") EXAMPLE example);

    void updateByExampleSelective(@Param("record") T record, @Param("example") EXAMPLE example);

}
