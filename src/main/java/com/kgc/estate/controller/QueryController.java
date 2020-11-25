package com.kgc.estate.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.estate.pojo.Estate;
import com.kgc.estate.pojo.User;
import com.kgc.estate.service.query.EstateService;
import com.kgc.estate.service.query.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class QueryController {
    @Resource
    EstateService estateService;
    @Resource
    UserService userService;

    //跳到查询页面

//    @RequestMapping("/query.do")
//    public String query() {
//        return "query";
//    }

    //分页
    @RequestMapping("/paging.do")
    public String paging(String query, String val, Integer pageNum, Integer pageSize, Model model) {
        PageInfo<Estate> pageInfo = null;
        pageSize = 2;
        if (pageNum == null) {
            pageNum = 1;
        }
        if (query == null && val == null) {
            val = "";
            pageInfo = estateService.getEstateList(val, pageNum, pageSize);
        }
        if (query != null && query.equals("用户名") && val != null) {
            String name = userService.getUserCardIdByUserName(val);
            pageInfo = estateService.getEstateList(name, pageNum, pageSize);
        }
        if (query != null && query.equals("身份证") && val != null) {
            pageInfo = estateService.getEstateList(val, pageNum, pageSize);
        }

        model.addAttribute("query", query);
        model.addAttribute("val", val);


        model.addAttribute("pageInfo", pageInfo);

        return "query";
    }

}
