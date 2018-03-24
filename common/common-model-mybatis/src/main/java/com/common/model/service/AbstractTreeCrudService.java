package com.common.model.service;

import com.common.model.dto.CrudQueryDto;
import com.common.model.po.CrudEntityExample;
import com.common.model.po.TreeCrudEntity;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractTreeCrudService<T extends TreeCrudEntity<T>,
		PK extends Serializable, EXAMPLE extends CrudEntityExample,
		QDTO extends CrudQueryDto> extends AbstractCrudService {

	public T findChild() {
		return null;
	}

	public List<T> findChildren() {
		return null;
	}

}
