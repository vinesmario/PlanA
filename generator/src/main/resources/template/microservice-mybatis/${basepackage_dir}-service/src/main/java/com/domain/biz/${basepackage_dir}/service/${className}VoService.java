<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.domain.biz.${basepackage}.service;

import com.domain.biz.model.service.AbstractRetrieveVoService;
import com.domain.biz.${basepackage}.dto.${className}QueryDto;
import com.domain.biz.${basepackage}.mapper.${className}VoMapper;
import com.domain.biz.${basepackage}.vo.${className}Vo;
import com.domain.biz.${basepackage}.vo.${className}VoExample;
import org.apache.commons.lang3.StringUtils;
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
public class ${className}Service extends AbstractRetrieveVoService<${className}Vo,
		Integer, ${className}VoExample,
		${className}VoMapper, ${className}QueryDto> {

	@Override
	public ${className}VoExample fromQueryDto2Example(${className}QueryDto queryDto) {
		${className}VoExample example = new ${className}VoExample();
		${className}VoExample.Criteria criteria = example.createCriteria();

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
