package com.ruoyi.project.agricultrue.sev.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@WebMapping(value = "sevenroll")
public class Sevenroll {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "标题")
    private String title;
    @FieldMapping(value = "内容")
    private String content;
    @FieldMapping(value = "发布时间")
    private String publishTime;

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
    @Column(name = "publishTime")
    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sevenroll sevenroll = (Sevenroll) o;
        return id == sevenroll.id &&
                Objects.equals(title, sevenroll.title) &&
                Objects.equals(content, sevenroll.content) &&
                Objects.equals(publishTime, sevenroll.publishTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, publishTime);
    }
}
