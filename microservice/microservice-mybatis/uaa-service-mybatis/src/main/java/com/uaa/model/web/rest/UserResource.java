package com.uaa.model.web.rest;

import com.common.kit.StringKit;
import com.github.pagehelper.PageInfo;
import com.uaa.model.dto.UserDto;
import com.uaa.model.dto.UserQueryDto;
import com.uaa.model.mapstruct.UserMapStruct;
import com.uaa.model.service.UserService;
import com.uaa.model.po.User;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:2018-03-29 16:23:03
 */
@Api(description = "UserCRUD", tags = "UserResource", basePath = "/api/v1/users")
@RestController
@RequestMapping("/api/v1/users")
public class UserResource {

	@Autowired
	UserService userService;

	@Autowired
	UserMapStruct userMapStruct;

	@ApiOperation(value = "分页查询", notes = "")
	@ApiResponse(code = 200, message = "", response = PageInfo.class)
	@GetMapping("/page")
	public PageInfo<UserDto> page(@RequestParam("pageNum") Integer pageNum,
								  @RequestParam("pageSize") Integer pageSize,
								  @RequestParam(value = "orderByColName", required = false) String orderByColName,
								  @RequestParam(value = "ascOrDesc", required = false) String ascOrDesc) {
		String orderByClause = null;
		if (StringUtils.isNotBlank(orderByColName)) {
			orderByClause = StringKit.camel2Underline(orderByColName).toLowerCase() + " " + ascOrDesc;
		}
		UserQueryDto queryDto = new UserQueryDto();
		PageInfo<User> page = userService.findPage(pageNum, pageSize, orderByClause, queryDto);

		PageInfo<UserDto> dtoPage = new PageInfo<>();
		BeanUtils.copyProperties(page, dtoPage);
		dtoPage.setList(userMapStruct.fromEntities2Dtos(page.getList()));
		return dtoPage;
	}

	@ApiOperation(value = "列表查询", notes = "")
	@ApiResponse(code = 200, message = "", response = List.class)
	@GetMapping("/list")
	public List<UserDto> list(@RequestParam(value = "orderByColName", required = false) String orderByColName,
							  @RequestParam(value = "ascOrDesc", required = false) String ascOrDesc) {
		String orderByClause = null;
		if (StringUtils.isNotBlank(orderByColName)) {
			orderByClause = StringKit.camel2Underline(orderByColName).toLowerCase() + " " + ascOrDesc;
		}
		UserQueryDto queryDto = new UserQueryDto();
		List<User> list = userService.findList(orderByClause, queryDto);
		return userMapStruct.fromEntities2Dtos(list);
	}

	@ApiOperation(value = "根据id查找指定的User", notes = "")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "", dataType = "Integer", paramType = "path"),
	})
	@GetMapping("/{id}")
	public UserDto get(@PathVariable("id") Integer id) {
		User entity = userService.selectByPrimaryKey(id);
		return userMapStruct.fromEntity2Dto(entity);
	}

	@ApiOperation(value = "新增User", notes = "")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "", dataType = "Integer", paramType = "path"),
	})
	@PostMapping(value = "")
	public UserDto add(@RequestBody UserDto dto) {
		User entity = userMapStruct.fromDto2Entity(dto);
		userService.insert(entity);
		return userMapStruct.fromEntity2Dto(entity);
	}

	// 需提交整个对象
	@ApiOperation(value = "更新指定的User", notes = "")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "", dataType = "Integer", paramType = "path"),
	})
	@PutMapping("/{id}")
	public UserDto update(@PathVariable("id") Integer id,
						  @RequestBody UserDto dto) {
		User entity = userMapStruct.fromDto2Entity(dto);
		User dbEntity = userService.selectByPrimaryKey(id);
		BeanUtils.copyProperties(entity, dbEntity);
		userService.updateByPrimaryKey(dbEntity);
		return userMapStruct.fromEntity2Dto(dbEntity);
	}

	@ApiOperation(value = "根据id删除指定的User", notes = "")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "", dataType = "Integer", paramType = "path"),
	})
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userService.deleteByPrimaryKey(id);
	}

}
