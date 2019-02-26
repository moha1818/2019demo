package com.sunland.dto;

import java.math.BigDecimal;

public class MoneyDto {
    private BigDecimal totalAmount = new BigDecimal(0.00);
    private BigDecimal taxAmount = new BigDecimal(0.00);
    private BigDecimal invoiceAmount = new BigDecimal(0.00);

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }
}
