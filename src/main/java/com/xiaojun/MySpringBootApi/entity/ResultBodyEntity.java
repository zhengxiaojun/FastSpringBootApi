package com.xiaojun.MySpringBootApi.entity;

import com.alibaba.fastjson.JSONObject;
import com.xiaojun.MySpringBootApi.interfaces.BaseErrorInfoInterface;

public class ResultBodyEntity {
    /**
     * 响应代码
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */
    private Object result;

    public ResultBodyEntity() {
    }

    public ResultBodyEntity(BaseErrorInfoInterface errorInfo) {
        this.code = errorInfo.getResultCode();
        this.message = errorInfo.getResultMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * 成功
     *
     * @return
     */
    public static ResultBodyEntity success() {
        return success(null);
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static ResultBodyEntity success(Object data) {
        ResultBodyEntity rb = new ResultBodyEntity();
        rb.setCode(CommonEnumEntity.SUCCESS.getResultCode());
        rb.setMessage(CommonEnumEntity.SUCCESS.getResultMsg());
        rb.setResult(data);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBodyEntity error(BaseErrorInfoInterface errorInfo) {
        ResultBodyEntity rb = new ResultBodyEntity();
        rb.setCode(errorInfo.getResultCode());
        rb.setMessage(errorInfo.getResultMsg());
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBodyEntity error(String code, String message) {
        ResultBodyEntity rb = new ResultBodyEntity();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultBodyEntity error(String message) {
        ResultBodyEntity rb = new ResultBodyEntity();
        rb.setCode("-1");
        rb.setMessage(message);
        rb.setResult(null);
        return rb;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
