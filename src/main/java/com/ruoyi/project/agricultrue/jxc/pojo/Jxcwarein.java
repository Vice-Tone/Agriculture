package com.ruoyi.project.agricultrue.jxc.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@WebMapping(value = "jxcwarein")
public class Jxcwarein {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "供应商名称")
    private String suppiler;
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
    @Column(name = "suppiler")
    public String getSuppiler() {
        return suppiler;
    }

    public void setSuppiler(String suppiler) {
        this.suppiler = suppiler;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jxcwarein jxcwarein = (Jxcwarein) o;
        return id == jxcwarein.id &&
                Objects.equals(suppiler, jxcwarein.suppiler) &&
                Objects.equals(receiptsCode, jxcwarein.receiptsCode) &&
                Objects.equals(goodInfo, jxcwarein.goodInfo) &&
                Objects.equals(receiptsdate, jxcwarein.receiptsdate) &&
                Objects.equals(receiptslongdate, jxcwarein.receiptslongdate) &&
                Objects.equals(operator, jxcwarein.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, suppiler, receiptsCode, goodInfo, receiptsdate, receiptslongdate, operator);
    }
}
