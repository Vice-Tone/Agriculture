package com.ruoyi.project.agricultrue.pde.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@WebMapping(value = "pdeworker")
public class Pdeworker {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "姓名")
    private String name;
    @FieldMapping(value = "性别")
    private String gender;
    @FieldMapping(value = "部门")
    private String dept;
    @FieldMapping(value = "职位")
    private String post;
    @FieldMapping(value = "联系方式")
    private String mobile;
    @FieldMapping(value = "负责工序")
    private String processing;
    @FieldMapping(value = "工龄")
    private Integer workage;

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
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
    @Column(name = "post")
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
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
    @Column(name = "processing")
    public String getProcessing() {
        return processing;
    }

    public void setProcessing(String processing) {
        this.processing = processing;
    }

    @Basic
    @Column(name = "workage")
    public Integer getWorkage() {
        return workage;
    }

    public void setWorkage(Integer workage) {
        this.workage = workage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pdeworker pdeworker = (Pdeworker) o;
        return id == pdeworker.id &&
                Objects.equals(name, pdeworker.name) &&
                Objects.equals(gender, pdeworker.gender) &&
                Objects.equals(dept, pdeworker.dept) &&
                Objects.equals(post, pdeworker.post) &&
                Objects.equals(mobile, pdeworker.mobile) &&
                Objects.equals(processing, pdeworker.processing) &&
                Objects.equals(workage, pdeworker.workage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, dept, post, mobile, processing, workage);
    }
}
