package com.uaa.web.rest.uaa;

import com.github.pagehelper.PageInfo;
import com.model.dto.uaa.AccountDto;
import com.model.dto.uaa.AccountQueryDto;
import com.model.service.impl.uaa.AccountServiceImpl;
import com.model.web.HttpResponseDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author maodipu
 * @date 2018-01-18
 */

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountResource {

    @Autowired
    AccountServiceImpl accountServiceImpl;

    @GetMapping("/page")
    public HttpResponseDto<PageInfo<AccountDto>> page(@RequestParam("pageNum") Integer pageNum,
                                                      @RequestParam("pageSize") Integer pageSize,
                                                      @RequestParam(value = "orderByClause", required = false) String orderByClause) {
        HttpResponseDto responseDto = new HttpResponseDto(HttpStatus.OK.value(), HttpStatus.OK.name());
        AccountQueryDto queryDto = new AccountQueryDto();
        PageInfo<AccountDto> pageInfo = accountServiceImpl.findPage(pageNum, pageSize, orderByClause, queryDto);
        responseDto.setData(pageInfo);
        return responseDto;
    }


    @GetMapping("/list")
    public HttpResponseDto<List<AccountDto>> list(@RequestParam(value = "orderByClause", required = false) String orderByClause) {
        HttpResponseDto responseDto = new HttpResponseDto(HttpStatus.OK.value(), HttpStatus.OK.name());
        AccountQueryDto queryDto = new AccountQueryDto();
        List<AccountDto> list = accountServiceImpl.findList(orderByClause, queryDto);
        responseDto.setData(list);
        return responseDto;
    }

    @GetMapping("/{id}")
    public HttpResponseDto<AccountDto> get(@PathVariable("id") Integer id) {
        HttpResponseDto responseDto = new HttpResponseDto(HttpStatus.OK.value(), HttpStatus.OK.name());
        AccountDto dto = accountServiceImpl.selectByPrimaryKey(id);
        responseDto.setData(dto);
        return responseDto;
    }

    @PostMapping(value = "")
    public HttpResponseDto<AccountDto> add(@RequestBody AccountDto dto) {
        HttpResponseDto responseDto = new HttpResponseDto(HttpStatus.OK.value(), HttpStatus.OK.name());
        accountServiceImpl.insert(dto);
        responseDto.setData(dto);
        return responseDto;
    }

    // 需提交整个对象
    @PutMapping("/{id}")
    public HttpResponseDto<AccountDto> update(@PathVariable("id") Integer id,
                                              @RequestBody AccountDto dto) {
        HttpResponseDto responseDto = new HttpResponseDto(HttpStatus.OK.value(), HttpStatus.OK.name());
        AccountDto dbDto = accountServiceImpl.selectByPrimaryKey(id);
        BeanUtils.copyProperties(dto, dbDto);
        accountServiceImpl.updateByPrimaryKey(dbDto);
        responseDto.setData(dbDto);
        return responseDto;
    }

    @DeleteMapping("/{id}")
    public HttpResponseDto delete(@PathVariable("id") Integer id) {
        HttpResponseDto responseDto = new HttpResponseDto(HttpStatus.OK.value(), HttpStatus.OK.name());
        accountServiceImpl.deleteByPrimaryKey(id);
        return responseDto;
    }

}
