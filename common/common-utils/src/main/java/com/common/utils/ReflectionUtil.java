package com.common.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectionUtil {
    /**
     * Used to generate map of class fields where key is field value and value is field name.
     */
    public static Map<Integer, String> generateMapOfValueNameInteger(Class<?> clazz) {
        Map<Integer, String> valuesName = new HashMap<Integer, String>();
        try {
            for (Field field : clazz.getFields()) {
                valuesName.put((Integer) field.get(int.class), field.getName());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return valuesName;
    }

    /**
     * Used to generate map of class fields where key is field value and value is field name.
     */
    public static Map<Short, String> generateMapOfValueNameShort(Class<?> clazz) {
        Map<Short, String> valuesName = new HashMap<Short, String>();
        try {
            for (Field field : clazz.getFields()) {
                if (field.getType().isPrimitive()) {
                    valuesName.put((Short) field.get(short.class), field.getName());
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return valuesName;
    }

    public static Object castTo(Class type, String value) {
        if (type == byte.class || type == Byte.class) {
            return Byte.valueOf(value);
        }
        if (type == short.class || type == Short.class) {
            return Short.valueOf(value);
        }
        if (type == int.class || type == Integer.class) {
            return Integer.valueOf(value);
        }
        if (type == long.class || type == Long.class) {
            return Long.valueOf(value);
        }
        if (type == boolean.class || type == Boolean.class) {
            return Boolean.valueOf(value);
        }
        return value;
    }

    /**
     * 将一个map集合封装成为bean对象
     *
     * @param param
     * @param clazz
     * @return
     */
    public static <T> T MapToBean(Map<String, Object> param, Class<T> clazz) {
        Object value = null;
        T bean = null;

        try {
            bean = clazz.newInstance();
            // 获取类的属性
            Field[] declaredFields = clazz.getDeclaredFields();
            // 获取父类或接口的公有属性
            Field[] superFields = clazz.getSuperclass().getFields();
            List<Field[]> list = new ArrayList<Field[]>();
            if (declaredFields != null) {
                list.add(declaredFields);
            }
            if (superFields != null) {
                list.add(superFields);
            }
            for (Field[] fields : list) {
                for (Field field : fields) {
                    String fieldName = field.getName();
                    // 获取属性对应的值ֵ
                    value = param.get(fieldName);
                    // 把值设置进入对象属性中 这里可能是有属性但是没有相应的set方法，所以要做异常处理
                    try {
                        PropertyDescriptor pd = new PropertyDescriptor(fieldName, clazz);
                        Method method = pd.getWriteMethod();
                        method.invoke(bean, new Object[]{value});
                    } catch (Exception e1) {
                    }
                }
            }
        } catch (Exception e1) {
        }
        return bean;
    }


}
