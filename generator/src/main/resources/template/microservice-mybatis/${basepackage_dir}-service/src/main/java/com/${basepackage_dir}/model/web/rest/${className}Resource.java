<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.${basepackage}.model.web.rest.uaa;

import com.common.web.HttpResponseDto;
import com.github.pagehelper.PageInfo;
import com.${basepackage}.model.dto.${className}Dto;
import com.${basepackage}.model.dto.${className}QueryDto;
import com.${basepackage}.model.service.impl.${className}ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@Api(description = "${className}CRUD",tags = "${className}Resource",basePath = "/api/v1/${classNameLower}s")
@RestController
@RequestMapping("/api/v1/${classNameLower}s")
public class ${className}Resource {

	@Autowired
	${className}ServiceImpl ${classNameLower}ServiceImpl;

	@ApiOperation(value = "分页查询", notes = "")
	@ApiResponse(code = HttpStatus.OK.value(), message = "", response = PageInfo.class)
	@GetMapping("/page")
	public HttpResponseDto<PageInfo<${className}Dto>> page(@RequestParam("pageNum") Integer pageNum,
													  @RequestParam("pageSize") Integer pageSize,
													  @RequestParam(value = "orderByClause", required = false) String orderByClause) {
		HttpResponseDto responseDto = new HttpResponseDto(HttpStatus.OK.value(), HttpStatus.OK.name());
		${className}QueryDto queryDto = new ${className}QueryDto();
		PageInfo<${className}Dto> pageInfo = ${classNameLower}ServiceImpl.findPage(pageNum, pageSize, orderByClause, queryDto);
		responseDto.setData(pageInfo);
		return responseDto;
	}

	@ApiOperation(value = "列表查询", notes = "")
	@ApiResponse(code = HttpStatus.OK.value(), message = "", response = List.class)
	@GetMapping("/list")
	public HttpResponseDto<List<${className}Dto>> list(@RequestParam(value = "orderByClause", required = false) String orderByClause) {
		HttpResponseDto responseDto = new HttpResponseDto(HttpStatus.OK.value(), HttpStatus.OK.name());
		${className}QueryDto queryDto = new ${className}QueryDto();
		List<${className}Dto> list = ${classNameLower}ServiceImpl.findList(orderByClause, queryDto);
		responseDto.setData(list);
		return responseDto;
	}

	@ApiOperation(value = "查找指定的${className}", notes = "")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "", dataType = "Long", paramType = "path"),
	})
	@GetMapping("/{id}")
	public HttpResponseDto<${className}Dto> get(@PathVariable("id") Long id) {
		HttpResponseDto responseDto = new HttpResponseDto(HttpStatus.OK.value(), HttpStatus.OK.name());
		${className}Dto dto = ${classNameLower}ServiceImpl.selectByPrimaryKey(id);
		responseDto.setData(dto);
		return responseDto;
	}

	@ApiOperation(value = "新增${className}", notes = "")
	@ApiImplicitParams({

	})
	@PostMapping(value = "")
	public HttpResponseDto<${className}Dto> add(@RequestBody ${className}Dto dto) {
		HttpResponseDto responseDto = new HttpResponseDto(HttpStatus.OK.value(), HttpStatus.OK.name());
		${classNameLower}ServiceImpl.insert(dto);
		responseDto.setData(dto);
		return responseDto;
	}

	// 需提交整个对象
	@ApiOperation(value = "更新指定的${className}", notes = "")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "", dataType = "Long", paramType = "path"),
	})
	@PutMapping("/{id}")
	public HttpResponseDto<${className}Dto> update(@PathVariable("id") Long id,
											  @RequestBody ${className}Dto dto) {
		HttpResponseDto responseDto = new HttpResponseDto(HttpStatus.OK.value(), HttpStatus.OK.name());
		${className}Dto dbDto = ${classNameLower}ServiceImpl.selectByPrimaryKey(id);
		BeanUtils.copyProperties(dto, dbDto);
		${classNameLower}ServiceImpl.updateByPrimaryKey(dbDto);
		responseDto.setData(dbDto);
		return responseDto;
	}

	@ApiOperation(value = "删除指定的${className}", notes = "")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "", dataType = "Long", paramType = "path"),
	})
	@DeleteMapping("/{id}")
	public HttpResponseDto delete(@PathVariable("id") Long id) {
		HttpResponseDto responseDto = new HttpResponseDto(HttpStatus.OK.value(), HttpStatus.OK.name());
		${classNameLower}ServiceImpl.deleteByPrimaryKey(id);
		return responseDto;
	}

}
