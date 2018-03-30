package com.domain.biz.model.client;

import com.domain.biz.model.dto.CrudDto;
import com.github.pagehelper.PageInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public interface CrudClient<DTO extends CrudDto, PK extends Serializable> {

	@GetMapping("/page")
	ResponseEntity<PageInfo<DTO>> page(@RequestParam("pageNum") Integer pageNum,
									   @RequestParam("pageSize") Integer pageSize,
									   @RequestParam(value = "orderByClause", required = false) String orderByClause);


	@GetMapping("/list")
	ResponseEntity<List<DTO>> list(@RequestParam(value = "orderByClause", required = false) String orderByClause);

	@GetMapping("/{id}")
	ResponseEntity<DTO> get(@PathVariable("id") PK id);

	@PostMapping(value = "")
	ResponseEntity<DTO> add(@RequestBody DTO dto);

	// 需提交整个对象
	@PutMapping("/{id}")
	ResponseEntity<DTO> update(@PathVariable("id") PK id,
							   @RequestBody DTO dto);

	@DeleteMapping("/{id}")
	ResponseEntity delete(@PathVariable("id") Long id);
}
