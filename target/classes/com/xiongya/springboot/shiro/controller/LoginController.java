package com.xiongya.springboot.shiro.controller;

import com.xiongya.springboot.shiro.entity.User;
import com.xiongya.springboot.shiro.reponse.ResponseBo;
import com.xiongya.springboot.shiro.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @Author xiongzhilong
 * @Email 2584496774@qq.com
 * @Date create by 2019-06-14 16:52
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseBo login(String username, String password, Boolean rememberMe){
        //密码MD5加密
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        //获取subject对象
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            return ResponseBo.ok();
        }catch (UnknownAccountException e){
            return ResponseBo.error(e.getMessage());
        }catch (IncorrectCredentialsException e){
            return ResponseBo.error(e.getMessage());
        }catch (LockedAccountException e){
            return ResponseBo.error(e.getMessage());
        }catch (AuthenticationException e){
            return ResponseBo.error("认证失败！");
        }
    }

    @RequestMapping("/")
    public String redirectIndex(){

        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model){
        //登录成功后，即可通过subject获取登录的用户信息
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";

    }

    @GetMapping("/403")
    public String forbid(){
        return "403";
    }

}
