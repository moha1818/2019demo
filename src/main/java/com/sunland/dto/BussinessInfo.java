package com.sunland.dto;

import java.util.Date;

public class BussinessInfo {
    private String uuid;
    private String hphm;
    private Integer payment;
    private Integer holdingtime;
    private String parkname;
    private Integer taxrate;
    private Date parktime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getHphm() {
        return hphm;
    }

    public void setHphm(String hphm) {
        this.hphm = hphm;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Integer getHoldingtime() {
        return holdingtime;
    }

    public void setHoldingtime(Integer holdingtime) {
        this.holdingtime = holdingtime;
    }

    public String getParkname() {
        return parkname;
    }

    public void setParkname(String parkname) {
        this.parkname = parkname;
    }

    public Integer getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(Integer taxrate) {
        this.taxrate = taxrate;
    }

    public Date getParktime() {
        return parktime;
    }

    public void setParktime(Date parktime) {
        this.parktime = parktime;
    }
}
