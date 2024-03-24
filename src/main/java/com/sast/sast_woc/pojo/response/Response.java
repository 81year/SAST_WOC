package com.sast.sast_woc.pojo.response;

import lombok.Data;

@Data
public class Response {
    private boolean success;
    private Integer errCode;
    private String errMsg;
    private Object data;

     Response(boolean success, Integer errCode, String errMsg, Object data) {
        this.success = success;
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.data = data;
    }

    public static Response success(Object data){
        return new Response(true,null,null,data);
    }
    public static Response success(){
        return new Response(true,null,null,null);
    }
    public static Response error(){
        return new Response(false, 1004, "无权限",null);
    }

}
