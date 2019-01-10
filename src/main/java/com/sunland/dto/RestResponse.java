package com.sunland.dto;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;

public class RestResponse<T> {
    public static final RestResponse<Void> VOID_REST_RESPONSE = new RestResponse<>(null);

    @ApiModelProperty(value="返回编码")
    private String errcode;
    @ApiModelProperty(value="返回信息")
    private String description;
    @ApiModelProperty(value="返回数据")
    private T data;

    public RestResponse(String errcode, String description, T data) {
        this.errcode = errcode;
        this.description = description;
        this.data = data;
    }
    public RestResponse(int errcode, String description, T data) {
        this.errcode = String.valueOf(errcode);
        this.description = description;
        this.data = data;
    }

    public RestResponse(String errcode,T data) {
        this(errcode, "OK", data);
    }
    public RestResponse(HttpStatus status, T data) {
        this(String.valueOf(status.value()), status.getReasonPhrase(), data);
    }

    public RestResponse(T data) {
        this("200", "OK", data);
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
