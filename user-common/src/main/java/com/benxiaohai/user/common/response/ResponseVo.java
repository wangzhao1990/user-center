package com.benxiaohai.user.common.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVo {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 返回内容
     */
    private Object data;

    /**
     * 获取错误返回对象
     * @param errorCode 错误码
     * @param message 错误信息
     * @return 返回结果
     */
    public static ResponseVo errorResponse(String errorCode,String message,Object data){
//        return ResponseVo.builder().success(false).errorCode(errorCode).message(message).data(data).build();
        return new ResponseVo(false,errorCode,message,data);
    }

    /**
     * 获取错误返回对象
     * @param errorCode 错误码
     * @param message 错误信息
     * @return 返回结果
     */
    public static ResponseVo errorResponse(String errorCode,String message){
        return errorResponse(errorCode,message,"");
    }

    /**
     * 获取错误返回对象
     * @param message 错误信息
     * @return 返回结果
     */
    public static ResponseVo errorResponse(String message){
        return errorResponse("",message,"");
    }

    /**
     * 获取错误返回对象
     * @param message 信息
     * @param data 数据
     * @return 返回结果
     */
    public static ResponseVo successResponse(String message,Object data){
//        return ResponseVo.builder().success(true).message(message).data(data).build();
        return new ResponseVo(true, "", message, data);
    }

    /**
     * 获取错误返回对象
     * @param data 数据
     * @return 返回结果
     */
    public static ResponseVo successResponse(Object data){
        return successResponse("",data);
    }

    /**
     * 登录异常
     * @return 返回结果
     */
    public static ResponseVo errorLoginReturn(){
        return errorResponse("1001","Not logged in");
    }


}
