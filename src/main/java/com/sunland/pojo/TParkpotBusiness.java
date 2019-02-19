package com.sunland.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

public class TParkpotBusiness implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    private String uuid;

    private String parkpotid;

    private String extbusinessid;

    private String parkbusinesstype;

    private String leavebusinesstype;

    private String leavebusinesstype_tmp;

    private String hphm;

    private String hpzl;

    private Integer holdingtime;

    private Date parktime;

    private Date leavetime;

    private String businessstate;

    private Integer paymenttotal;

    private Integer payment;

    private Integer paypreferential;

    private Integer delayfee;

    private Date createdate;

    private Date updatedate;

    private String autopaystate;

    private String errorinfo;

    private Integer couponid;

    private Date lastpaytime;

    private String invoicestate;

    private String invoiceno;

    private String invoicecode;

    private Date invoicetime;

    private Integer shopid;

    private String hpys;

    private String mainbrandid;

    private String subbrandid;

    private String csys;

    private String is_paydelay_close;

    private Integer accountid_wp;

    @Transient
    private String parkpotname;

    @Transient
    private Integer taxrate;

    private static final long serialVersionUID = 1L;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getParkpotid() {
        return parkpotid;
    }

    public void setParkpotid(String parkpotid) {
        this.parkpotid = parkpotid == null ? null : parkpotid.trim();
    }

    public String getExtbusinessid() {
        return extbusinessid;
    }

    public void setExtbusinessid(String extbusinessid) {
        this.extbusinessid = extbusinessid == null ? null : extbusinessid.trim();
    }

    public String getParkbusinesstype() {
        return parkbusinesstype;
    }

    public void setParkbusinesstype(String parkbusinesstype) {
        this.parkbusinesstype = parkbusinesstype == null ? null : parkbusinesstype.trim();
    }

    public String getLeavebusinesstype() {
        return leavebusinesstype;
    }

    public void setLeavebusinesstype(String leavebusinesstype) {
        this.leavebusinesstype = leavebusinesstype == null ? null : leavebusinesstype.trim();
    }

    public String getLeavebusinesstype_tmp() {
        return leavebusinesstype_tmp;
    }

    public void setLeavebusinesstype_tmp(String leavebusinesstype_tmp) {
        this.leavebusinesstype_tmp = leavebusinesstype_tmp == null ? null : leavebusinesstype_tmp.trim();
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

    public Integer getHoldingtime() {
        return holdingtime;
    }

    public void setHoldingtime(Integer holdingtime) {
        this.holdingtime = holdingtime;
    }

    public Date getParktime() {
        return parktime;
    }

    public void setParktime(Date parktime) {
        this.parktime = parktime;
    }

    public Date getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(Date leavetime) {
        this.leavetime = leavetime;
    }

    public String getBusinessstate() {
        return businessstate;
    }

    public void setBusinessstate(String businessstate) {
        this.businessstate = businessstate == null ? null : businessstate.trim();
    }

    public Integer getPaymenttotal() {
        return paymenttotal;
    }

    public void setPaymenttotal(Integer paymenttotal) {
        this.paymenttotal = paymenttotal;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Integer getPaypreferential() {
        return paypreferential;
    }

    public void setPaypreferential(Integer paypreferential) {
        this.paypreferential = paypreferential;
    }

    public Integer getDelayfee() {
        return delayfee;
    }

    public void setDelayfee(Integer delayfee) {
        this.delayfee = delayfee;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getAutopaystate() {
        return autopaystate;
    }

    public void setAutopaystate(String autopaystate) {
        this.autopaystate = autopaystate == null ? null : autopaystate.trim();
    }

    public String getErrorinfo() {
        return errorinfo;
    }

    public void setErrorinfo(String errorinfo) {
        this.errorinfo = errorinfo == null ? null : errorinfo.trim();
    }

    public Integer getCouponid() {
        return couponid;
    }

    public void setCouponid(Integer couponid) {
        this.couponid = couponid;
    }

    public Date getLastpaytime() {
        return lastpaytime;
    }

    public void setLastpaytime(Date lastpaytime) {
        this.lastpaytime = lastpaytime;
    }

    public String getInvoicestate() {
        return invoicestate;
    }

    public void setInvoicestate(String invoicestate) {
        this.invoicestate = invoicestate == null ? null : invoicestate.trim();
    }

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno == null ? null : invoiceno.trim();
    }

    public String getInvoicecode() {
        return invoicecode;
    }

    public void setInvoicecode(String invoicecode) {
        this.invoicecode = invoicecode == null ? null : invoicecode.trim();
    }

    public Date getInvoicetime() {
        return invoicetime;
    }

    public void setInvoicetime(Date invoicetime) {
        this.invoicetime = invoicetime;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public String getHpys() {
        return hpys;
    }

    public void setHpys(String hpys) {
        this.hpys = hpys == null ? null : hpys.trim();
    }

    public String getMainbrandid() {
        return mainbrandid;
    }

    public void setMainbrandid(String mainbrandid) {
        this.mainbrandid = mainbrandid == null ? null : mainbrandid.trim();
    }

    public String getSubbrandid() {
        return subbrandid;
    }

    public void setSubbrandid(String subbrandid) {
        this.subbrandid = subbrandid == null ? null : subbrandid.trim();
    }

    public String getCsys() {
        return csys;
    }

    public void setCsys(String csys) {
        this.csys = csys == null ? null : csys.trim();
    }

    public String getIs_paydelay_close() {
        return is_paydelay_close;
    }

    public void setIs_paydelay_close(String is_paydelay_close) {
        this.is_paydelay_close = is_paydelay_close == null ? null : is_paydelay_close.trim();
    }

    public Integer getAccountid_wp() {
        return accountid_wp;
    }

    public void setAccountid_wp(Integer accountid_wp) {
        this.accountid_wp = accountid_wp;
    }

    public String getParkpotname() {
        return parkpotname;
    }

    public void setParkpotname(String parkpotname) {
        this.parkpotname = parkpotname;
    }

    public Integer getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(Integer taxrate) {
        this.taxrate = taxrate;
    }
}