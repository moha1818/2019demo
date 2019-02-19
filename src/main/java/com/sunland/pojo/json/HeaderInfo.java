package com.sunland.pojo.json;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class HeaderInfo implements Serializable {
    private static final long serialVersionUID = 7272720639066899106L;
    @ApiModelProperty(value="税号")
    private String creditCode;
    @ApiModelProperty(value="企业名称")
    private String name;

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
