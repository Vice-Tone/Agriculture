package com.ruoyi.project.agricultrue.pde.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@WebMapping(value = "pdeorder")
public class Pdeorder {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "客户名称")
    private String customer;
    @FieldMapping(value = "订单序号")
    private String orderNo;
    @FieldMapping(value = "产品名称")
    private String productname;
    @FieldMapping(value = "订货数量")
    private Integer goodsNum;
    @FieldMapping(value = "截止日期")
    private String finishTime;

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
    @Column(name = "orderNo")
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Basic
    @Column(name = "productname")
    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    @Basic
    @Column(name = "goodsNum")
    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    @Basic
    @Column(name = "finishTime")
    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pdeorder pdeorder = (Pdeorder) o;
        return id == pdeorder.id &&
                Objects.equals(customer, pdeorder.customer) &&
                Objects.equals(orderNo, pdeorder.orderNo) &&
                Objects.equals(productname, pdeorder.productname) &&
                Objects.equals(goodsNum, pdeorder.goodsNum) &&
                Objects.equals(finishTime, pdeorder.finishTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, orderNo, productname, goodsNum, finishTime);
    }
}
