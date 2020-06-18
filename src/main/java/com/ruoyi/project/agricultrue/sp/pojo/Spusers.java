package com.ruoyi.project.agricultrue.sp.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@WebMapping(value = "spusers")
public class Spusers {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "用户名")
    private String username;
    @FieldMapping(value = "密码")
    private String password;
    @FieldMapping(value = "姓名")
    private String name;
    @FieldMapping(value = "性别")
    private String gender;
    @FieldMapping(value = "学校")
    private String school;
    @FieldMapping(value = "专业")
    private String profession;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    @Column(name = "school")
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Basic
    @Column(name = "profession")
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spusers spusers = (Spusers) o;
        return id == spusers.id &&
                Objects.equals(username, spusers.username) &&
                Objects.equals(password, spusers.password) &&
                Objects.equals(name, spusers.name) &&
                Objects.equals(gender, spusers.gender) &&
                Objects.equals(school, spusers.school) &&
                Objects.equals(profession, spusers.profession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, name, gender, school, profession);
    }
}
