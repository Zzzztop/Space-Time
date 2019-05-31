package com.ztop.admin.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @Author ZhouJianGuo
 * @Date 2019/5/22 16:54
 * @Version 1.0
 **/
@Data
@ToString
public class UserInfo {
    private String id;
    private String token;
    private String name;
    private String inco;
    private String create_time;
    private String updata_time;
    private String outdata_time;
    private String phone;
    private String email;
    private String permission;
    private String password;

}
