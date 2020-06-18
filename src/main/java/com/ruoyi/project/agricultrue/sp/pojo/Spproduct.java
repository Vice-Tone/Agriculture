package com.ruoyi.project.agricultrue.sp.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@WebMapping(value = "spproduct")
public class Spproduct {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "名称")
    private String name;
    @FieldMapping(value = "主图")
    private String mainUrl;
    @FieldMapping(value = "型号")
    private String xinghao;
    @FieldMapping(value = "品牌")
    private String brand;
    @FieldMapping(value = "出厂公司")
    private String company;
    @FieldMapping(value = "所在地")
    private String location;
    @FieldMapping(value = "价格")
    private String price;
    @FieldMapping(value = "联系方式")
    private String mobile;
    @FieldMapping(value = "实际报价")
    private String realMoney;
    @FieldMapping(value = "更新时间")
    private String updateTime;
    @FieldMapping(value = "类别名称")
    private String typeName;
    @FieldMapping(value = "类别id")
    private Integer typeId;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "xinghao")
    public String getXinghao() {
        return xinghao;
    }

    public void setXinghao(String xinghao) {
        this.xinghao = xinghao;
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
    @Column(name = "company")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "realMoney")
    public String getRealMoney() {
        return realMoney;
    }

    public void setRealMoney(String realMoney) {
        this.realMoney = realMoney;
    }

    @Basic
    @Column(name = "updateTime")
    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "typeName")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Basic
    @Column(name = "typeId")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spproduct spproduct = (Spproduct) o;
        return id == spproduct.id &&
                Objects.equals(name, spproduct.name) &&
                Objects.equals(mainUrl, spproduct.mainUrl) &&
                Objects.equals(xinghao, spproduct.xinghao) &&
                Objects.equals(brand, spproduct.brand) &&
                Objects.equals(company, spproduct.company) &&
                Objects.equals(location, spproduct.location) &&
                Objects.equals(price, spproduct.price) &&
                Objects.equals(mobile, spproduct.mobile) &&
                Objects.equals(realMoney, spproduct.realMoney) &&
                Objects.equals(updateTime, spproduct.updateTime) &&
                Objects.equals(typeName, spproduct.typeName) &&
                Objects.equals(typeId, spproduct.typeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mainUrl, xinghao, brand, company, location, price, mobile, realMoney, updateTime, typeName, typeId);
    }
}
