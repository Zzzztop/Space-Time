package com.ztop.admin.service;

import com.ztop.admin.bean.UserInfo;
import com.ztop.admin.bean.vo.ResponseData;


public interface AccountService {

    ResponseData login(String name ,String pwd);

    ResponseData register(UserInfo userInfo);

    ResponseData sendEmailCaptcha(String email);
}
