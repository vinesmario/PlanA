package com.test.jmeter.sampler;

import com.domain.biz.model.dto.netty.A114DTO;
import com.domain.biz.model.service.netty.A114MessageService;
import com.test.jmeter.BaseJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.lang.reflect.Field;
import java.util.Map;

public class A114Test extends BaseJavaSamplerClient {

    /**
     * @param map
     */
    public void addMessageBaseDataParamName(Map<String, String> map) {
        Field[] fields = A114DTO.class.getDeclaredFields();
        if (null != fields && fields.length > 0) {
            for (Field field : fields) {
                map.put(field.getName(), "");
            }
        }
    }

    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        getCoreMessageList().add(new A114MessageService());
        return super.runTest(javaSamplerContext);
    }

    public static void main(String[] args) {
        A114Test a = new A114Test();
        JavaSamplerContext javaSamplerContext = new JavaSamplerContext(a.getDefaultParameters());
        a.runTest(javaSamplerContext);
    }
}
