package com.sunland.pojo.json;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class PaymentList implements Serializable {
    private static final long serialVersionUID = 4942141032952473527L;
    @ApiModelProperty(value="缴费单Id")
    private String uuid;
    @ApiModelProperty(value="缴费单号码牌")
    private String hmp;
    @ApiModelProperty(value="缴费时间")
    private String dateTime;
    @ApiModelProperty(value="缴费价格")
    private String amount;
    @ApiModelProperty(value = "停车场ID")
    private String parkpotid;
    @ApiModelProperty(value = "是否为绑定车辆业务 (null or false的时候是非绑定车辆业务)")
    private Boolean binding;

    public String getId() {
        return uuid;
    }

    public void setId(String uuid) {
        this.uuid = uuid;
    }

    public String getHmp() {
        return hmp;
    }

    public void setHmp(String hmp) {
        this.hmp = hmp;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Boolean getBinding() {
        return binding;
    }

    public void setBinding(Boolean binding) {
        this.binding = binding;
    }

    public String getParkpotid() {
        return parkpotid;
    }

    public void setParkpotid(String parkpotid) {
        this.parkpotid = parkpotid;
    }
}
