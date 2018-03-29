package com.domain.biz.uaa.client;

import com.domain.biz.model.client.CrudClient;
import com.domain.biz.uaa.dto.AccountDto;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author maodipu
 * @date 2018-01-18
 */

@FeignClient(name = "uaa-service", path = "/api/v1/accounts")
public interface AccountClient extends CrudClient<AccountDto, Long> {

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
