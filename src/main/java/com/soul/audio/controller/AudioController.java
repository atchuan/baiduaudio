package com.soul.audio.controller;

import com.soul.audio.utils.AudioClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@Controller
@RequestMapping("/audio")
public class AudioController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 跳转到音频录制页面
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public String saveAudio(MultipartFile audioData,
                            @RequestParam(required = false,defaultValue = "1837") Integer language){
        logger.info("选择语言{}",language);
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
        if(language != null){
            /*
             * 1536-普通话(支持简单的英文识别)	搜索模型	无标点	支持自定义词库
             * 1537-普通话(纯中文识别)	输入法模型	有标点	不支持自定义词库
             * 1737-英语		有标点	不支持自定义词库
             * 1637-粤语		有标点	不支持自定义词库
             * 1837-四川话		有标点	不支持自定义词库
             * 1936-普通话远场	远场模型	有标点	不支持
             */
            options.put("dev_pid",language);
        }
        return AudioClient.getInstace().asr(bytes,"pcm",8000,options).toString();
    }


}
