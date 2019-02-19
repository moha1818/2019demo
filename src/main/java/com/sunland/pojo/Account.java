package com.sunland.pojo;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {
    private Integer accountid;

    private String mobilenum;

    private String pin;

    private String openid;

    private String clientid;

    private String sessionkey;

    private Date sessiontime;

    private String imsi;

    private String imei;

    private String nickname;

    private String sex;

    private String birthday;

    private Date regtime;

    private String headsimgpath;

    private String headmimgpath;

    private Integer sysbalance;

    private Double longitude;

    private Double latitude;

    private String quickpay;

    private Integer messagepush;

    private Integer sms;

    private Integer preferentialpay;

    private String wxpush;

    private Integer points;

    private String currentversion;

    private String ostype;

    private Date updatedate;

    private String wxsessionkey;

    private Date wxsessiontime;

    private String utoken;

    private Date lastsignintime;

    private Integer signinday;

    private String cmb_agrno;

    private static final long serialVersionUID = 1L;

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public String getMobilenum() {
        return mobilenum;
    }

    public void setMobilenum(String mobilenum) {
        this.mobilenum = mobilenum == null ? null : mobilenum.trim();
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin == null ? null : pin.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid == null ? null : clientid.trim();
    }

    public String getSessionkey() {
        return sessionkey;
    }

    public void setSessionkey(String sessionkey) {
        this.sessionkey = sessionkey == null ? null : sessionkey.trim();
    }

    public Date getSessiontime() {
        return sessiontime;
    }

    public void setSessiontime(Date sessiontime) {
        this.sessiontime = sessiontime;
    }

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi == null ? null : imsi.trim();
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public String getHeadsimgpath() {
        return headsimgpath;
    }

    public void setHeadsimgpath(String headsimgpath) {
        this.headsimgpath = headsimgpath == null ? null : headsimgpath.trim();
    }

    public String getHeadmimgpath() {
        return headmimgpath;
    }

    public void setHeadmimgpath(String headmimgpath) {
        this.headmimgpath = headmimgpath == null ? null : headmimgpath.trim();
    }

    public Integer getSysbalance() {
        return sysbalance;
    }

    public void setSysbalance(Integer sysbalance) {
        this.sysbalance = sysbalance;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getQuickpay() {
        return quickpay;
    }

    public void setQuickpay(String quickpay) {
        this.quickpay = quickpay == null ? null : quickpay.trim();
    }

    public Integer getMessagepush() {
        return messagepush;
    }

    public void setMessagepush(Integer messagepush) {
        this.messagepush = messagepush;
    }

    public Integer getSms() {
        return sms;
    }

    public void setSms(Integer sms) {
        this.sms = sms;
    }

    public Integer getPreferentialpay() {
        return preferentialpay;
    }

    public void setPreferentialpay(Integer preferentialpay) {
        this.preferentialpay = preferentialpay;
    }

    public String getWxpush() {
        return wxpush;
    }

    public void setWxpush(String wxpush) {
        this.wxpush = wxpush == null ? null : wxpush.trim();
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getCurrentversion() {
        return currentversion;
    }

    public void setCurrentversion(String currentversion) {
        this.currentversion = currentversion == null ? null : currentversion.trim();
    }

    public String getOstype() {
        return ostype;
    }

    public void setOstype(String ostype) {
        this.ostype = ostype == null ? null : ostype.trim();
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getWxsessionkey() {
        return wxsessionkey;
    }

    public void setWxsessionkey(String wxsessionkey) {
        this.wxsessionkey = wxsessionkey == null ? null : wxsessionkey.trim();
    }

    public Date getWxsessiontime() {
        return wxsessiontime;
    }

    public void setWxsessiontime(Date wxsessiontime) {
        this.wxsessiontime = wxsessiontime;
    }

    public String getUtoken() {
        return utoken;
    }

    public void setUtoken(String utoken) {
        this.utoken = utoken == null ? null : utoken.trim();
    }

    public Date getLastsignintime() {
        return lastsignintime;
    }

    public void setLastsignintime(Date lastsignintime) {
        this.lastsignintime = lastsignintime;
    }

    public Integer getSigninday() {
        return signinday;
    }

    public void setSigninday(Integer signinday) {
        this.signinday = signinday;
    }

    public String getCmb_agrno() {
        return cmb_agrno;
    }

    public void setCmb_agrno(String cmb_agrno) {
        this.cmb_agrno = cmb_agrno == null ? null : cmb_agrno.trim();
    }
}