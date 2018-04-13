<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.domain.biz.${basepackage}.web.rest;

import com.domain.common.kit.StringKit;
import com.github.pagehelper.PageInfo;
import com.domain.biz.${basepackage}.dto.${className}Dto;
import com.domain.biz.${basepackage}.dto.${className}QueryDto;
import com.domain.biz.${basepackage}.mapstruct.${className}MapStruct;
import com.domain.biz.${basepackage}.service.${className}Service;
import com.domain.biz.${basepackage}.po.${className};
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 <#if table.remarks?exists && table.remarks != '' && table.remarks != 'null'>
 * ${table.remarks}
 </#if>
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:<#if now??>${now?string('yyyy-MM-dd HH:mm:ss')}</#if>
 */
@Api(description = "${className}CRUD", tags = "${className}Resource", basePath = "/api/v1/${classNameLower}s")
@RestController
@RequestMapping("/api/v1/${classNameLower}s")
public class ${className}Resource {

	@Autowired
	${className}Service ${classNameLower}Service;

	@Autowired
	${className}MapStruct ${classNameLower}MapStruct;

	@ModelAttribute("${classNameLower}QueryDto")
	public ${className}QueryDto getQueryDto(@RequestParam(value = "pageNum", required = false) Integer pageNum,
											@RequestParam(value = "pageSize", required = false) Integer pageSize,
											@RequestParam(value = "orderByColName", required = false) String orderByColName,
											@RequestParam(value = "ascOrDesc", required = false) String ascOrDesc) {
			${className}QueryDto queryDto = new ${className}QueryDto();
			queryDto.setPageNum(pageNum);
			queryDto.setPageSize(pageSize);
			queryDto.setOrderByColName(orderByColName);
			queryDto.setAscOrDesc(ascOrDesc);

			return queryDto;
	}

	@ApiOperation(value = "分页查询", notes = "")
	@ApiResponse(code = 200, message = "", response = PageInfo.class)
	@GetMapping("/page")
	public PageInfo<${className}Dto> page(@ModelAttribute("${classNameLower}QueryDto") ${className}QueryDto queryDto) {
		if (null == queryDto.getPageNum() || queryDto.getPageNum().compareTo(0) <= 0) {
			//TODO 需要返回参数错误
			queryDto.setPageNum(1);
		}
		if (null == queryDto.getPageSize() || queryDto.getPageSize().compareTo(0) <= 0) {
			//TODO 返回参需要数错误
			queryDto.setPageSize(20);
		}
		String orderByClause = null;
		if (StringUtils.isNotBlank(queryDto.getOrderByColName())) {
			orderByClause = StringKit.camel2Underline(queryDto.getOrderByColName()).toLowerCase() + " " + queryDto.getAscOrDesc();
		}
		PageInfo<${className}> page = ${classNameLower}Service.findPage(queryDto.getPageNum(), queryDto.getPageSize(), orderByClause, queryDto);

		PageInfo<${className}Dto> dtoPage = new PageInfo<>();
		BeanUtils.copyProperties(page, dtoPage);
		dtoPage.setList(${classNameLower}MapStruct.fromEntities2Dtos(page.getList()));
		return dtoPage;
	}

	@ApiOperation(value = "列表查询", notes = "")
	@ApiResponse(code = 200, message = "", response = List.class)
	@GetMapping("/list")
	public List<${className}Dto> list(@ModelAttribute("${classNameLower}QueryDto") ${className}QueryDto queryDto) {
		String orderByClause = null;
		if (StringUtils.isNotBlank(queryDto.getOrderByColName())) {
			orderByClause = StringKit.camel2Underline(queryDto.getOrderByColName()).toLowerCase() + " " + queryDto.getAscOrDesc();
		}
		List<${className}> list = ${classNameLower}Service.findList(orderByClause, queryDto);
		return ${classNameLower}MapStruct.fromEntities2Dtos(list);
	}

	@ApiOperation(value = "根据id查找指定的${className}", notes = "")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "",dataType = "Integer",paramType = "path"),
	})
	@GetMapping("/{id}")
	public ${className}Dto get(@PathVariable("id") Integer id) {
		${className} entity = ${classNameLower}Service.selectByPrimaryKey(id);
		return ${classNameLower}MapStruct.fromEntity2Dto(entity);
	}

	@ApiOperation(value = "新增${className}", notes = "")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "",dataType = "Integer",paramType = "path"),
	})
	@PostMapping(value = "")
	public ${className}Dto add(@RequestBody ${className}Dto dto) {
		${className} entity = ${classNameLower}MapStruct.fromDto2Entity(dto);
        ${classNameLower}Service.insert(entity);
        return ${classNameLower}MapStruct.fromEntity2Dto(entity);
	}

	// 需提交整个对象
	@ApiOperation(value = "更新指定的${className}", notes = "")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "",dataType = "Integer",paramType = "path"),
	})
	@PutMapping("/{id}")
	public ${className}Dto update(@PathVariable("id") Integer id,
									@RequestBody ${className}Dto dto) {
		${className} entity = ${classNameLower}MapStruct.fromDto2Entity(dto);
		${className} dbEntity = ${classNameLower}Service.selectByPrimaryKey(id);
        BeanUtils.copyProperties(entity, dbEntity);
        ${classNameLower}Service.updateByPrimaryKey(dbEntity);
        return ${classNameLower}MapStruct.fromEntity2Dto(dbEntity);
	}

	@ApiOperation(value = "根据id删除指定的${className}", notes = "")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "",dataType = "Integer",paramType = "path"),
	})
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		${classNameLower}Service.deleteByPrimaryKey(id);
	}

}
