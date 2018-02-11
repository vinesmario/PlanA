<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.icsp.controller.web;

{basepackage}.client.${className}Client;
{basepackage}.comm.AbstractVoController;
{basepackage}.comm.dto.RetDto;
{basepackage}.comm.dto.RetVo;
{basepackage}.comm.dto.icsp.${className}DTO;
{basepackage}.comm.util.StringUtils;
{basepackage}.icsp.mapstruct.${className}MapStruct;
{basepackage}.icsp.vo.req.${className}ReqVo;
{basepackage}.icsp.vo.rsp.${className}RspVo;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author maodipu
 * @date 2018-01-18
 */

@Api(description = "${className}CRUD",tags = "${className}Controller",basePath = "/${classNameLower}s")
@RestController
@RequestMapping("/api/v1/${table.sqlName}")
public class ${className}Controller extends AbstractVoController{

	@Resource
	${className}Client ${classNameLower}Client;

    @Resource
	${className}MapStruct ${classNameLower}MapStruct;

    @ApiOperation(value="分页查询列表", notes="")
    @ApiResponse(code = 200,message = "",response = PageInfo.class)
	@RequestMapping(value = "/page",method = RequestMethod.GET)
	public RetVo<PageInfo<${className}RspVo>> page(@RequestParam("pageNum") Integer pageNum,
                                                    @RequestParam("pageSize") Integer pageSize,
                                                    @RequestParam("orderByColName") String orderByColName,
                                                    @RequestParam("ascOrDesc") String ascOrDesc) {
        RetVo retVo = this.build(HttpStatus.OK.value(), HttpStatus.OK.name());
        String orderByClause = null;
        if (StringUtils.isNotBlank(orderByColName)) {
            orderByClause = StringUtils.camel2Underline(orderByColName).toLowerCase() + " " + ascOrDesc;
        }
        RetDto<PageInfo<${className}DTO>> dtoPageRet = ${classNameLower}Client.page(pageNum, pageSize, orderByClause);
        //对象空判断
        if (null == dtoPageRet) {
            retVo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            retVo.setMessage("失败,服务器错误");
            return retVo;
        }
        //失败处理
        if (HttpStatus.OK.value() != dtoPageRet.getCode()) {
            retVo.setCode(dtoPageRet.getCode());
            retVo.setMessage(dtoPageRet.getMessage());
            return retVo;
        }
        PageInfo<${className}DTO> dtoPage = dtoPageRet.getData();
        //没有数据
        if (null == dtoPage || null == dtoPage.getList() || dtoPage.getList().isEmpty()) {
            retVo.setMessage("没有列表数据");
            return retVo;
        }

        PageInfo<${className}RspVo> rspVoPage = new PageInfo<>();
        BeanUtils.copyProperties(dtoPage, rspVoPage);
        rspVoPage.setList(${classNameLower}MapStruct.fromDTOs2RspVos(dtoPage.getList()));
        retVo.setData(rspVoPage);
        return retVo;
	}

    @ApiOperation(value="查询列表", notes="")
    @ApiResponse(code = 200,message = "",response = PageInfo.class)
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public RetVo<List<${className}RspVo>> list() {
        RetVo retVo = this.build(HttpStatus.OK.value(), HttpStatus.OK.name());
        RetDto<List<${className}DTO>> dtoListRet = ${classNameLower}Client.list();
        //对象空判断
        if (null == dtoListRet) {
            retVo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            retVo.setMessage("失败,服务器错误");
            return retVo;
        }
        //失败处理
        if (HttpStatus.OK.value() != dtoListRet.getCode()) {
            retVo.setCode(dtoListRet.getCode());
            retVo.setMessage(dtoListRet.getMessage());
            return retVo;
        }
        List<${className}DTO> dtoList = dtoListRet.getData();
        //没有数据
        if (null == dtoList || dtoList.isEmpty()) {
            retVo.setMessage("没有列表数据");
            return retVo;
        }

        List<${className}RspVo> rspVoList = ${classNameLower}MapStruct.fromDTOs2RspVos(dtoList);
        retVo.setData(rspVoList);
        return retVo;
    }

    @ApiOperation(value="根据id查询指定的${className}", notes="")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "",dataType = "Integer",paramType = "path"),
    })
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public RetVo<${className}RspVo> get(@PathVariable("id") Integer id){
        RetVo retVo = this.build(HttpStatus.OK.value(), HttpStatus.OK.name());
        RetDto<${className}DTO> dtoRet = ${classNameLower}Client.get(id);
        //对象空判断
        if (null == dtoRet) {
            retVo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            retVo.setMessage("失败,服务器错误");
            return retVo;
        }
        //失败处理
        if (HttpStatus.OK.value() != dtoRet.getCode()) {
            retVo.setCode(dtoRet.getCode());
            retVo.setMessage(dtoRet.getMessage());
            return retVo;
        }
        ${className}DTO dto = dtoRet.getData();
        //没有数据
        if (null == dto) {
            retVo.setMessage("没有数据");
            return retVo;
        }
        ${className}RspVo rspVo = ${classNameLower}MapStruct.fromDTO2RspVo(dto);
        retVo.setData(rspVo);
        return retVo;
	}

    @ApiOperation(value="新增${className}", notes="")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "",dataType = "Integer",paramType = "path"),
    })
    @RequestMapping(value = "",method = RequestMethod.POST)
	public RetVo<${className}RspVo> add(@RequestBody ${className}ReqVo reqVo) {
        RetVo retVo = build(HttpStatus.OK.value(), HttpStatus.OK.name());
        if (true) {
            retVo.setCode(HttpStatus.BAD_REQUEST.value());
            retVo.setMessage("无效的参数：parkingId");
            return retVo;
        }
        ${className}DTO dto = ${classNameLower}MapStruct.fromReqVo2DTO(reqVo);
        //TODO createBy updateBy
        RetDto<${className}DTO> retDto = ${classNameLower}Client.add(dto);
        //对象空判断
        if (null == retDto) {
            retVo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            retVo.setMessage("失败,服务器错误");
            return retVo;
        }
        //失败处理
        if (HttpStatus.OK.value() != retDto.getCode()) {
            retVo.setCode(retDto.getCode());
            retVo.setMessage(retDto.getMessage());
            return retVo;
        }
        //数据为空
        if (null == retDto.getData()) {
            retVo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            retVo.setMessage("失败,服务器错误");
            return retVo;
        }
        ${className}RspVo rspVo = ${classNameLower}MapStruct.fromDTO2RspVo(retDto.getData());
        retVo.setData(rspVo);
        return retVo;
	}

    @ApiOperation(value="更新指定的${className}", notes="")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "",dataType = "Integer",paramType = "path"),
    })
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public RetVo<${className}RspVo> update(@PathVariable("id") Integer id,
                                            @RequestBody ${className}ReqVo reqVo) {
        RetVo retVo = build(HttpStatus.OK.value(), HttpStatus.OK.name());
        if (true) {
            retVo.setCode(HttpStatus.BAD_REQUEST.value());
            retVo.setMessage("无效的参数：parkingId");
            return retVo;
        }
        ${className}DTO dto = ${classNameLower}MapStruct.fromReqVo2DTO(reqVo);
        //TODO createBy updateBy
        RetDto<${className}DTO> retDto = ${classNameLower}Client.update(id, dto);
        //对象空判断
        if (null == retDto) {
            retVo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            retVo.setMessage("失败,服务器错误");
            return retVo;
        }
        //失败处理
        if (HttpStatus.OK.value() != retDto.getCode()) {
            retVo.setCode(retDto.getCode());
            retVo.setMessage(retDto.getMessage());
            return retVo;
        }
        //数据为空
        if (null == retDto.getData()) {
            retVo.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            retVo.setMessage("失败,服务器错误");
            return retVo;
        }
        ${className}RspVo rspVo = ${classNameLower}MapStruct.fromDTO2RspVo(retDto.getData());
        retVo.setData(rspVo);
        return retVo;
	}

    @ApiOperation(value="根据id删除指定的${className}", notes="")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, defaultValue = "",dataType = "Integer",paramType = "path"),
    })
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
        ${classNameLower}Client.delete(id);
    }

}
