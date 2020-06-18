package com.ruoyi.project.tool.codegenerator.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Data
@ToString
@WebMapping(value = "activity")
public class Activity {

    @FieldMapping(value = "编号",isNeed = false)
    private int id;
    @FieldMapping(value = "标题")
    private String title;
    @FieldMapping(value = "内容")
    private String content;
    @FieldMapping(value = "日期")
    private String day;

    @FieldMapping(value = "组织方")
    private String organizer;

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
    @Column(name = "day")
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Basic
    @Column(name = "organizer")
    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return id == activity.id &&
                Objects.equals(title, activity.title) &&
                Objects.equals(content, activity.content) &&
                Objects.equals(day, activity.day) &&
                Objects.equals(organizer, activity.organizer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, day, organizer);
    }
}
