package com.uaa.model.web.rest;

import com.common.util.PaginationUtil;
import com.common.web.util.HeaderUtil;
import com.github.pagehelper.PageInfo;
import com.uaa.model.dto.AccountDto;
import com.uaa.model.dto.AccountQueryDto;
import com.uaa.model.mapstruct.AccountMapStruct;
import com.uaa.model.po.Account;
import com.uaa.model.service.AccountService;
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
	AccountService accountService;
	@Autowired
	AccountMapStruct accountMapStruct;

	@GetMapping("/page")
	public ResponseEntity<List<AccountDto>> page(@RequestParam("pageNum") Integer pageNum,
												 @RequestParam("pageSize") Integer pageSize,
												 @RequestParam(value = "orderByClause", required = false) String orderByClause) {
		AccountQueryDto queryDto = new AccountQueryDto();
		PageInfo<Account> pageInfo = accountService.findPage(pageNum, pageSize, orderByClause, queryDto);
		HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(pageInfo, "/api/v1/accounts/page");
		return ResponseEntity.ok()
				.headers(headers)
				.body(accountMapStruct.fromEntities2Dtos(pageInfo.getList()));
	}

	@GetMapping("/list")
	public ResponseEntity<List<AccountDto>> list(@RequestParam(value = "orderByClause", required = false) String orderByClause) {
		AccountQueryDto queryDto = new AccountQueryDto();
		List<Account> list = accountService.findList(orderByClause, queryDto);
		HttpHeaders headers = null;
		return ResponseEntity.ok()
				.headers(headers)
				.body(accountMapStruct.fromEntities2Dtos(list));
	}

	@GetMapping("/{id}")
	public ResponseEntity<AccountDto> get(@PathVariable("id") Integer id) {
		Account entity = accountService.selectByPrimaryKey(id);
		HttpHeaders headers = null;
		return ResponseEntity.ok()
				.headers(HeaderUtil.createAlert("account.get", entity.getName()))
				.body(accountMapStruct.fromEntity2Dto(entity));
	}

	@PostMapping("")
	public ResponseEntity<AccountDto> add(@RequestBody AccountDto dto) throws URISyntaxException {
		Account entity = accountMapStruct.fromDto2Entity(dto);
		accountService.insert(entity);
		return ResponseEntity.created(new URI("/api/v1/accounts/" + entity.getId()))
				.headers(HeaderUtil.createAlert("account.created", entity.getName()))
				.body(accountMapStruct.fromEntity2Dto(entity));
	}

	// 需提交整个对象
	@PutMapping("/{id}")
	public ResponseEntity<AccountDto> update(@PathVariable("id") Integer id,
											 @RequestBody AccountDto dto) throws URISyntaxException {
		Account entity = accountMapStruct.fromDto2Entity(dto);
		Account dbEntity = accountService.selectByPrimaryKey(id);
		BeanUtils.copyProperties(entity, dbEntity);
		accountService.updateByPrimaryKey(dbEntity);
		return ResponseEntity.created(new URI("/api/users/" + dbEntity.getId()))
				.headers(HeaderUtil.createAlert("account.updated", dbEntity.getName()))
				.body(accountMapStruct.fromEntity2Dto(dbEntity));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		log.debug("REST request to delete Account: {}", id);
		Account dbEntity = accountService.selectByPrimaryKey(id);
		accountService.deleteByPrimaryKey(id);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createAlert("account.deleted", dbEntity.getName()))
				.build();
	}

}
