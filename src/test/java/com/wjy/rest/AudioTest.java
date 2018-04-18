package com.wjy.rest;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class AudioTest {
    private static final String APP_ID = "11085307";
    private static final String API_KEY = "umovmpuI95znZfcG5MNr9otc";
    private static final String SECRET_KEY = "8ja1spdAGoWbcvTOcSxb6NDviQVRticK";

    public static void main(String[] args) {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID,API_KEY,SECRET_KEY);

        //设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        //设置代理服务器地址，http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 语音识别调用接口
        JSONObject res = client.asr("D:\\Program Files\\ffmpeg-20180411-9825f77-win64-static\\bin\\test6.pcm", "pcm", 16000, null);
        try {
            System.out.println(res.toString(2));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // 调用接口
//        TtsResponse res = client.synthesis("阿莫西林", "zh", 1, null);
//        byte[] data = res.getData();
//        JSONObject res1 = res.getResult();
//        if (data != null) {
//            try {
//                Util.writeBytesToFileSystem(data, "阿莫西林4.mp3");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        if (res1 != null) {
//            System.out.println(res1.toString(2));
//        }
    }
}
