package com.ztop.admin.bean.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @Author ZhouJianGuo
 * @Date 2019/5/22 17:02
 * @Version 1.0
 **/
@Data
@ToString
public class LoginRespVo {
    private String id;
    private String token;
    private String name;
    private String inco;
    private String phone;
    private String email;
    private String permission;
    private String password;
}
