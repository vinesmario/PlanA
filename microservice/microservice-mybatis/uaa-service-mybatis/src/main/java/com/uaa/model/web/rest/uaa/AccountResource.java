package com.uaa.model.web.rest.uaa;

import com.common.web.utils.HeaderUtil;
import com.common.web.utils.PaginationUtil;
import com.github.pagehelper.PageInfo;
import com.uaa.model.dto.AccountDto;
import com.uaa.model.dto.AccountQueryDto;
import com.uaa.model.service.impl.AccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author maodipu
 * @date 2018-01-18
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountResource {

	@Autowired
	AccountServiceImpl accountServiceImpl;

	@GetMapping("/page")
	public ResponseEntity<List<AccountDto>> page(@RequestParam("pageNum") Integer pageNum,
												 @RequestParam("pageSize") Integer pageSize,
												 @RequestParam(value = "orderByClause", required = false) String orderByClause) {
		AccountQueryDto queryDto = new AccountQueryDto();
		PageInfo<AccountDto> pageInfo = accountServiceImpl.findPage(pageNum, pageSize, orderByClause, queryDto);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(pageInfo, "/api/v1/accounts/page");
		return ResponseEntity.ok()
				.headers(headers)
				.body(pageInfo.getList());
	}

	@GetMapping("/list")
	public ResponseEntity<List<AccountDto>> list(@RequestParam(value = "orderByClause", required = false) String orderByClause) {
		AccountQueryDto queryDto = new AccountQueryDto();
		List<AccountDto> list = accountServiceImpl.findList(orderByClause, queryDto);
		HttpHeaders headers = null;
		return ResponseEntity.ok()
				.headers(headers)
				.body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> get(@PathVariable("id") Integer id) {
		AccountDto dto = accountServiceImpl.selectByPrimaryKey(id);
		HttpHeaders headers = null;
		return ResponseEntity.ok()
				.headers(HeaderUtil.createAlert("account.get", dto.getName()))
				.body(dto);
	}

	@PostMapping("")
	public ResponseEntity<AccountDto> add(@RequestBody AccountDto dto) throws URISyntaxException {
		accountServiceImpl.insert(dto);
		return ResponseEntity.created(new URI("/api/v1/accounts/" + dto.getId()))
				.headers(HeaderUtil.createAlert("account.created", dto.getName()))
				.body(dto);
	}

	// 需提交整个对象
	@PutMapping("/{id}")
	public ResponseEntity<AccountDto> update(@PathVariable("id") Integer id,
											 @RequestBody AccountDto dto) throws URISyntaxException {
		AccountDto dbDto = accountServiceImpl.selectByPrimaryKey(id);
		BeanUtils.copyProperties(dto, dbDto);
		accountServiceImpl.updateByPrimaryKey(dbDto);
		return ResponseEntity.created(new URI("/api/users/" + dto.getId()))
				.headers(HeaderUtil.createAlert("account.updated", dto.getName()))
				.body(dto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		log.debug("REST request to delete Account: {}", id);
		AccountDto dbDto = accountServiceImpl.selectByPrimaryKey(id);
		accountServiceImpl.deleteByPrimaryKey(id);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createAlert("account.deleted", dbDto.getName()))
				.build();
	}

}
