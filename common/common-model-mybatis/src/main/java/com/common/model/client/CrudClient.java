package com.common.model.client;

import com.common.model.dto.CrudDto;
import com.common.web.HttpResponseDto;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public interface CrudClient<DTO extends CrudDto, PK extends Serializable> {

	@GetMapping("/page")
	HttpResponseDto<PageInfo<DTO>> page(@RequestParam("pageNum") Integer pageNum,
										@RequestParam("pageSize") Integer pageSize,
										@RequestParam(value = "orderByClause", required = false) String orderByClause);


	@GetMapping("/list")
	HttpResponseDto<List<DTO>> list(@RequestParam(value = "orderByClause", required = false) String orderByClause);

	@GetMapping("/{id}")
	HttpResponseDto<DTO> get(@PathVariable("id") PK id);

	@PostMapping(value = "")
	HttpResponseDto<DTO> add(@RequestBody DTO dto);

	// 需提交整个对象
	@PutMapping("/{id}")
	HttpResponseDto<DTO> update(@PathVariable("id") PK id,
								@RequestBody DTO dto);

	@DeleteMapping("/{id}")
	HttpResponseDto delete(@PathVariable("id") Long id);
}
