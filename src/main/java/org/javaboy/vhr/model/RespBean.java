package org.javaboy.vhr.model;

public class RespBean {

    private Integer code;

    private String msg;

    private Object object;

    private String isAlert;

    public static RespBean success(String msg){
        return new RespBean(200, msg, null);
    }
    public static RespBean success(String msg, Object o){
        return new RespBean(200, msg, o);
    }
    public static RespBean success(String msg, Object o, String isAlert){
        return new RespBean(200, msg, o, isAlert);
    }
    public static RespBean error(String msg){
        return new RespBean(500, msg, null);
    }
    public static RespBean error(String msg, Object o){
        return new RespBean(500, msg, o);
    }

    private RespBean(Integer code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

    private RespBean(Integer code, String msg, Object object, String isAlert) {
        this.code = code;
        this.msg = msg;
        this.object = object;
        this.isAlert = isAlert;
    }

    private RespBean() {
    }

    public String getIsAlert() {
        return isAlert;
    }

    public void setIsAlert(String isAlert) {
        this.isAlert = isAlert;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
