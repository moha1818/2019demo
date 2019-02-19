package com.sunland.pojo;

import java.io.Serializable;
import java.util.Date;

public class AccountVehicle implements Serializable {
    private Integer pid;

    private Integer accountid;

    private String hphm;

    private String hpzl;

    private Date bindtime;

    private String authenticatedstate;

    private String isautopay;

    private String czxm;

    private String clsbdh;

    private String imgpath;

    private Date authenticatedtime;

    private String czsjhm;

    private String is_cz;

    private static final long serialVersionUID = 1L;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public String getHphm() {
        return hphm;
    }

    public void setHphm(String hphm) {
        this.hphm = hphm == null ? null : hphm.trim();
    }

    public String getHpzl() {
        return hpzl;
    }

    public void setHpzl(String hpzl) {
        this.hpzl = hpzl == null ? null : hpzl.trim();
    }

    public Date getBindtime() {
        return bindtime;
    }

    public void setBindtime(Date bindtime) {
        this.bindtime = bindtime;
    }

    public String getAuthenticatedstate() {
        return authenticatedstate;
    }

    public void setAuthenticatedstate(String authenticatedstate) {
        this.authenticatedstate = authenticatedstate == null ? null : authenticatedstate.trim();
    }

    public String getIsautopay() {
        return isautopay;
    }

    public void setIsautopay(String isautopay) {
        this.isautopay = isautopay == null ? null : isautopay.trim();
    }

    public String getCzxm() {
        return czxm;
    }

    public void setCzxm(String czxm) {
        this.czxm = czxm == null ? null : czxm.trim();
    }

    public String getClsbdh() {
        return clsbdh;
    }

    public void setClsbdh(String clsbdh) {
        this.clsbdh = clsbdh == null ? null : clsbdh.trim();
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath == null ? null : imgpath.trim();
    }

    public Date getAuthenticatedtime() {
        return authenticatedtime;
    }

    public void setAuthenticatedtime(Date authenticatedtime) {
        this.authenticatedtime = authenticatedtime;
    }

    public String getCzsjhm() {
        return czsjhm;
    }

    public void setCzsjhm(String czsjhm) {
        this.czsjhm = czsjhm == null ? null : czsjhm.trim();
    }

    public String getIs_cz() {
        return is_cz;
    }

    public void setIs_cz(String is_cz) {
        this.is_cz = is_cz == null ? null : is_cz.trim();
    }
}