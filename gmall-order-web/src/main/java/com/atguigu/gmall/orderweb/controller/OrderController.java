package com.atguigu.gmall.orderweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.atguigu.gamll.bean.UserAddress;
import com.atguigu.gamll.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {

    @Reference
    UserManageService userManageService;

    @ResponseBody
    @RequestMapping(value = "initOrder")
    public String initOrder(HttpServletRequest request){
        String userId = request.getParameter("userId");
        List<UserAddress> userAddressList = userManageService.getUserAddressList(userId);
        String jsonString = JSON.toJSONString(userAddressList);
        return  jsonString;

    }
}
