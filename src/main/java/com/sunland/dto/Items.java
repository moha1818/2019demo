package com.sunland.dto;

import java.io.Serializable;

public class Items implements Serializable {

    private static final long serialVersionUID = -6885831814005003972L;
    /**
     * 规格型号
     */
    private String specModel;
    /**
     *零税率标识 空:非零税率1:免税2:不征税3:普通零税率
     */
    private String zeroTaxRateFlag;
    /**
     *税额
     */
    private String taxAmount;
    /**
     *税率
     */
    private String taxRate;
    /**
     *税收分类编码
     */
    private String goodsCode;
    /**
     *单价
     */
    private String unitPrice;
    /**
     *单位
     */
    private String unit;
    /**
     *明细金额(不含税)
     */
    private String detailAmount;
    /**
     *正常行0，折扣行1，被折扣行2
     */
    private String discountType;
    /**
     *货物名称
     */
    private String goodsName;
    /**
     *数量
     */
    private String num;
    /**
     *优惠政策
     */
    private String preferentialPolicy;
    /**
     *增值税特殊管理
     */
    private String vatException;

    public String getSpecModel() {
        return specModel;
    }

    public void setSpecModel(String specModel) {
        this.specModel = specModel;
    }

    public String getZeroTaxRateFlag() {
        return zeroTaxRateFlag;
    }

    public void setZeroTaxRateFlag(String zeroTaxRateFlag) {
        this.zeroTaxRateFlag = zeroTaxRateFlag;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDetailAmount() {
        return detailAmount;
    }

    public void setDetailAmount(String detailAmount) {
        this.detailAmount = detailAmount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPreferentialPolicy() {
        return preferentialPolicy;
    }

    public void setPreferentialPolicy(String preferentialPolicy) {
        this.preferentialPolicy = preferentialPolicy;
    }

    public String getVatException() {
        return vatException;
    }

    public void setVatException(String vatException) {
        this.vatException = vatException;
    }

}
