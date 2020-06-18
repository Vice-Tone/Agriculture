package com.ruoyi.project.agricultrue.pde.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@WebMapping(value = "pdeduty")
public class Pdeduty {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "阶段")
    private String stage;
    @FieldMapping(value = "内容")
    private String content;
    @FieldMapping(value = "预计完成时间")
    private String finishTime;

    @FieldMapping(value = "部门")
    private String dept;
    @FieldMapping(value = "负责人")
    private String charge;
    private int process;

    private String startTime;

    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

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
    @Column(name = "stage")
    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
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
    @Column(name = "finishTime")
    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
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
    @Column(name = "charge")
    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pdeduty pdeduty = (Pdeduty) o;
        return id == pdeduty.id &&
                Objects.equals(stage, pdeduty.stage) &&
                Objects.equals(content, pdeduty.content) &&
                Objects.equals(finishTime, pdeduty.finishTime) &&
                Objects.equals(dept, pdeduty.dept) &&
                Objects.equals(charge, pdeduty.charge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stage, content, finishTime, dept, charge);
    }
}
