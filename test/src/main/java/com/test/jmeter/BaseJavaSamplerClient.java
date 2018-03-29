package com.test.jmeter;

import com.domain.common.constant.OpCodeEnum;
import com.domain.common.model.protobuf.Message;
import com.domain.biz.model.service.netty.A100MessageService;
import com.domain.biz.model.service.netty.BaseMessageService;
import com.netty.client.NettyClient;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class BaseJavaSamplerClient extends AbstractJavaSamplerClient {

    private Map<String, String> paramsMap = new HashMap<>();
    private List<BaseMessageService> coreMessageList = new LinkedList<>();

    /**
     * 设置参数的name
     */
    public Arguments getDefaultParameters() {
//        map.put("Host", "");//已作为常量添加
//        map.put("Port", "");//已作为常量添加
//        map.put("HeadFlag", "");//已在代码中处理
        paramsMap.put("HeadToken", "");//实际上是停车场编号ParkingId
        paramsMap.put("HeadMsgId", "");
//        map.put("BaseMacCode", "");//已在代码中处理
//        map.put("HeadDataLen", "");//已在代码中处理
        paramsMap.put("BaseOpCode", "");
//        map.put("BaseVer", "");//已作为常量添加
//        map.put("BaseParam", "");//已作为常量添加
//        map.put("BaseDataLen", "");//已在代码中处理
        paramsMap.put("username", "");//必备登录参数
        paramsMap.put("password", "");//必备登录参数
        addMessageBaseDataParamName(paramsMap);
        //设置公共参数的值
        Arguments params = new Arguments();
        for (String key : paramsMap.keySet()) {
            params.addArgument(key, null);
        }
        return params;
    }

    /**
     * 设置除登录外业务base data中参数的name，由子类实现
     *
     * @param map
     */
    public abstract void addMessageBaseDataParamName(Map<String, String> map);

    /**
     * 从容器中获取参数
     *
     * @param context
     */
    public void setupTest(JavaSamplerContext context) {
        getDefaultParameters();
        //获取对应字段的值
        for (String key : paramsMap.keySet()) {
            paramsMap.put(key, context.getParameter(key));
        }
    }

    /**
     * 执行测试
     *
     * @param javaSamplerContext
     * @return
     */
    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        // TODO
        paramsMap.put("HeadToken", "11115278");//实际上是停车场编号ParkingId
        paramsMap.put("HeadMsgId", "10000");
        paramsMap.put("BaseOpCode", Integer.toHexString(OpCodeEnum.PARK_IN_REPORT_REQUEST.getCode()));
        paramsMap.put("username", "ymt");//必备登录参数
        paramsMap.put("password", "123456");//必备登录参数

        paramsMap.put("parkingId", "11115278");
        paramsMap.put("clientSerial", "0001");
        paramsMap.put("wayNo", "10");
        paramsMap.put("wayName", "10号通道");
        paramsMap.put("license", "粤A 888888");
        paramsMap.put("inTime", "2017-12-03 12:23:02");
        paramsMap.put("carClass", "1");
        paramsMap.put("carType", "0");
        paramsMap.put("totalBerthCount", "100");
        paramsMap.put("emptyBerthCount", "80");
        paramsMap.put("inOpen", "1");
        paramsMap.put("openSerial", "P0001");

        System.out.println("Thread-" + Thread.currentThread().getName());

        SampleResult result = new SampleResult();
        result.setResponseCode("JmeterCode");
        result.setResponseMessage("JmeterMessage");
        try {
            result.sampleStart();
            String responseData = "";
            // 建立长连接
            NettyClient client = new NettyClient();
            client.connect("localhost", 8099);
            System.out.println("client:" + client.toString());
            System.out.println("before handler:" + client.getHandler());

            String parkingId = paramsMap.get("HeadToken");//实际上是停车场编号parkingId
            int msgId = Integer.parseInt(paramsMap.get("HeadMsgId"));
            A100MessageService loginMessage = new A100MessageService();
            // 登录
            Message.Head loginRequest = loginMessage.createMessageHead(paramsMap, true, parkingId, msgId);
            Message.Head loginResponse = client.getHandler().sendRequest(loginRequest);
            if (null != loginResponse) {
                // 判断登录状态并获取token
                String token = loginMessage.getToken(loginResponse);
                if (null != token && !"".equals(token)) {
                    //执行核心业务
                    if (null != coreMessageList && !coreMessageList.isEmpty()) {
                        for (BaseMessageService message : coreMessageList) {
                            Message.Head coreResponse = client.getHandler().sendRequest(message.createMessageHead(paramsMap, false, parkingId, ++msgId));
                            // TODO 核心业务分析
                            if (null != coreResponse) {
                                responseData = message.getResponseData(coreResponse);
                            }

                        }
                    }
                }
            }

            result.setResponseData(responseData);
            result.setDataType(SampleResult.TEXT);
            result.setSuccessful(true);
        } catch (Throwable e) {
            result.setSuccessful(false);
            e.printStackTrace();
        } finally {
            result.sampleEnd();
        }
        return result;
    }


    /**
     * 执行的核心业务列表
     *
     * @return
     */
    public List<BaseMessageService> getCoreMessageList() {
        return coreMessageList;
    }

    public void setCoreMessageList(List<BaseMessageService> coreMessageList) {
        this.coreMessageList = coreMessageList;
    }
}
