<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.icsp.service;

{basepackage}.comm.dto.icsp.${className}DTO;
import com.github.pagehelper.PageInfo;

/**
 * @author maodipu
 * @date 2018-01-18
 */

public interface I${className}Service {

	PageInfo<${className}DTO> findPage(Integer pageNum, Integer pageSize, String orderByClause,
									   ${className}DTO conditionDTO);

	List<${className}DTO> findList(${className}DTO conditionDTO);

	${className}DTO selectByPrimaryKey(Integer id);

	void deleteByPrimaryKey(Integer id);

	void save(${className}DTO recordDTO);

	void updateByPrimaryKey(${className}DTO recordDTO);





}
