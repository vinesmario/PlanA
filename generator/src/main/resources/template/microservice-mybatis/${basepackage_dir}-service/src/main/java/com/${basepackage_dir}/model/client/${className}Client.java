<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.${basepackage}.model.client;

import com.common.model.client.CrudClient;
import com.${basepackage}.model.dto.${className}Dto;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 <#if table.remarks?exists && table.remarks != '' && table.remarks != 'null'>
 * ${table.remarks}
 </#if>
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:<#if now??>${now?string('yyyy-MM-dd HH:mm:ss')}</#if>
 */
@FeignClient(name = "uaa-service", path = "/api/v1/accounts")
public interface ${className}Client extends CrudClient<${className}Dto, Long> {

//	@GetMapping("/page")
//	HttpResponseDto<PageInfo<AccountDto>> page(@RequestParam("pageNum") Integer pageNum,
//											   @RequestParam("pageSize") Integer pageSize,
//											   @RequestParam(value = "orderByClause", required = false) String orderByClause);
//
//
//	@GetMapping("/list")
//	HttpResponseDto<List<AccountDto>> list(@RequestParam(value = "orderByClause", required = false) String orderByClause);
//
//	@GetMapping("/{id}")
//	HttpResponseDto<AccountDto> get(@PathVariable("id") Long id);
//
//	@PostMapping(value = "")
//	HttpResponseDto<AccountDto> add(@RequestBody AccountDto dto);
//
//	// 需提交整个对象
//	@PutMapping("/{id}")
//	HttpResponseDto<AccountDto> update(@PathVariable("id") Long id,
//									   @RequestBody AccountDto dto);
//
//	@DeleteMapping("/{id}")
//	HttpResponseDto delete(@PathVariable("id") Long id);


}
