<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package com.domain.biz.${basepackage}.client;

import com.domain.biz.model.client.CrudClient;
import com.domain.biz.${basepackage}.dto.${className}Dto;
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
@FeignClient(name = "uaa-service", path = "/api/v1/${table.sqlName")
public interface ${className}Client extends CrudClient<${className}Dto, Integer, ${className}QueryDto> {

	@GetMapping("/page")
	HttpResponseDto<PageInfo<AccountDto>> page(${className}QueryDto queryDto);

	@GetMapping("/list")
	HttpResponseDto<List<AccountDto>> list(${className}QueryDto queryDto);

	@GetMapping("/{id}")
	HttpResponseDto<AccountDto> get(@PathVariable("id") Long id);

	@PostMapping(value = "")
	HttpResponseDto<AccountDto> add(@RequestBody AccountDto dto);

	@PutMapping("/{id}")
	HttpResponseDto<AccountDto> update(@PathVariable("id") Long id,
									   @RequestBody AccountDto dto);

	@DeleteMapping("/{id}")
	HttpResponseDto delete(@PathVariable("id") Long id);


}
