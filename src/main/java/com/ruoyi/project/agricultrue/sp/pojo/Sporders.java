package com.ruoyi.project.agricultrue.sp.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@WebMapping(value = "sporders")
public class Sporders {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "产品名")
    private String productName;
    @FieldMapping(value = "主图")
    private String mainUrl;
    @FieldMapping(value = "下单时间")
    private String orderTime;
    @FieldMapping(value = "价格")
    private String price;
    @FieldMapping(value = "所属用户")
    private String userId;
    @FieldMapping(value = "品牌")
    private String brand;
    @FieldMapping(value = "地点")
    private String location;
    @FieldMapping(value = "状态")
    private String stat;

    private String orderNum;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
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
    @Column(name = "productName")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "mainUrl")
    public String getMainUrl() {
        return mainUrl;
    }

    public void setMainUrl(String mainUrl) {
        this.mainUrl = mainUrl;
    }

    @Basic
    @Column(name = "orderTime")
    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    @Basic
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "stat")
    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sporders sporders = (Sporders) o;
        return id == sporders.id &&
                Objects.equals(productName, sporders.productName) &&
                Objects.equals(mainUrl, sporders.mainUrl) &&
                Objects.equals(orderTime, sporders.orderTime) &&
                Objects.equals(price, sporders.price) &&
                Objects.equals(userId, sporders.userId) &&
                Objects.equals(brand, sporders.brand) &&
                Objects.equals(location, sporders.location) &&
                Objects.equals(stat, sporders.stat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, mainUrl, orderTime, price, userId, brand, location, stat);
    }
}
