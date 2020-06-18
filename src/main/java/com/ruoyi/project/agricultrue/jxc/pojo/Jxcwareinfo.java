package com.ruoyi.project.agricultrue.jxc.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@WebMapping(value = "jxcwareinfo")
public class Jxcwareinfo {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "仓库名称")
    private String warename;
    @FieldMapping(value = "仓库地址")
    private String warelocation;
    @FieldMapping(value = "仓储费")
    private String storefee;
    @FieldMapping(value = "搬运费")
    private String transfee;
    @FieldMapping(value = "负责人")
    private String charge;
    @FieldMapping(value = "负责人电话")
    private String chargephone;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "warename")
    public String getWarename() {
        return warename;
    }

    public void setWarename(String warename) {
        this.warename = warename;
    }

    @Basic
    @Column(name = "warelocation")
    public String getWarelocation() {
        return warelocation;
    }

    public void setWarelocation(String warelocation) {
        this.warelocation = warelocation;
    }

    @Basic
    @Column(name = "storefee")
    public String getStorefee() {
        return storefee;
    }

    public void setStorefee(String storefee) {
        this.storefee = storefee;
    }

    @Basic
    @Column(name = "transfee")
    public String getTransfee() {
        return transfee;
    }

    public void setTransfee(String transfee) {
        this.transfee = transfee;
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
    @Column(name = "chargephone")
    public String getChargephone() {
        return chargephone;
    }

    public void setChargephone(String chargephone) {
        this.chargephone = chargephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jxcwareinfo that = (Jxcwareinfo) o;
        return id == that.id &&
                Objects.equals(warename, that.warename) &&
                Objects.equals(warelocation, that.warelocation) &&
                Objects.equals(storefee, that.storefee) &&
                Objects.equals(transfee, that.transfee) &&
                Objects.equals(charge, that.charge) &&
                Objects.equals(chargephone, that.chargephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, warename, warelocation, storefee, transfee, charge, chargephone);
    }
}
