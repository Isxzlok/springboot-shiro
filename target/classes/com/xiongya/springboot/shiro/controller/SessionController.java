package com.xiongya.springboot.shiro.controller;

import com.xiongya.springboot.shiro.entity.UserOnline;
import com.xiongya.springboot.shiro.reponse.ResponseBo;
import com.xiongya.springboot.shiro.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author xiongzhilong
 * @Email 2584496774@qq.com
 * @Date create by 2019-07-01 15:00
 */
@Controller
@RequestMapping("/online")
public class SessionController {

    @Autowired
    SessionService sessionService;

    @RequestMapping("index")
    public String online(){
        return "online";
    }

    @ResponseBody
    @RequestMapping("list")
    public List<UserOnline> list(){
        return sessionService.list();
    }

    @ResponseBody
    @RequestMapping("forceLogout")
    public ResponseBo forceLogout(String id){
        try{
            sessionService.forceLogout(id);
            return ResponseBo.ok();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseBo.error("踢出用户失败");
        }
    }

}
