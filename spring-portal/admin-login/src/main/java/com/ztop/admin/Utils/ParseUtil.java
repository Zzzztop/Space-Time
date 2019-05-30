package com.ztop.admin.Utils;

import com.alibaba.fastjson.JSONObject;
import com.ztop.admin.controller.ClientController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

/**
 * @Author ZhouJianGuo
 * @Date 2019/5/29 16:58
 * @Version 1.0
 **/
public class ParseUtil {
    private static final Logger logger = LoggerFactory.getLogger(ParseUtil.class);
    public static final String ENCODING = "UTF-8";
    public static JSONObject parseRequestParameter(HttpServletRequest request) {
        Enumeration<String> names = request.getParameterNames();
        JSONObject jsonObject = new JSONObject();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            jsonObject.put(name, request.getParameter(name));
        }
        return jsonObject;
    }
    public static String getRequestStream(HttpServletRequest request) {
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int length = inputStream.read(bytes);
            while (length > 0) {
                outputStream.write(bytes, 0, length);
                length = inputStream.read(bytes);
            }
            // String jsonString = StreamUtils.copyToString(inputStream,
            // Charset.forName(ENCODING));
            String jsonString = new String(outputStream.toByteArray(), ENCODING);
            return jsonString;
        } catch (Throwable t) {
            logger.error(t.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException t) {
                    logger.error(t.getMessage());
                }
            }
        }
        return "";
    }
}
