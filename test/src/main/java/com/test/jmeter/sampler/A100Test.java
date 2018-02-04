package com.test.jmeter.sampler;

import com.test.jmeter.BaseJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.util.Map;

public class A100Test extends BaseJavaSamplerClient {

    public void addMessageBaseDataParamName(Map<String, String> map) {
    }

    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        return super.runTest(javaSamplerContext);
    }

    public static void main(String[] args) {
        A100Test a = new A100Test();
        JavaSamplerContext javaSamplerContext = new JavaSamplerContext(a.getDefaultParameters());
        a.runTest(javaSamplerContext);
    }
}
