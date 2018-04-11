package com.atguigu.gmall.orderweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.atguigu.gamll.bean.UserAddress;
import com.atguigu.gamll.service.UserManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @param
 * @return
 */

@Controller
public class OrderController {

    @Reference
    UserManageService userManageService;

    @RequestMapping("trade")
    @ResponseBody
    public String trade(HttpServletRequest httpServletRequest){
        String userId = httpServletRequest.getParameter("userId");
        List<UserAddress> userAddressList = userManageService.getUserAddressList(userId);
        String s = JSON.toJSONString(userAddressList);
        return s;
    }

}
