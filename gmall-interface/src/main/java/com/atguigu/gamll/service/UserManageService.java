package com.atguigu.gamll.service;


import com.atguigu.gamll.bean.UserAddress;
import com.atguigu.gamll.bean.UserInfo;

import java.util.List;

public interface UserManageService {

    public List<UserInfo> getUserInfoListAll();
    public void addUser(UserInfo userInfo);
    public void updateUser(String id,UserInfo userInfo);
    public List<UserAddress> getUserAddressList(String userId);

    List<UserInfo> getUserInfoList(UserInfo userInfo);

    void addUserInfo(UserInfo userInfo);

    void updateUserInfo(UserInfo userInfo);

    void delete(UserInfo userInfo);

    UserInfo getUserInfo(UserInfo userInfoQuery);
}

