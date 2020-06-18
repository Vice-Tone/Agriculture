package com.ruoyi.project.agricultrue.sp.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@WebMapping(value = "spimage")
public class Spimage {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "关联产品id")
    private Integer linkId;
    @FieldMapping(value = "图片url")
    private String imageUrl;

    public Spimage(Integer linkId, String imageUrl) {
        this.linkId = linkId;
        this.imageUrl = imageUrl;
    }

    public Spimage() {
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
    @Column(name = "linkId")
    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    @Basic
    @Column(name = "imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spimage spimage = (Spimage) o;
        return id == spimage.id &&
                Objects.equals(linkId, spimage.linkId) &&
                Objects.equals(imageUrl, spimage.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, linkId, imageUrl);
    }
}
