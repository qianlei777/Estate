package com.kgc.estate.controller;

import com.kgc.estate.pojo.User;
import com.kgc.estate.service.addUser.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class AddContriller {
    @Resource
    UserService userService;


    @RequestMapping("/yan.do")
    @ResponseBody
    public boolean yan(String cardid){
        boolean flag=false;
        if (userService.selectID(cardid)>0){
            flag=true;
        }
        return flag;
    }

    @RequestMapping("/add.do")
    public String addUser(User user){
        int chang=user.getCardid().length();
        int xing=Integer.parseInt(String.valueOf(user.getCardid().charAt(chang-1)));
        user.setGender(xing);
        user.setCreatetime(new Date());
        user.setStatus(1);
        if (userService.addUser(user)>0){
            return "login";
        }else {
         return "singin";
        }
    }

    @RequestMapping("/tui.do")
    public String exit(HttpSession session){
        session.invalidate();
        return "login";
    }

    @RequestMapping("zhu.do")
    public String test(){
        return "singin";
    }
}
