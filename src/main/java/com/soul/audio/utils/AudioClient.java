package com.soul.audio.utils;

import com.baidu.aip.speech.AipSpeech;

/**
 * 百度语音识别调用客户端
 */
public class AudioClient {
    private static final String APP_ID = "11085307";
    private static final String API_KEY = "umovmpuI95znZfcG5MNr9otc";
    private static final String SECRET_KEY = "8ja1spdAGoWbcvTOcSxb6NDviQVRticK";

    private static AipSpeech client = null;

    static {
        // 初始化一个AipSpeech
        client = new AipSpeech(APP_ID,API_KEY,SECRET_KEY);

        //设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        //设置代理服务器地址，http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

    }


    public static AipSpeech getInstace(){
        return client;
    }

}
