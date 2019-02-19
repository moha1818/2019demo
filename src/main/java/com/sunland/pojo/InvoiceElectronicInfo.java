package com.sunland.pojo;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class InvoiceElectronicInfo implements Serializable {
    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(hidden = true)
    private Integer eid;

    @ApiModelProperty(hidden = true)
    private Integer accountid;

    @ApiModelProperty(value="抬头类型 1企业 2个人/非企业")
    @NotNull(message = "类型不能为空")
    private Integer buyertype;

    @ApiModelProperty(value="企业名称")
    @NotNull(message = "企业名称不能为空")
    private String bueyrname;

    @ApiModelProperty(value="企业税号（企业必填）")
    private String buyertaxno;
    @ApiModelProperty(value="电话")
    private String buyertelephone;
    @ApiModelProperty(value="地址")
    private String buyeraddress;
    @ApiModelProperty(value="手机号")
    private String buyermobilephone;
    @ApiModelProperty(value="银行账号")
    private String buyeraccount;

    @ApiModelProperty(hidden = true)
    private String buyeremail;

    @ApiModelProperty(hidden = true)
    private Date createtime;

    @ApiModelProperty(value="备注")
    private String remark;

    @Transient
    @ApiModelProperty(value="业务id")
    private List<String> uuids;

    @Transient
    @ApiModelProperty(value="开票业务类型：路内-1,停车场-2")
    private Integer type;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getBueyrname() {
        return bueyrname;
    }

    public void setBueyrname(String bueyrname) {
        this.bueyrname = bueyrname == null ? null : bueyrname.trim();
    }

    public String getBuyertaxno() {
        return buyertaxno;
    }

    public void setBuyertaxno(String buyertaxno) {
        this.buyertaxno = buyertaxno == null ? null : buyertaxno.trim();
    }

    public String getBuyertelephone() {
        return buyertelephone;
    }

    public void setBuyertelephone(String buyertelephone) {
        this.buyertelephone = buyertelephone == null ? null : buyertelephone.trim();
    }

    public String getBuyeraddress() {
        return buyeraddress;
    }

    public void setBuyeraddress(String buyeraddress) {
        this.buyeraddress = buyeraddress == null ? null : buyeraddress.trim();
    }

    public String getBuyermobilephone() {
        return buyermobilephone;
    }

    public void setBuyermobilephone(String buyermobilephone) {
        this.buyermobilephone = buyermobilephone == null ? null : buyermobilephone.trim();
    }

    public String getBuyeraccount() {
        return buyeraccount;
    }

    public void setBuyeraccount(String buyeraccount) {
        this.buyeraccount = buyeraccount == null ? null : buyeraccount.trim();
    }

    public String getBuyeremail() {
        return buyeremail;
    }

    public void setBuyeremail(String buyeremail) {
        this.buyeremail = buyeremail == null ? null : buyeremail.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

    public Integer getBuyertype() {
        return buyertype;
    }

    public void setBuyertype(Integer buyertype) {
        this.buyertype = buyertype;
    }

    public List<String> getUuids() {
        return uuids;
    }

    public void setUuids(List<String> uuids) {
        this.uuids = uuids;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}