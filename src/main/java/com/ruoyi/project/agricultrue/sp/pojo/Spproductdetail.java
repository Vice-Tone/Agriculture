package com.ruoyi.project.agricultrue.sp.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity

@WebMapping(value = "spproductdetail")
public class Spproductdetail {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "品牌")
    private String brand;
    @FieldMapping(value = "产品类型")
    private String type;
    @FieldMapping(value = "售后服务")
    private String service;
    @FieldMapping(value = "加工定制")
    private String processing;
    @FieldMapping(value = "排气量")
    private String gas;
    @FieldMapping(value = "生产类型")
    private String produceType;
    @FieldMapping(value = "关联产品id")
    private Integer linkId;
    @FieldMapping(value = "简单介绍")
    private String brief;
    @FieldMapping(value = "详细介绍")
    private String detail;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "service")
    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Basic
    @Column(name = "processing")
    public String getProcessing() {
        return processing;
    }

    public void setProcessing(String processing) {
        this.processing = processing;
    }

    @Basic
    @Column(name = "gas")
    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    @Basic
    @Column(name = "produceType")
    public String getProduceType() {
        return produceType;
    }

    public void setProduceType(String produceType) {
        this.produceType = produceType;
    }

    @Basic
    @Column(name = "linkId")
    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    @Basic
    @Column(name = "brief")
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    @Basic
    @Column(name = "detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spproductdetail that = (Spproductdetail) o;
        return id == that.id &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(type, that.type) &&
                Objects.equals(service, that.service) &&
                Objects.equals(processing, that.processing) &&
                Objects.equals(gas, that.gas) &&
                Objects.equals(produceType, that.produceType) &&
                Objects.equals(linkId, that.linkId) &&
                Objects.equals(brief, that.brief) &&
                Objects.equals(detail, that.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, type, service, processing, gas, produceType, linkId, brief, detail);
    }
}
