package com.domain.biz.model.client;

import com.domain.biz.model.dto.CrudDto;
import com.domain.biz.model.dto.QueryDto;
import com.github.pagehelper.PageInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public interface CrudClient<DTO extends CrudDto, PK extends Serializable, QDTO extends QueryDto> {

	@GetMapping("/page")
	ResponseEntity<PageInfo<DTO>> page(QDTO queryDto);

	@GetMapping("/list")
	ResponseEntity<List<DTO>> list(QDTO queryDto);

	@GetMapping("/{id}")
	ResponseEntity<DTO> get(@PathVariable("id") PK id);

	@PostMapping(value = "")
	ResponseEntity<DTO> add(@RequestBody DTO dto);

	@PutMapping("/{id}")
	ResponseEntity<DTO> update(@PathVariable("id") PK id,
							   @RequestBody DTO dto);

	@DeleteMapping("/{id}")
	ResponseEntity delete(@PathVariable("id") Long id);
}
