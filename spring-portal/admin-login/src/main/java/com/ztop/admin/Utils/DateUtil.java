package com.ztop.admin.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author ZhouJianGuo
 * @Date 2019/5/23 9:43
 * @Version 1.0
 **/
public class DateUtil {

    public static String getChinaDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(System.currentTimeMillis());
    }
}
