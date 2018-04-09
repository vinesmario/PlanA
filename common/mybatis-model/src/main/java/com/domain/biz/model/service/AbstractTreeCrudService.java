package com.domain.biz.model.service;

import com.domain.biz.model.dto.CrudQueryDto;
import com.domain.biz.model.po.CrudEntityExample;
import com.domain.biz.model.po.TreeCrudEntity;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractTreeCrudService<T extends TreeCrudEntity<T>,
		PK extends Serializable, EXAMPLE extends CrudEntityExample,
		QDTO extends CrudQueryDto> extends AbstractCrudEntityService {

	public T findChild() {
		return null;
	}

	public List<T> findChildren() {
		return null;
	}

}
