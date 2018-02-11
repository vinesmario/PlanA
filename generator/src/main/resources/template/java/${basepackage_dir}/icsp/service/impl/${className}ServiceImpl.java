<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.icsp.service.impl;

{basepackage}.comm.dto.icsp.${className}DTO;
import com.cwgj.comm.util.StringUtils;
{basepackage}.core.entity.${className};
{basepackage}.core.entity.${className}Example;
{basepackage}.core.mapper.primary.${className}Mapper;
{basepackage}.icsp.mapstruct.${className}MapStruct;
{basepackage}.icsp.service.I${className}Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author maodipu
 * @date 2018-01-18
 */

@Service("${classNameLower}Service")
public class ${className}ServiceImpl implements I${className}Service {

	@Resource
	${className}Mapper ${classNameLower}Mapper;

	@Resource
	${className}MapStruct ${classNameLower}MapStruct;

	public PageInfo<${className}DTO> findPage(Integer pageNum, Integer pageSize, String orderByClause, ${className}DTO conditionDTO) {
		PageHelper.startPage(pageNum, pageSize);

		${className}Example example = new ${className}Example();
		if (StringUtils.isNotBlank(orderByClause)) {
			example.setOrderByClause(orderByClause);
		}

		${className}Example.Criteria criteria = example.createCriteria();
		if(null != conditionDTO){

		}
		List<${className}> list = ${classNameLower}Mapper.selectByExample(example);
		PageInfo<${className}DTO> page = new PageInfo<>();
		BeanUtils.copyProperties(new PageInfo<>(list), page);
		page.setList(${classNameLower}MapStruct.fromEntities2DTOs(list));
		return page;
	}

	public List<${className}DTO> findList(${className}DTO conditionDTO) {
		${className}Example example = new ${className}Example();
		${className}Example.Criteria criteria = example.createCriteria();
		if(null != conditionDTO){

		}

		List<${className}> list = ${classNameLower}Mapper.selectByExample(example);
		return ${classNameLower}MapStruct.fromEntities2DTOs(list);
	}

	public ${className}DTO selectByPrimaryKey(Integer id){
		return ${classNameLower}MapStruct.fromEntity2DTO(${classNameLower}Mapper.selectByPrimaryKey(id));
	}
	 
    public void deleteByPrimaryKey(Integer id){
    	${classNameLower}Mapper.deleteByPrimaryKey(id);
    }

	public void save(${className}DTO recordDTO){
		${className} entity = ${classNameLower}MapStruct.fromDTO2Entity(recordDTO);
		${classNameLower}Mapper.insert(entity);
	}

	public void updateByPrimaryKey(${className}DTO recordDTO){
		${classNameLower}Mapper.updateByPrimaryKey(${classNameLower}MapStruct.fromDTO2Entity(recordDTO));
	}

  
}
