package com.ruoyi.project.agricultrue.jxc.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@WebMapping(value = "jxcassetout")
public class Jxcassetout {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "收款单位")
    private String shoukuandanwei;
    @FieldMapping(value = "单据编号")
    private String receiptsCode;
    @FieldMapping(value = "经手人")
    private String operator;
    @FieldMapping(value = "单据日期")
    private String receiptsdate;
    @FieldMapping(value = "单据日期整型")
    private long receiptslongdate;
    @FieldMapping(value = "收款金额")
    private String paymentMoney;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "shoukuandanwei")
    public String getShoukuandanwei() {
        return shoukuandanwei;
    }

    public void setShoukuandanwei(String shoukuandanwei) {
        this.shoukuandanwei = shoukuandanwei;
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
    @Column(name = "operator")
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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
    @Column(name = "paymentMoney")
    public String getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(String paymentMoney) {
        this.paymentMoney = paymentMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jxcassetout that = (Jxcassetout) o;
        return id == that.id &&
                Objects.equals(shoukuandanwei, that.shoukuandanwei) &&
                Objects.equals(receiptsCode, that.receiptsCode) &&
                Objects.equals(operator, that.operator) &&
                Objects.equals(receiptsdate, that.receiptsdate) &&
                Objects.equals(receiptslongdate, that.receiptslongdate) &&
                Objects.equals(paymentMoney, that.paymentMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shoukuandanwei, receiptsCode, operator, receiptsdate, receiptslongdate, paymentMoney);
    }
}
