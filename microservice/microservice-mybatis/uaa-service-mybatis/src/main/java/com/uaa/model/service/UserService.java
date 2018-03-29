package com.uaa.model.service;

import com.common.model.service.AbstractCrudService;
import com.uaa.model.dto.UserQueryDto;
import com.uaa.model.mapper.UserMapper;
import com.uaa.model.po.User;
import com.uaa.model.po.UserExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:2018-03-29 16:11:11
 */
@Service
public class UserService extends AbstractCrudService<User,
		Integer, UserExample,
		UserMapper, UserQueryDto> {

	@Override
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
