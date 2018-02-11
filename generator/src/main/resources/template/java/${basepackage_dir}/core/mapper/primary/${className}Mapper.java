<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.core.mapper.primary;

{basepackage}.core.entity.${className};
{basepackage}.core.entity.${className}Example;

/**
 * @author maodipu
 * @date 2018-01-18
 */

public interface ${className}Mapper {

	List<${className}> selectByExample(${className}Example example);

	${className} selectByPrimaryKey(Integer id);

	void deleteByPrimaryKey(Integer id);

	void deleteByExample(${className}Example example);

	void insert(${className} ${classNameLower});

	void updateByPrimaryKey(${className} ${classNameLower});

}
