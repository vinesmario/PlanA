package com.common.mybatis.interceptor;

import com.uaa.model.po.User;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMap;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Date;
import java.util.Properties;

/**
 * 插入,更新 执行的操作是 先操作, 后记录. 删除 执行的操作是 先记录, 后操作.
 * 也就是说, 审计表中插入的都是最 新的快照
 */

// TODO type 与 method配置 在insert、update、delete语句执行的前or后
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
public class AuditingInterceptor implements Interceptor {

	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
		SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
		// TODO 获取xml中id=Base_Column_List的数据表字段列表

		// TODO id如何获取
		// id=insert、insertSelective，后selectByPrimaryKey

		// TODO where条件部分如何获取
		// id=updateByPrimaryKeySelective、updateByPrimaryKey，后selectByPrimaryKey
		// id=updateByExampleSelective、updateByExample，后selectByExample

		// TODO
		// deleteByPrimaryKey，先selectByPrimaryKey
		// deleteByExample，先selectByExample
		ParameterMap parameterMap = mappedStatement.getParameterMap();
		Collection<ResultMap> resultMaps = mappedStatement.getConfiguration().getResultMaps();

		Object parameter = invocation.getArgs()[1];
		Field[] fields = parameter.getClass().getDeclaredFields();

		Date currentDate = new Date();
		User currentUser = new User();
		currentUser.setId(1L);
		if (SqlCommandType.UPDATE == sqlCommandType) {
			for (Field field : fields) {
				if (AnnotationUtils.getAnnotation(field, LastModifiedBy.class) != null) {
					field.setAccessible(true);
					field.set(parameter, currentUser.getId());
					field.setAccessible(false);
				}
				if (AnnotationUtils.getAnnotation(field, LastModifiedDate.class) != null) {
					field.setAccessible(true);
					field.set(parameter, currentDate);
					field.setAccessible(false);
				}
			}
		} else if (SqlCommandType.INSERT == sqlCommandType) {
			for (Field field : fields) {
				if (AnnotationUtils.getAnnotation(field, CreatedBy.class) != null) {
					field.setAccessible(true);
					field.set(parameter, currentUser.getId());
					field.setAccessible(false);
				}
				if (AnnotationUtils.getAnnotation(field, CreatedDate.class) != null) {
					field.setAccessible(true);
					field.set(parameter, currentDate);
					field.setAccessible(false);
				}
			}
		}
		return invocation.proceed();
	}


	public Object plugin(Object target) {
		if (target instanceof Executor) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}


	public void setProperties(Properties properties) {

	}
}
