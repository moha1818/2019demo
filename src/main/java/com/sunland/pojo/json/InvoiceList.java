package com.sunland.pojo.json;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class InvoiceList implements Serializable {
    private static final long serialVersionUID = -5545360352924822528L;
    @ApiModelProperty(value="电子发票id")
    private Integer id;
    @ApiModelProperty(value="发票金额")
    private String amount;
    @ApiModelProperty(value="发票开具时间")
    private String createTime;
    @ApiModelProperty(value="开票状态 0-作废 1-成功 2-开票中 3-异常")
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
