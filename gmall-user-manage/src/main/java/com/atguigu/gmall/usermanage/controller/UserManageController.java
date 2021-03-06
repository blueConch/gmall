package com.atguigu.gmall.usermanage.controller;

import com.atguigu.gamll.bean.UserInfo;
import com.atguigu.gamll.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @param
 * @return
 */
@RestController
public class UserManageController {

    @Autowired
    UserManageService userManageService;

    @RequestMapping("userList")
    public ResponseEntity<List<UserInfo>> userList(){
        List<UserInfo> userInfoListAll = userManageService.getUserInfoListAll();
        return  ResponseEntity.ok(userInfoListAll);
    }

    @RequestMapping(value = "/user" ,method = RequestMethod.POST)
    public    ResponseEntity<Void> add(UserInfo userInfo){ ;

        userManageService.addUser(userInfo);
        System.out.println("userInfo = " + userInfo);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/user" ,method = RequestMethod.PUT)
    public    ResponseEntity<Void> update(UserInfo userInfo){
        userManageService.updateUser(userInfo.getId(),userInfo);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/user" ,method = RequestMethod.DELETE)
    public    ResponseEntity<Void> delete(UserInfo userInfo){
        //   userService.delete(userInfo);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/user" ,method = RequestMethod.GET)
    public    ResponseEntity<UserInfo> getUserInfo(UserInfo userInfoQuery){
        //UserInfo userInfo = userService.getUserInfo(userInfoQuery);
        return ResponseEntity.ok().body(new UserInfo());
    }



}
