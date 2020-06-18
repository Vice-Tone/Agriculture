package com.ruoyi.project.agricultrue.cp.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@WebMapping(value = "cpaftersales")
public class Cpaftersales {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "订单编号")
    private String orderNum;
    @FieldMapping(value = "订单名称")
    private String orderName;
    @FieldMapping(value = "客户编号")
    private String customername;
    @FieldMapping(value = "客户姓名")
    private String customName;
    @FieldMapping(value = "问题详情")
    private String problem;
    @FieldMapping(value = "售后处理人")
    private String handleman;
    @FieldMapping(value = "处理详情")
    private String handleDetail;
    @FieldMapping(value = "处理进度")
    private int process;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "orderNum")
    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    @Basic
    @Column(name = "orderName")
    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Basic
    @Column(name = "customername")
    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    @Basic
    @Column(name = "customName")
    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    @Basic
    @Column(name = "problem")
    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    @Basic
    @Column(name = "handleman")
    public String getHandleman() {
        return handleman;
    }

    public void setHandleman(String handleman) {
        this.handleman = handleman;
    }

    @Basic
    @Column(name = "handleDetail")
    public String getHandleDetail() {
        return handleDetail;
    }

    public void setHandleDetail(String handleDetail) {
        this.handleDetail = handleDetail;
    }


    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cpaftersales that = (Cpaftersales) o;
        return id == that.id &&
                process == that.process &&
                Objects.equals(orderNum, that.orderNum) &&
                Objects.equals(orderName, that.orderName) &&
                Objects.equals(customername, that.customername) &&
                Objects.equals(customName, that.customName) &&
                Objects.equals(problem, that.problem) &&
                Objects.equals(handleman, that.handleman) &&
                Objects.equals(handleDetail, that.handleDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderNum, orderName, customername, customName, problem, handleman, handleDetail, process);
    }
}
