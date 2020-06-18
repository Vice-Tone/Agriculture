package com.ruoyi.project.agricultrue.pde.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@WebMapping(value = "pdequality")
public class Pdequality {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "产品名")
    private String productName;
    @FieldMapping(value = "生产总数")
    private Integer totalNum;
    @FieldMapping(value = "不良产品数")
    private Integer badNum;
    @FieldMapping(value = "负责人")
    private String charge;
    @FieldMapping(value = "日期")
    private String dayTime;

    private int process;

    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
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
    @Column(name = "totalNum")
    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    @Basic
    @Column(name = "badNum")
    public Integer getBadNum() {
        return badNum;
    }

    public void setBadNum(Integer badNum) {
        this.badNum = badNum;
    }

    @Basic
    @Column(name = "charge")
    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    @Basic
    @Column(name = "dayTime")
    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pdequality that = (Pdequality) o;
        return id == that.id &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(totalNum, that.totalNum) &&
                Objects.equals(badNum, that.badNum) &&
                Objects.equals(charge, that.charge) &&
                Objects.equals(dayTime, that.dayTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, totalNum, badNum, charge, dayTime);
    }
}
