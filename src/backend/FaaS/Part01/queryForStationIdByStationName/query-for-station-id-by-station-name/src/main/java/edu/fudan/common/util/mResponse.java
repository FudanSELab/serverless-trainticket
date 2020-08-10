package edu.fudan.common.util;

public class mResponse<T> {

    /**
     * 1 true, 0 false
     */
    private Integer status;
    private String msg;
    private T data;

    public mResponse() {
    }

    public mResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public String toString() {
        return data.toString();
    }

}
