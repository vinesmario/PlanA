<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.${basepackage}.model.service;

import com.common.model.service.AbstractCrudService;
import com.common.utils.StringUtils;
import com.${basepackage}.model.dto.${className}Dto;
import com.${basepackage}.model.dto.${className}QueryDto;
import com.${basepackage}.model.po.${className};
import com.${basepackage}.model.po.${className}Example;
import org.springframework.stereotype.Service;

/**
 <#if table.remarks?exists && table.remarks != '' && table.remarks != 'null'>
 * ${table.remarks}
 </#if>
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:<#if now??>${now?string('yyyy-MM-dd HH:mm:ss')}</#if>
 */
@Service
public class ${className}Service extends AbstractCrudService<${className}, Long, ${className}Example,
		${className}Dto, ${className}QueryDto> {

	@Override
	public ${className}Example fromQueryDto2Example(${className}QueryDto queryDto) {
		${className}Example example = new ${className}Example();
		${className}Example.Criteria criteria = example.createCriteria();

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
