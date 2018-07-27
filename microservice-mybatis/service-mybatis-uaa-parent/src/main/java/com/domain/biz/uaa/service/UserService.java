package com.domain.biz.uaa.service;

import com.domain.biz.uaa.dto.UserQueryDto;
import com.domain.biz.uaa.mapper.UserMapper;
import com.domain.biz.uaa.po.User;
import com.domain.common.model.dto.query.QueryDto;
import com.domain.common.model.mybatis.mapper.CrudExample;
import com.domain.common.model.mybatis.service.AbstractCrudEntityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:2018-03-29 18:09:51
 */
@Service
public class UserService extends AbstractCrudEntityService<User, Integer, UserMapper> {

	public CrudExample fromQueryDto2Example(QueryDto queryDto) {
		UserQueryDto userQueryDto = (UserQueryDto) queryDto;

		CrudExample example = new CrudExample();
		CrudExample.Criteria criteria = example.createCriteria();

		if (null != userQueryDto) {
			if (null != userQueryDto.getId() && userQueryDto.getId().compareTo(0) > 0) {
				criteria.andIdEqualTo(userQueryDto.getId());
			}
			if (StringUtils.isNotBlank(userQueryDto.getName())) {
//                criteria.and
			}
		}
		return example;
	}
}
