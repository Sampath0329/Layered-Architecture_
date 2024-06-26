package com.example.layeredarchitecture.view.tdm;

import java.math.BigDecimal;

public class SearchOrderTM {
    private String code;
    private String description;
    private int qty;
    private BigDecimal unitPrice;
    private BigDecimal total;

    public SearchOrderTM(){}

    public SearchOrderTM(String code, String description, int qty, BigDecimal unitPrice, BigDecimal total) {
        this.code = code;
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.total = total;
    }
    public SearchOrderTM(String code, String description, int qty, BigDecimal unitPrice) {
        this.code = code;
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
