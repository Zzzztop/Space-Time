package com.ztop.admin.bean.vo;

/**
 * @Author ZhouJianGuo
 * @Date 2019/5/22 17:42
 * @Version 1.0
 **/
public class ResponseData {
    private String code;
    private String msg;
    private Object value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", value=" + value +
                '}';
    }
}
