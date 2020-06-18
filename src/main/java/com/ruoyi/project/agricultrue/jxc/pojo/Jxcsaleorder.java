package com.ruoyi.project.agricultrue.jxc.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@WebMapping(value = "jxcsaleorder")
public class Jxcsaleorder {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "客户名称")
    private String customer;
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
    @Column(name = "customer")
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jxcsaleorder that = (Jxcsaleorder) o;
        return id == that.id &&
                Objects.equals(customer, that.customer) &&
                Objects.equals(receiptsCode, that.receiptsCode) &&
                Objects.equals(goodInfo, that.goodInfo) &&
                Objects.equals(receiptsdate, that.receiptsdate) &&
                Objects.equals(receiptslongdate, that.receiptslongdate) &&
                Objects.equals(operator, that.operator) &&
                Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, receiptsCode, goodInfo, receiptsdate, receiptslongdate, operator, total);
    }
}
