package com.sunland.pojo.json;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class InvoiceDetail implements Serializable {
    private static final long serialVersionUID = -6172336703879369000L;
    @ApiModelProperty(value="电子发票id")
    private Integer id;
    @ApiModelProperty(value="发票金额")
    private String amount;
    @ApiModelProperty(value="发票开具时间")
    private String createTime;
    @ApiModelProperty(value="开票状态 0-作废 1-成功 2-开票中 3-异常")
    private Integer status;
    @ApiModelProperty(value="开票企业")
    private String name;
    @ApiModelProperty(value="缴费单数")
    private Integer quantity;
    @ApiModelProperty(value="pdf地址")
    private String pdfUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
