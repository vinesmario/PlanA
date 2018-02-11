<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.common.client;

{basepackage}.common.dto.RetDto;
{basepackage}.comm.dto.icsp.${className}DTO;
import com.github.pagehelper.PageInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 <#if table.remarks?exists && table.remarks != '' && table.remarks != 'null'>
 * ${table.remarks}
 </#if>
 * @author:vinesmario
 * @version:1.0
 * @since:1.0
 * @createTime:<#if now??>${now?string('yyyy-MM-dd HH:mm:ss')}</#if>
 */
@FeignClient(name = "mgr-service", path = "/resource/v1/${classNameLower}s")
public interface ${className}Client {

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	RetDto<PageInfo<${className}DTO>> page(@RequestParam("pageNum") Integer pageNum,
                                            @RequestParam("pageSize") Integer pageSize,
                                            @RequestParam(value = "orderByClause", required = false) String orderByClause);

    @RequestMapping(value = "/list", method = RequestMethod.GET)
	RetDto<List<${className}DTO>> list(@RequestParam(value = "orderByClause", required = false) String orderByClause);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	RetDto<${className}DTO> get(@PathVariable("id") Integer id);

    @RequestMapping(value = "", method = RequestMethod.POST)
	RetDto<${className}DTO> add(@RequestBody ${className}DTO ${classNameLower});

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	RetDto<${className}DTO> update(@PathVariable("id") Integer id,
                                   @RequestBody ${className}DTO ${classNameLower});

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") Integer id);
	
}
