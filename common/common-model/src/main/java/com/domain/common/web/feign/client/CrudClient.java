package com.domain.common.web.feign.client;

import com.cwgj.common.model.dto.CrudDto;
import com.cwgj.common.model.dto.query.QueryDto;

import java.io.Serializable;

public interface CrudClient<DTO extends CrudDto, PK extends Serializable, QDTO extends QueryDto> {

//	@GetMapping("/page")
//	PageInfo<DTO> page(QDTO query);
//
//	@GetMapping("/list")
//	List<DTO> list(QDTO query);
//
//	@GetMapping("/{id}")
//	DTO get(@PathVariable("id") PK id);
//
//	@PostMapping(value = "")
//	DTO add(@RequestBody DTO dto);
//
//	@PutMapping("/{id}")
//	DTO update(@PathVariable("id") PK id,
//			   @RequestBody DTO dto);
//
//	@DeleteMapping("/{id}")
//	void delete(@PathVariable("id") PK id);

}
