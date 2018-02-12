package com.common.uaa.client;

import com.common.model.client.CrudClient;
import com.common.uaa.dto.AccountDto;
import com.common.web.HttpResponseDto;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
