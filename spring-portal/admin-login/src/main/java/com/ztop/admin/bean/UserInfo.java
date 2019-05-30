package com.ztop.admin.bean;

/**
 * @Author ZhouJianGuo
 * @Date 2019/5/22 16:54
 * @Version 1.0
 **/
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInco() {
        return inco;
    }

    public void setInco(String inco) {
        this.inco = inco;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdata_time() {
        return updata_time;
    }

    public void setUpdata_time(String updata_time) {
        this.updata_time = updata_time;
    }

    public String getOutdata_time() {
        return outdata_time;
    }

    public void setOutdata_time(String outdata_time) {
        this.outdata_time = outdata_time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", token='" + token + '\'' +
                ", name='" + name + '\'' +
                ", inco='" + inco + '\'' +
                ", create_time='" + create_time + '\'' +
                ", updata_time='" + updata_time + '\'' +
                ", outdata_time='" + outdata_time + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", permission='" + permission + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
