package com.ztop.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.ztop.admin.Utils.ParseUtil;
import com.ztop.admin.bean.UserInfo;
import com.ztop.admin.bean.vo.LoginRespVo;
import com.ztop.admin.bean.vo.ResponseData;
import com.ztop.admin.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.MessageFormat;
import java.util.Base64;

/**
 * @Author ZhouJianGuo
 * @Date 2019/5/22 16:38
 * @Version 1.0
 **/
@Controller
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "api/z1/admin/login",method = {RequestMethod.POST,RequestMethod.GET})
    public ResponseEntity<ResponseData> login(HttpServletRequest request,HttpServletResponse hResponse){
       JSONObject requestData = ParseUtil.parseRequestParameter(request);
        String postData = ParseUtil.getRequestStream(request);
        logger.info(MessageFormat.format("enter ClientController, start to login , requestData {0} and postData {1}",requestData,postData));
        String pwd = new String(Base64.getDecoder().decode("1"));
        ResponseData responseData = accountService.login("1",pwd);
        logger.info(MessageFormat.format("qiut ClientController, end to login , response info {0}",responseData.toString()));
        return ResponseEntity.ok().body(responseData);
    }

    @RequestMapping(value = "/z1/admin/register")
    public ResponseEntity<ResponseData> register(HttpServletRequest request,UserInfo userInfo){
        logger.info(MessageFormat.format("enter ClientController, start to register , userInfo data{0}",userInfo));
        ResponseData responseData = accountService.register(userInfo);
        logger.info(MessageFormat.format("qiut ClientController, end to register , response info {0}",responseData.toString()));
        return ResponseEntity.ok().body(responseData);
    }
}
