package com.xiaojun.MySpringBootApi.entity;

public class ResultBo<T> {
    /**
     * 错误码 0表示没有错误(异常) 其他数字代表具体错误码
     */
    private int code;
    /**
     * 后端返回消息
     */
    private String msg;
    /**
     * 后端返回的数据
     */
    private T data;

    /**
     * 无参数构造函数
     */
    public ResultBo() {
        this.code = 0;
        this.msg = "操作成功";
    }

    /**
     * 带数据data构造函数
     */
    public ResultBo(T data) {
        this();
        this.data = data;
    }

    /**
     * 存在异常的构造函数
     */
    public ResultBo(Exception ex) {
        this.code = 99999;// 其他未定义异常
        this.msg = ex.getMessage();
    }
    // 省略 get set
}

