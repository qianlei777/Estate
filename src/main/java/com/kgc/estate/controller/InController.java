package com.kgc.estate.controller;

import com.kgc.estate.pojo.User;
import com.kgc.estate.service.login.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@Controller
public class InController {

    @Autowired
    UserService userService;

    @RequestMapping("/login.do")
    public String login1(User user, HttpSession session, HttpServletResponse response) throws IOException {
        PrintWriter out= response.getWriter();
        List<User> user1 = userService.getUser(user);
        System.out.println("1111");
        System.out.println(user1.size());
        if(user1.get(0).getStatus()>0){
            out.write("<script>alert('账户已冻结');location.href='loginn.do'</script>");

        }else
        if(user1.size()>0){
            session.setAttribute("name",user1.get(0));
            return "main";
        }
        response.setContentType("text/html;charset=UTF-8");
        out.write("<script>alert('用户名或密码错误');location.href='loginn.do'</script>");
        return null;
    }

    @RequestMapping("/loginn.do")
    public String login2(){
        System.out.println("1111");
       return "Login";
    }
}
