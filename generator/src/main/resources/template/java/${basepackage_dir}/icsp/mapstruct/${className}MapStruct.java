<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.icsp.mapstruct;

{basepackage}.comm.dto.icsp.${className}DTO;
{basepackage}.icsp.vo.req.${className}ReqVo;
{basepackage}.icsp.vo.rsp.${className}RspVo;
{basepackage}.core.entity.${className};
import org.mapstruct.Mapper;

/**
 * @author maodipu
 * @date 2018-01-18
 */

@Mapper(componentModel = "spring")
public interface ${className}MapStruct {

	${className}DTO fromReqVo2DTO(${className}ReqVo reqVo);

	${className}RspVo fromDTO2RspVo(${className}DTO dto);

	List<${className}RspVo> fromDTOs2RspVos(List<${className}DTO> dtos);

	${className}DTO fromEntity2DTO(${className} entity);

	${className} fromDTO2Entity(${className}DTO dto);

	List<${className}DTO> fromEntities2DTOs(List<${className}> entities);

	List<${className}> fromDTOs2Entities(List<${className}DTO> dtos);

}
