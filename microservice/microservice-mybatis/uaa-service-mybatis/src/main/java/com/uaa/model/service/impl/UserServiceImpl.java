package com.uaa.model.service.impl;

import com.common.model.service.AbstractCrudServiceImpl;
import com.common.utils.StringUtils;
import com.uaa.model.dto.UserDto;
import com.uaa.model.dto.UserQueryDto;
import com.uaa.model.po.User;
import com.uaa.model.po.UserExample;
import org.springframework.stereotype.Service;

/**
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:2018-02-13 11:58:02
 */
@Service
public class UserServiceImpl extends AbstractCrudServiceImpl<User, Long, UserExample,
		UserDto, UserQueryDto> {

	public UserExample fromQueryDto2Example(UserQueryDto queryDto) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();

		if (null != queryDto) {
			if (null != queryDto.getId() && queryDto.getId().compareTo(0) > 0) {
				criteria.andIdEqualTo(queryDto.getId());
			}
			if (StringUtils.isNotBlank(queryDto.getName())) {
//                criteria.and
			}
		}
		return example;
	}
}
