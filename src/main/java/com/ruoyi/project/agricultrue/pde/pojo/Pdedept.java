package com.ruoyi.project.agricultrue.pde.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@WebMapping(value = "pdedept")
public class Pdedept {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "生产部门")
    private String dept;
    @FieldMapping(value = "产品名称")
    private String pdeName;
    @FieldMapping(value = "作业内容")
    private String content;
    @FieldMapping(value = "良品数")
    private Integer goodNum;
    @FieldMapping(value = "不良数")
    private Integer badNum;
    @FieldMapping(value = "生产工时")
    private Integer hours;
    @FieldMapping(value = "异常原因")
    private String exreason;
    @FieldMapping(value = "生产时间")
    private String pdeTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "dept")
    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Basic
    @Column(name = "pdeName")
    public String getPdeName() {
        return pdeName;
    }

    public void setPdeName(String pdeName) {
        this.pdeName = pdeName;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "goodNum")
    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
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
    @Column(name = "hours")
    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    @Basic
    @Column(name = "exreason")
    public String getExreason() {
        return exreason;
    }

    public void setExreason(String exreason) {
        this.exreason = exreason;
    }

    @Basic
    @Column(name = "pdeTime")
    public String getPdeTime() {
        return pdeTime;
    }

    public void setPdeTime(String pdeTime) {
        this.pdeTime = pdeTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pdedept pdedept = (Pdedept) o;
        return id == pdedept.id &&
                Objects.equals(dept, pdedept.dept) &&
                Objects.equals(pdeName, pdedept.pdeName) &&
                Objects.equals(content, pdedept.content) &&
                Objects.equals(goodNum, pdedept.goodNum) &&
                Objects.equals(badNum, pdedept.badNum) &&
                Objects.equals(hours, pdedept.hours) &&
                Objects.equals(exreason, pdedept.exreason) &&
                Objects.equals(pdeTime, pdedept.pdeTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dept, pdeName, content, goodNum, badNum, hours, exreason, pdeTime);
    }
}
