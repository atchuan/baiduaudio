package com.soul.audio.controller;

import com.soul.audio.utils.AudioClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("/audio")
public class AudioController {

    /**
     * 跳转到音频录制页面
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public String saveAudio(MultipartFile audioData){
        if(audioData == null || audioData.isEmpty()){
            return "数据不能为空";
        }
        byte[] bytes = new byte[0];
        try {
            bytes = audioData.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HashMap<String,Object> options = new HashMap<String, Object>();
        options.put("dev_pid",1836);
        return AudioClient.getInstace().asr(bytes,"pcm",16000,options).toString();
    }


}
