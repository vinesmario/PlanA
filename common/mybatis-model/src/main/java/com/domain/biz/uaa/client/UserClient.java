package com.domain.biz.uaa.client;

import com.domain.biz.model.client.CrudClient;
import com.domain.biz.uaa.dto.UserDto;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:2018-03-29 18:12:40
 */
@FeignClient(name = "uaa-service", path = "/api/v1/accounts")
public interface UserClient extends CrudClient<UserDto, Long> {

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
