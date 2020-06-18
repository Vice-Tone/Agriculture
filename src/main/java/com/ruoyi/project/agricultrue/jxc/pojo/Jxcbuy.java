package com.ruoyi.project.agricultrue.jxc.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@WebMapping(value = "jxcbuy")
public class Jxcbuy {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "供应商名称")
    private String supplier;
    @FieldMapping(value = "单据编号")
    private String receiptsCode;
    @FieldMapping(value = "商品信息")
    private String goodInfo;
    @FieldMapping(value = "单据日期")
    private String receiptsdate;
    @FieldMapping(value = "单据日期整型")
    private long receiptslongdate;
    @FieldMapping(value = "操作员")
    private String operator;
    @FieldMapping(value = "金额合计")
    private String total;
    @FieldMapping(value = "含税合计")
    private String tax;
    @FieldMapping(value = "优惠后金额")
    private String discount;
    @FieldMapping(value = "类型id")
    private int typeId;

    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "supplier")
    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Basic
    @Column(name = "receiptsCode")
    public String getReceiptsCode() {
        return receiptsCode;
    }

    public void setReceiptsCode(String receiptsCode) {
        this.receiptsCode = receiptsCode;
    }

    @Basic
    @Column(name = "goodInfo")
    public String getGoodInfo() {
        return goodInfo;
    }

    public void setGoodInfo(String goodInfo) {
        this.goodInfo = goodInfo;
    }

    @Basic
    @Column(name = "receiptsdate")
    public String getReceiptsdate() {
        return receiptsdate;
    }

    public void setReceiptsdate(String receiptsdate) {
        this.receiptsdate = receiptsdate;
    }

    public long getReceiptslongdate() {
        return receiptslongdate;
    }

    public void setReceiptslongdate(long receiptslongdate) {
        this.receiptslongdate = receiptslongdate;
    }

    @Basic
    @Column(name = "operator")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Basic
    @Column(name = "total")
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Basic
    @Column(name = "tax")
    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    @Basic
    @Column(name = "discount")
    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }


    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jxcbuy jxcbuy = (Jxcbuy) o;
        return id == jxcbuy.id &&
                Objects.equals(supplier, jxcbuy.supplier) &&
                Objects.equals(receiptsCode, jxcbuy.receiptsCode) &&
                Objects.equals(goodInfo, jxcbuy.goodInfo) &&
                Objects.equals(receiptsdate, jxcbuy.receiptsdate) &&
                Objects.equals(receiptslongdate, jxcbuy.receiptslongdate) &&
                Objects.equals(operator, jxcbuy.operator) &&
                Objects.equals(total, jxcbuy.total) &&
                Objects.equals(tax, jxcbuy.tax) &&
                Objects.equals(discount, jxcbuy.discount) &&
                Objects.equals(typeId, jxcbuy.typeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, supplier, receiptsCode, goodInfo, receiptsdate, receiptslongdate, operator, total, tax, discount, typeId);
    }
}
