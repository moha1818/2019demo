package com.sunland.pojo.json;

import java.io.Serializable;

public class createInvoiceJson implements Serializable {
    private static final long serialVersionUID = 7294821467678534650L;
    /**
     * 流水号
     */
    private String serialNo;
    /**
     * 含税标记 0:不含税1:含税
     */
    private String taxFlag;
    /**
     * 清单标记
     */
    private String inventoryFlag;
    /**
     * 清单项目名称
     */
    private String inventoryProjectName;
    /**
     * 购买方固定电话
     */
    private String buyerFixedTelephone;
    /**
     * 购买方地址
     */
    private String buyerAddress;
    /**
     * 购买方名称
     */
    private String buyerName;
    /**
     * 购买方税号
     */
    private String buyerTaxNo;
    /**
     * 购买方银行账号
     */
    private String buyerAccount;
    /**
     * 购买方手机
     */
    private String buyerMobilePhone;
    /**
     * 购买方邮箱
     */
    private String buyerEmail;
    /**
     * 金额合计(不含税)
     */
    private String invoiceAmount;
    /**
     * 价税合计
     */
    private String totalAmount;
    /**
     * 税额合计
     */
    private String totalTaxAmount;
    /**
     * 开票类型 0:蓝票1:红票
     */
    private String type;
    /**
     * 开票人
     */
    private String drawer;
    /**
     * 复核人
     */
    private String reviewer;
    /**
     * 收款人
     */
    private String payee;
    /**
     * (原)蓝票发票代码(开红票时候需要)
     */
    private String originalInvoiceCode;
    /**
     * (原)蓝票发票号码(开红票时候需要)
     */
    private String originalInvoiceNo;
    /**
     * 备注
     */
    private String remark;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getTaxFlag() {
        return taxFlag;
    }

    public void setTaxFlag(String taxFlag) {
        this.taxFlag = taxFlag;
    }

    public String getInventoryFlag() {
        return inventoryFlag;
    }

    public void setInventoryFlag(String inventoryFlag) {
        this.inventoryFlag = inventoryFlag;
    }

    public String getInventoryProjectName() {
        return inventoryProjectName;
    }

    public void setInventoryProjectName(String inventoryProjectName) {
        this.inventoryProjectName = inventoryProjectName;
    }

    public String getBuyerFixedTelephone() {
        return buyerFixedTelephone;
    }

    public void setBuyerFixedTelephone(String buyerFixedTelephone) {
        this.buyerFixedTelephone = buyerFixedTelephone;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerTaxNo() {
        return buyerTaxNo;
    }

    public void setBuyerTaxNo(String buyerTaxNo) {
        this.buyerTaxNo = buyerTaxNo;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getBuyerMobilePhone() {
        return buyerMobilePhone;
    }

    public void setBuyerMobilePhone(String buyerMobilePhone) {
        this.buyerMobilePhone = buyerMobilePhone;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTotalTaxAmount() {
        return totalTaxAmount;
    }

    public void setTotalTaxAmount(String totalTaxAmount) {
        this.totalTaxAmount = totalTaxAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDrawer() {
        return drawer;
    }

    public void setDrawer(String drawer) {
        this.drawer = drawer;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getOriginalInvoiceCode() {
        return originalInvoiceCode;
    }

    public void setOriginalInvoiceCode(String originalInvoiceCode) {
        this.originalInvoiceCode = originalInvoiceCode;
    }

    public String getOriginalInvoiceNo() {
        return originalInvoiceNo;
    }

    public void setOriginalInvoiceNo(String originalInvoiceNo) {
        this.originalInvoiceNo = originalInvoiceNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
