package com.test.jmeter.sampler;

import com.common.model.dto.netty.A110DTO;
import com.common.model.service.netty.A110MessageService;
import com.test.jmeter.BaseJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class A110Test extends BaseJavaSamplerClient {

    private Map<String, String> paramsMap = new HashMap<>();

    /**
     * @param map
     */
    public void addMessageBaseDataParamName(Map<String, String> map) {
        Field[] fields = A110DTO.class.getDeclaredFields();
        if (null != fields && fields.length > 0) {
            for (Field field : fields) {
                map.put(field.getName(), "");
            }
        }

    }

    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        getCoreMessageList().add(new A110MessageService());
        return super.runTest(javaSamplerContext);
    }

    public static void main(String[] args) {
        A110Test a = new A110Test();
        JavaSamplerContext javaSamplerContext = new JavaSamplerContext(a.getDefaultParameters());
        a.runTest(javaSamplerContext);
        a.runTest(javaSamplerContext);
    }


}
