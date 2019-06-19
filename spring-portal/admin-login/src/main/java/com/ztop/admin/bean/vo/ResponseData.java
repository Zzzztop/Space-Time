package com.ztop.admin.bean.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @Author ZhouJianGuo
 * @Date 2019/5/22 17:42
 * @Version 1.0
 **/
@Data
@ToString
public class ResponseData {
    private String code;
    private String msg;
    private Object value;

}
