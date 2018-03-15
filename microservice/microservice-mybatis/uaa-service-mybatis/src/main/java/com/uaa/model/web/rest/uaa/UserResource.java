package com.uaa.model.web.rest.uaa;

import com.common.web.HttpResponseDto;
import com.github.pagehelper.PageInfo;
import com.uaa.model.dto.UserDto;
import com.uaa.model.dto.UserQueryDto;
import com.uaa.model.service.impl.UserServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:2018-02-13 11:58:02
 */
//@Api(description = "UserCRUD",tags = "UserResource",basePath = "/api/v1/users")
@RestController
@RequestMapping("/api/v1/users")
public class UserResource {

	@Autowired
	UserServiceImpl userServiceImpl;

//	@ApiOperation(value = "分页查询", notes = "")
//	@ApiResponse(code = HttpStatus.OK.value(), message = "", response = PageInfo.class)
	@GetMapping("/page")
	public HttpResponseDto<PageInfo<UserDto>> page(@RequestParam("pageNum") Integer pageNum,
													  @RequestParam("pageSize") Integer pageSize,
													  @RequestParam(value = "orderByClause", required = false) String orderByClause) {
		HttpResponseDto responseDto = new HttpResponseDto(HttpStatus.OK.value(), HttpStatus.OK.name());
		UserQueryDto queryDto = new UserQueryDto();
		PageInfo<UserDto> pageInfo = userServiceImpl.findPage(pageNum, pageSize, orderByClause, queryDto);
		responseDto.setData(pageInfo);
		return responseDto;
	}

//	@ApiOperation(value = "列表查询", notes = "")
//	@ApiResponse(code = HttpStatus.OK.value(), message = "", response = List.class)
	@GetMapping("/list")
	public HttpResponseDto<List<UserDto>> list(@RequestParam(value = "orderByClause", required = false) String orderByClause) {
		HttpResponseDto responseDto = new HttpResponseDto(HttpStatus.OK.value(), HttpStatus.OK.name());
		UserQueryDto queryDto = new UserQueryDto();
		List<UserDto> list = userServiceImpl.findList(orderByClause, queryDto);
		responseDto.setData(list);
		return responseDto;
	}

//	@ApiOperation(value = "查找指定的User", notes = "")
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "", dataType = "Long", paramType = "path"),
//	})
	@GetMapping("/{id}")
	public HttpResponseDto<UserDto> get(@PathVariable("id") Long id) {
		HttpResponseDto responseDto = new HttpResponseDto(HttpStatus.OK.value(), HttpStatus.OK.name());
		UserDto dto = userServiceImpl.selectByPrimaryKey(id);
		responseDto.setData(dto);
		return responseDto;
	}

//	@ApiOperation(value = "新增User", notes = "")
//	@ApiImplicitParams({
//
//	})
	@PostMapping(value = "")
	public HttpResponseDto<UserDto> add(@RequestBody UserDto dto) {
		HttpResponseDto responseDto = new HttpResponseDto(HttpStatus.OK.value(), HttpStatus.OK.name());
		userServiceImpl.insert(dto);
		responseDto.setData(dto);
		return responseDto;
	}

	// 需提交整个对象
//	@ApiOperation(value = "更新指定的User", notes = "")
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "", dataType = "Long", paramType = "path"),
//	})
	@PutMapping("/{id}")
	public HttpResponseDto<UserDto> update(@PathVariable("id") Long id,
											  @RequestBody UserDto dto) {
		HttpResponseDto responseDto = new HttpResponseDto(HttpStatus.OK.value(), HttpStatus.OK.name());
		UserDto dbDto = userServiceImpl.selectByPrimaryKey(id);
		BeanUtils.copyProperties(dto, dbDto);
		userServiceImpl.updateByPrimaryKey(dbDto);
		responseDto.setData(dbDto);
		return responseDto;
	}

//	@ApiOperation(value = "删除指定的User", notes = "")
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "", dataType = "Long", paramType = "path"),
//	})
	@DeleteMapping("/{id}")
	public HttpResponseDto delete(@PathVariable("id") Long id) {
		HttpResponseDto responseDto = new HttpResponseDto(HttpStatus.OK.value(), HttpStatus.OK.name());
		userServiceImpl.deleteByPrimaryKey(id);
		return responseDto;
	}

}
