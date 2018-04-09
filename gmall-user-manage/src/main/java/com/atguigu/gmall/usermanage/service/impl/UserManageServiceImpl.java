package com.atguigu.gmall.usermanage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gamll.bean.UserAddress;
import com.atguigu.gamll.bean.UserInfo;
import com.atguigu.gmall.usermanage.mapper.UserAddressMapper;
import com.atguigu.gmall.usermanage.mapper.UserInfoMapper;
import com.atguigu.gamll.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class UserManageServiceImpl implements UserManageService{
    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserAddressMapper userAddressMapper;

    @Override
    public List<UserInfo> getUserInfoListAll(){
        List<UserInfo> userInfos = userInfoMapper.selectAll();
        UserInfo userinfoQuery =new UserInfo();
        userinfoQuery.setLoginName("chenge");
        List<UserInfo> userInfos1 = userInfoMapper.select(userinfoQuery);

        Example example=new Example(UserInfo.class);
        example.createCriteria().andLike("name" ,"张%").andEqualTo("id","3");
        List<UserInfo> userInfos2 = userInfoMapper.selectByExample(example);

        return userInfos2;
    }

    @Override
    public void addUser(UserInfo userInfo){
        userInfoMapper.insert(userInfo);
    }

    @Override
    public void updateUser(String id,UserInfo userInfo){
        Example example=new Example(UserInfo.class);
        example.createCriteria().andLike("name" ,"张%").andEqualTo("id","3");
        userInfoMapper.updateByExampleSelective(userInfo,example);

    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        List<UserAddress> addressList = null;
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        addressList = userAddressMapper.select(userAddress);
        return addressList;
    }

    @Override
    public List<UserInfo> getUserInfoList(UserInfo userInfo) {
        return null;
    }

    @Override
    public void addUserInfo(UserInfo userInfo) {

    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {

    }

    @Override
    public void delete(UserInfo userInfo) {

    }

    @Override
    public UserInfo getUserInfo(UserInfo userInfoQuery) {
        return null;
    }


}
