package com.ztop.admin.service.impl;

import com.ztop.admin.Utils.DateUtil;
import com.ztop.admin.Utils.Md5Util;
import com.ztop.admin.bean.UserInfo;
import com.ztop.admin.bean.vo.ResponseData;
import com.ztop.admin.mapper.EmailCaptchaMapper;
import com.ztop.admin.mapper.UserInfoMapper;
import com.ztop.admin.service.AccountService;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
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
    @Autowired
    private EmailCaptchaMapper emailCaptchaMapper;

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

    @Override
    public ResponseData sendEmailCaptcha(String email) {
        ResponseData responseData = new ResponseData();
        if (email.matches("11")){
            responseData.setCode("1");
            responseData.setMsg("邮箱格式不正确");
            return responseData;
        }
    //TODO 写了一半 头疼 缓缓
        try{
            Email sendemail = new SimpleEmail();
            sendemail.setHostName("smtp.googlemail.com");//邮箱的SMTP服务器
            sendemail.setSmtpPort(465);
            //设置发送人到的邮箱和用户名和授权码(授权码是自己设置的)
            sendemail.setAuthenticator(new DefaultAuthenticator("username", "password"));
            sendemail.setSSLOnConnect(true);
            sendemail.setFrom("user@gmail.com");//发送人
            sendemail.setSubject("TestMail");//设置发送主题
            sendemail.setMsg("This is a test mail ... :-)");//设置发送内容
            sendemail.addTo("foo@bar.com");//设置收件人
            sendemail.send();//进行发送
        }catch (Exception e){

        }
        responseData.setCode("0");
        responseData.setMsg("发送成功");
        return responseData;
    }
}
