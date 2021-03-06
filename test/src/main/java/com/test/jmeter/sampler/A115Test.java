package com.test.jmeter.sampler;

import com.domain.biz.model.dto.netty.A115DTO;
import com.domain.biz.model.service.netty.A115MessageService;
import com.test.jmeter.BaseJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.lang.reflect.Field;
import java.util.Map;

public class A115Test extends BaseJavaSamplerClient {

    /**
     * @param map
     */
    public void addMessageBaseDataParamName(Map<String, String> map) {
        Field[] fields = A115DTO.class.getDeclaredFields();
        if (null != fields && fields.length > 0) {
            for (Field field : fields) {
                map.put(field.getName(), "");
            }
        }
    }


    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        getCoreMessageList().add(new A115MessageService());
        return super.runTest(javaSamplerContext);
    }

    public static void main(String[] args) {
        A115Test a = new A115Test();
        JavaSamplerContext javaSamplerContext = new JavaSamplerContext(a.getDefaultParameters());
        a.runTest(javaSamplerContext);
    }
}
