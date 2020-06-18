package com.ruoyi.project.agricultrue.sp.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@WebMapping(value = "spconsul")
public class Spconsul {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "标题")
    private String title;
    @FieldMapping(value = "主要内容")
    private String content;
    @FieldMapping(value = "时间")
    private String updateTime;
    @FieldMapping(value = "来源")
    private String psource;
    @FieldMapping(value = "类别id")
    private Integer typeId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "updateTime")
    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }


    public String getPsource() {
        return psource;
    }

    public void setPsource(String psource) {
        this.psource = psource;
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
        Spconsul spconsul = (Spconsul) o;
        return id == spconsul.id &&
                Objects.equals(title, spconsul.title) &&
                Objects.equals(content, spconsul.content) &&
                Objects.equals(updateTime, spconsul.updateTime) &&
                Objects.equals(psource, spconsul.psource) &&
                Objects.equals(typeId, spconsul.typeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, updateTime, psource, typeId);
    }
}
