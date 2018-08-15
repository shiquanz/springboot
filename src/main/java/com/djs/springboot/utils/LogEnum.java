package com.djs.springboot.utils;

public enum LogEnum {
    /**
     * 本地日志枚举
     * @author Administrator
     *
     */
    // 业务日志
    BUSSINESS("bussiness"),
    //平台日志
    PLATFORM("platform"),
    //DB 日志
    DB("db"),
    //错误日志
    EXCEPTION("exception"),

    ;
    private String category;


    LogEnum(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
