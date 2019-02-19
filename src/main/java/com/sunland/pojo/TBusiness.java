package com.sunland.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

public class TBusiness implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    private String uuid;

    private String parkpointid;

    private String parklotnum;

    private String parkbusinesstype;

    private String leavebusinesstype;

    private String hphm;

    private String hpzl;

    private Integer holdingtime;

    private Date parktime;

    private Date leavetime;

    private String businessstate;

    private Integer paymenttotal;

    private Integer paylatefee;

    private Integer payment;

    private Integer paypreferential;

    private String consultstate;

    private Date dgparktime;

    private Date dgleavetime;

    private Date cameraparktime;

    private Date cameraleavetime;

    private Integer dgbusinessid;

    private Integer camerabusinessid;

    private Date createdate;

    private Date updatedate;

    private Integer couponid;

    private Date lastpaytime;

    private Double platecredible;

    private Double actioncredible;

    private String invoicestate;

    private String invoiceno;

    private String invoicecode;

    private Date invoicetime;

    private String warnstate;

    private String arrtype;

    private Integer cameraid;

    private String noticestate1;

    private String noticestate2;

    @Transient
    private String parkpointname;

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

    public String getParkpointid() {
        return parkpointid;
    }

    public void setParkpointid(String parkpointid) {
        this.parkpointid = parkpointid == null ? null : parkpointid.trim();
    }

    public String getParklotnum() {
        return parklotnum;
    }

    public void setParklotnum(String parklotnum) {
        this.parklotnum = parklotnum == null ? null : parklotnum.trim();
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

    public Integer getPaylatefee() {
        return paylatefee;
    }

    public void setPaylatefee(Integer paylatefee) {
        this.paylatefee = paylatefee;
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

    public String getConsultstate() {
        return consultstate;
    }

    public void setConsultstate(String consultstate) {
        this.consultstate = consultstate == null ? null : consultstate.trim();
    }

    public Date getDgparktime() {
        return dgparktime;
    }

    public void setDgparktime(Date dgparktime) {
        this.dgparktime = dgparktime;
    }

    public Date getDgleavetime() {
        return dgleavetime;
    }

    public void setDgleavetime(Date dgleavetime) {
        this.dgleavetime = dgleavetime;
    }

    public Date getCameraparktime() {
        return cameraparktime;
    }

    public void setCameraparktime(Date cameraparktime) {
        this.cameraparktime = cameraparktime;
    }

    public Date getCameraleavetime() {
        return cameraleavetime;
    }

    public void setCameraleavetime(Date cameraleavetime) {
        this.cameraleavetime = cameraleavetime;
    }

    public Integer getDgbusinessid() {
        return dgbusinessid;
    }

    public void setDgbusinessid(Integer dgbusinessid) {
        this.dgbusinessid = dgbusinessid;
    }

    public Integer getCamerabusinessid() {
        return camerabusinessid;
    }

    public void setCamerabusinessid(Integer camerabusinessid) {
        this.camerabusinessid = camerabusinessid;
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

    public Double getPlatecredible() {
        return platecredible;
    }

    public void setPlatecredible(Double platecredible) {
        this.platecredible = platecredible;
    }

    public Double getActioncredible() {
        return actioncredible;
    }

    public void setActioncredible(Double actioncredible) {
        this.actioncredible = actioncredible;
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

    public String getWarnstate() {
        return warnstate;
    }

    public void setWarnstate(String warnstate) {
        this.warnstate = warnstate == null ? null : warnstate.trim();
    }

    public String getArrtype() {
        return arrtype;
    }

    public void setArrtype(String arrtype) {
        this.arrtype = arrtype == null ? null : arrtype.trim();
    }

    public Integer getCameraid() {
        return cameraid;
    }

    public void setCameraid(Integer cameraid) {
        this.cameraid = cameraid;
    }

    public String getNoticestate1() {
        return noticestate1;
    }

    public void setNoticestate1(String noticestate1) {
        this.noticestate1 = noticestate1 == null ? null : noticestate1.trim();
    }

    public String getNoticestate2() {
        return noticestate2;
    }

    public void setNoticestate2(String noticestate2) {
        this.noticestate2 = noticestate2 == null ? null : noticestate2.trim();
    }

    public String getParkpointname() {
        return parkpointname;
    }

    public void setParkpointname(String parkpointname) {
        this.parkpointname = parkpointname;
    }
}