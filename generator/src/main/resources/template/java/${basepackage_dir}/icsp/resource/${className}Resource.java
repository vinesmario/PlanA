<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.icsp.resource;

{basepackage}.comm.AbstractController;
{basepackage}.comm.dto.RetDto;
{basepackage}.comm.dto.icsp.${className}DTO;
{basepackage}.icsp.service.I${className}Service;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author maodipu
 * @date 2018-01-18
 */

@RestController
@RequestMapping("/resource/v1/${classNameLower}s")
public class ${className}Resource  extends AbstractController{

	@Resource
	I${className}Service ${classNameLower}Service;

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public RetDto<PageInfo> page(@RequestParam("pageNum") Integer pageNum,
                         		 @RequestParam("pageSize") Integer pageSize,
								 @RequestParam("orderByClause") String orderByClause) {
        ${className}DTO dto = new ${className}DTO();
        PageInfo<${className}DTO> page = ${classNameLower}Service.findPage(pageNum, pageSize, orderByClause, dto);
        return build(page);
	}

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public RetDto<List<${className}DTO>> list() {
        ${className}DTO dto = new ${className}DTO();
        List<${className}DTO> list = ${classNameLower}Service.findList(dto);
        return build(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public RetDto<${className}DTO> get(@PathVariable("id") Integer id){
        ${className}DTO dto = ${classNameLower}Service.selectByPrimaryKey(id);
        return build(dto);
	}

    @RequestMapping(value = "", method = RequestMethod.POST)
	public RetDto<${className}DTO> add(@RequestBody ${className}DTO dto) {
        ${classNameLower}Service.save(dto);
        return build(dto);
	}

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public RetDto<${className}DTO> update(@PathVariable("id") Integer id, @RequestBody ${className}DTO dto) {
        ${className}DTO dbDto = ${classNameLower}Service.selectByPrimaryKey(id);
        BeanUtils.copyProperties(dto, dbDto);
        ${classNameLower}Service.updateByPrimaryKey(dbDto);
        return build(dbDto);
	}

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id) {
        ${classNameLower}Service.deleteByPrimaryKey(id);
    }
	
}
