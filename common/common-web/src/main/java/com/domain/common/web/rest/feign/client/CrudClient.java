package com.domain.common.web.rest.feign.client;


import com.domain.common.model.dto.CrudDto;
import com.domain.common.model.dto.query.QueryDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
public interface CrudClient<DTO extends CrudDto, PK extends Serializable, QDTO extends QueryDto> {

	@GetMapping("/page")
	ResponseEntity page(QDTO query, Pageable pageable);

	@GetMapping("/list")
	ResponseEntity<List<DTO>> list(QDTO query, Sort sort);

	@GetMapping("/{id}")
	ResponseEntity<DTO> get(@PathVariable("id") PK id);

	@PostMapping(value = "")
	ResponseEntity<DTO> add(@RequestBody DTO dto);

	@PutMapping("/{id}")
	ResponseEntity<DTO> update(@PathVariable("id") PK id,
							   @RequestBody DTO dto);

	@DeleteMapping("/{id}")
	void delete(@PathVariable("id") PK id);

}
