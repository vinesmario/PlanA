package com.common.model;

import java.io.Serializable;
import java.util.List;

public interface CrudMapper<T extends CrudEntity, PK extends Serializable, EXAMPLE extends CrudEntityExample> {

    List<T> selectByExample(EXAMPLE example);

    T selectByPrimaryKey(PK primaryKey);

    void deleteByPrimaryKey(PK primaryKey);

    void deleteByExample(EXAMPLE example);

    void insert(T entity);

    void updateByPrimaryKey(T entity);

    void updateByExample(EXAMPLE example);

}
