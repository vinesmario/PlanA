package com.base.model.service.impl;


import com.base.model.mapper.JdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;

public class AbstractJdbcServiceImpl<T, PK extends Serializable, EXAMPLE> {
	@Autowired
	protected JdbcRepository<T, PK, EXAMPLE> repository;

	public AbstractJdbcServiceImpl() {
	}

	public Page<T> findAll(Pageable var1) {
		return repository.findAll(var1);
	}
}
