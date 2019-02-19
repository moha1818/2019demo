package com.sunland.pojo.json;

import io.swagger.annotations.ApiModelProperty;

public class InvoiceInfo {
    @ApiModelProperty(value="企业名称")
    private String enterpriseName;
    @ApiModelProperty(value="企业税号")
    private String enterpriseTaxNo;
    @ApiModelProperty(value="订单总金额")
    private String amount;
    @ApiModelProperty(value="1-路内停车 2-停车场")
    private String projectType;

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseTaxNo() {
        return enterpriseTaxNo;
    }

    public void setEnterpriseTaxNo(String enterpriseTaxNo) {
        this.enterpriseTaxNo = enterpriseTaxNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }
}
