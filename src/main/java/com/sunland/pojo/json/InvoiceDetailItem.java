package com.sunland.pojo.json;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

public class InvoiceDetailItem {
    @ApiModelProperty(value="停车点名称")
    private String parkname;

    @ApiModelProperty(value="金额")
    private BigDecimal parkmoney;

    @ApiModelProperty(value="停车时间")
    private Date parktime;

    @ApiModelProperty(value="号码牌")
    private String hphm;

    public String getParkname() {
        return parkname;
    }

    public void setParkname(String parkname) {
        this.parkname = parkname;
    }

    public BigDecimal getParkmoney() {
        return parkmoney;
    }

    public void setParkmoney(BigDecimal parkmoney) {
        this.parkmoney = parkmoney;
    }

    public Date getParktime() {
        return parktime;
    }

    public void setParktime(Date parktime) {
        this.parktime = parktime;
    }

    public String getHphm() {
        return hphm;
    }

    public void setHphm(String hphm) {
        this.hphm = hphm;
    }
}
