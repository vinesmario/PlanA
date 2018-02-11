package com.model.client.uaa;

import com.github.pagehelper.PageInfo;
import com.model.dto.uaa.AccountDto;
import com.model.web.HttpResponseDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author maodipu
 * @date 2018-01-18
 */

@FeignClient(name = "uaa-service", path = "/api/v1/accounts")
public interface AccountClient {

    @GetMapping("/page")
    HttpResponseDto<PageInfo<AccountDto>> page(@RequestParam("pageNum") Integer pageNum,
                                               @RequestParam("pageSize") Integer pageSize,
                                               @RequestParam(value = "orderByClause", required = false) String orderByClause);


    @GetMapping("/list")
    HttpResponseDto<List<AccountDto>> list(@RequestParam(value = "orderByClause", required = false) String orderByClause);

    @GetMapping("/{id}")
    HttpResponseDto<AccountDto> get(@PathVariable("id") Integer id);

    @PostMapping(value = "")
    HttpResponseDto<AccountDto> add(@RequestBody AccountDto dto);

    // 需提交整个对象
    @PutMapping("/{id}")
    HttpResponseDto<AccountDto> update(@PathVariable("id") Integer id,
                                       @RequestBody AccountDto dto);

    @DeleteMapping("/{id}")
    HttpResponseDto delete(@PathVariable("id") Integer id);


}
