package com.sunland.pojo.json;

public class InvoiceDetailJson extends createInvoiceJson {

    private static final long serialVersionUID = 4271470094627868107L;

    /**
     *  开票日期
     */
    private String invoiceDate;

    /**
     *  销货方方识别号
     */
    private String salerTaxNo;

    /**
     *  销货方名称
     */
    private String salerName;
    /**
     *  销货方地址、固定电话
     */
    private String salerAddressPhone;
    /**
     *  销货方银行账号
     */
    private String salerAccount;

    /**
     *  验证码
     */
    private String checkCode;

    /**
     *  微信卡包链接
     */
    private String wxCardBagUrl;

    /**
     *  PDF下载地址
     */
    private String pdfUrl;

    /**
     *  发票状态
     */
    private String invoiceStatus;

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getSalerTaxNo() {
        return salerTaxNo;
    }

    public void setSalerTaxNo(String salerTaxNo) {
        this.salerTaxNo = salerTaxNo;
    }

    public String getSalerName() {
        return salerName;
    }

    public void setSalerName(String salerName) {
        this.salerName = salerName;
    }

    public String getSalerAddressPhone() {
        return salerAddressPhone;
    }

    public void setSalerAddressPhone(String salerAddressPhone) {
        this.salerAddressPhone = salerAddressPhone;
    }

    public String getSalerAccount() {
        return salerAccount;
    }

    public void setSalerAccount(String salerAccount) {
        this.salerAccount = salerAccount;
    }


    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getWxCardBagUrl() {
        return wxCardBagUrl;
    }

    public void setWxCardBagUrl(String wxCardBagUrl) {
        this.wxCardBagUrl = wxCardBagUrl;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }
}
