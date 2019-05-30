package com.ztop.admin.mapper;

import com.ztop.admin.bean.UserInfo;

/**
 * @Author ZhouJianGuo
 * @Date 2019/5/22 17:54
 * @Version 1.0
 **/
public interface UserInfoMapper {

    UserInfo getUserInfoByName(String email);

    void saveUserInfo(UserInfo userInfo);
}
