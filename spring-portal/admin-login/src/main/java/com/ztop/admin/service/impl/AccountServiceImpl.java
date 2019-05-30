package com.ztop.admin.service.impl;

import com.ztop.admin.Utils.DateUtil;
import com.ztop.admin.Utils.Md5Util;
import com.ztop.admin.bean.UserInfo;
import com.ztop.admin.bean.vo.ResponseData;
import com.ztop.admin.mapper.UserInfoMapper;
import com.ztop.admin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.UUID;

/**
 * @Author ZhouJianGuo
 * @Date 2019/5/22 17:01
 * @Version 1.0
 **/
@Service
public class AccountServiceImpl implements AccountService {

    private static String TOKENPOSTFIX = "__Zzz_";

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public ResponseData login(String name, String pwd) {
        ResponseData responseData = new ResponseData();
        UserInfo userInfo = userInfoMapper.getUserInfoByName(name);
        if (null == userInfo || null == userInfo.getId()){
            responseData.setCode("1");
            responseData.setMsg("该用户未注册");
            return  responseData;
        }
        if (!userInfo.getPassword().equals(pwd)){
            responseData.setCode("2");
            responseData.setMsg("用户名或密码不正确");
            return  responseData;
        }
        responseData.setCode("0");
        responseData.setMsg("登陆成功");
        return responseData;
    }

    @Override
    public ResponseData register(UserInfo userInfo) {
        ResponseData responseData = new ResponseData();
        if (StringUtils.isEmpty(userInfo.getEmail())){
            responseData.setCode("1");
            responseData.setMsg("邮箱不能为空");
            return responseData;
        }
        UserInfo user = userInfoMapper.getUserInfoByName(userInfo.getEmail());
        if (null != user){
            responseData.setCode("2");
            responseData.setMsg("该邮箱已经注册");
            return responseData;
        }
        String token = Md5Util.getMD5Str(UUID.randomUUID().toString().substring(8,24).toLowerCase()+(System.currentTimeMillis()/1000)+TOKENPOSTFIX);
        userInfo.setToken(token);
        userInfo.setCreate_time(DateUtil.getChinaDate());
        userInfoMapper.saveUserInfo(userInfo);
        responseData.setCode("0");
        responseData.setMsg("注册成功");
        return responseData;
    }
}
