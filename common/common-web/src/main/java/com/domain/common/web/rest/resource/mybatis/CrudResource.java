package com.domain.common.web.rest.resource.mybatis;

import com.domain.common.model.dto.CrudDto;
import com.domain.common.model.dto.query.QueryDto;
import com.domain.common.model.entity.CrudEntity;
import com.domain.common.model.mapstruct.CrudEntityMapStruct;
import com.domain.common.model.mybatis.mapper.CrudEntityMapper;
import com.domain.common.model.mybatis.service.AbstractCrudEntityService;
import com.domain.common.web.rest.feign.client.CrudClient;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@RestController
public class CrudResource<T extends CrudEntity,
		PK extends Serializable,
		MAPPER extends CrudEntityMapper<T, PK>,
		SERVICE extends AbstractCrudEntityService<T, PK, MAPPER, QDTO>,
		QDTO extends QueryDto,
		DTO extends CrudDto, MAPSTRUCT extends CrudEntityMapStruct<T, DTO>> implements CrudClient<DTO, PK, QDTO> {

	@Autowired
	private SERVICE service;

	@Autowired
	private MAPSTRUCT mapstruct;

	/**
	 * 预处理查询条件
	 *
	 * @param queryDto
	 */
	private void preQueryDto(QDTO queryDto) {

	}

	@GetMapping("/count")
	public ResponseEntity<PageInfo> count(@ModelAttribute QDTO queryDto) {
		preQueryDto(queryDto);
		Integer count = service.countByExample(queryDto);
		PageInfo page = new PageInfo();
		page.setTotal(count);
		return ResponseEntity.ok().body(page);
	}

	@GetMapping("/page")
	public ResponseEntity page(@ModelAttribute QDTO queryDto, Pageable pageable) {
		preQueryDto(queryDto);
		PageInfo<T> page = service.findPage(queryDto, pageable);

		PageInfo<DTO> dtoPage = new PageInfo<>();
		BeanUtils.copyProperties(page, dtoPage);
		dtoPage.setList(mapstruct.fromEntities2Dtos(page.getList()));
		return ResponseEntity.ok().body(dtoPage);
	}

	@GetMapping("/list")
	public ResponseEntity<List<DTO>> list(@ModelAttribute QDTO queryDto, Sort sort) {
		preQueryDto(queryDto);
		List<T> list = service.findList(queryDto, sort);
		return ResponseEntity.ok().body(mapstruct.fromEntities2Dtos(list));
	}

	@GetMapping("/{id}")
	public ResponseEntity<DTO> get(@PathVariable("id") PK id) {
		T entity = service.selectByPrimaryKey(id);
		return ResponseEntity.ok().body(mapstruct.fromEntity2Dto(entity));
	}

	@PostMapping(value = "")
	public ResponseEntity<DTO> add(@RequestBody DTO dto) {
		T entity = mapstruct.fromDto2Entity(dto);

		LocalDateTime now = LocalDateTime.now();
		entity.setCreatedDate(now);
		entity.setLastModifiedDate(now);
		service.insert(entity);

		return ResponseEntity.ok().body(mapstruct.fromEntity2Dto(entity));
	}

	@PutMapping("/{id}")
	public ResponseEntity<DTO> update(@PathVariable("id") PK id,
									  @RequestBody DTO dto) {
		T entity = mapstruct.fromDto2Entity(dto);
		T dbEntity = service.selectByPrimaryKey(id);
		BeanUtils.copyProperties(entity, dbEntity);

		LocalDateTime now = LocalDateTime.now();
		entity.setLastModifiedDate(now);
		service.updateByPrimaryKey(dbEntity);

		return ResponseEntity.ok().body(mapstruct.fromEntity2Dto(dbEntity));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") PK id) {
		service.deleteByPrimaryKey(id);
	}

}
