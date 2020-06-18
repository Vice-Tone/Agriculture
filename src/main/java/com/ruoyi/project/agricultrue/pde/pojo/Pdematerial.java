package com.ruoyi.project.agricultrue.pde.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@WebMapping(value = "pdematerial")
public class Pdematerial {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "原料名")
    private String name;
    @FieldMapping(value = "预定计划")
    private String primaryplan;
    @FieldMapping(value = "实际计划")
    private String realplan;
    @FieldMapping(value = "详情")
    private String detail;
    @FieldMapping(value = "存放日期")
    private String saveTime;
    @FieldMapping(value = "日期整型值")
    private String saveLongTime;

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
    @Column(name = "primaryplan")
    public String getPrimaryplan() {
        return primaryplan;
    }

    public void setPrimaryplan(String primaryplan) {
        this.primaryplan = primaryplan;
    }

    @Basic
    @Column(name = "realplan")
    public String getRealplan() {
        return realplan;
    }

    public void setRealplan(String realplan) {
        this.realplan = realplan;
    }

    @Basic
    @Column(name = "detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Basic
    @Column(name = "saveTime")
    public String getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(String saveTime) {
        this.saveTime = saveTime;
    }

    @Basic
    @Column(name = "saveLongTime")
    public String getSaveLongTime() {
        return saveLongTime;
    }

    public void setSaveLongTime(String saveLongTime) {
        this.saveLongTime = saveLongTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pdematerial that = (Pdematerial) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(primaryplan, that.primaryplan) &&
                Objects.equals(realplan, that.realplan) &&
                Objects.equals(detail, that.detail) &&
                Objects.equals(saveTime, that.saveTime) &&
                Objects.equals(saveLongTime, that.saveLongTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, primaryplan, realplan, detail, saveTime, saveLongTime);
    }
}
