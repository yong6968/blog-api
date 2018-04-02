package com.linzy.common.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * response处理类
 * @author zhiyong.lin
 * @version 2018/3/29 15:45
 */
@Slf4j
public class HttpResponseUtil {

    /**
     * response返回json对象
     * @param resp
     * @param object
     */
    public static void setResponseJsonBody(HttpServletResponse resp,Object object){
        String respBodyStr = JsonUtil.objectToJson(object);
        setResponseBody(resp,respBodyStr,"application/json;charset=UTF-8","UTF-8");
    }

    /**
     * response返回json对象
     * @param resp
     * @param respBodyStr
     */
    public static void setResponseJsonBody(HttpServletResponse resp,String respBodyStr) {
        setResponseBody(resp,respBodyStr,"application/json;charset=UTF-8","UTF-8");
    }

    public static void setResponseHtmlBody(HttpServletResponse resp, String respBodyStr) {
        setResponseBody(resp, respBodyStr, "text/html;charset=UTF-8", "UTF-8");
    }

    /**
     * response返回json对象
     * @param resp
     * @param respBodyStr
     * @param contentType
     * @param encoding
     */
    private static void setResponseBody(HttpServletResponse resp,String respBodyStr,String contentType,String encoding){
        resp.setContentType(contentType);
        resp.setCharacterEncoding(encoding);
        PrintWriter printWriter = null;
        try {
            printWriter = resp.getWriter();
            printWriter.print(respBodyStr);
            printWriter.flush();
        } catch (IOException e) {
            log.error("HttpServletResponse写入异常" + e.getMessage(), e);
        } finally {
            if(printWriter !=  null){
                printWriter.close();
            }
        }
    }
}
