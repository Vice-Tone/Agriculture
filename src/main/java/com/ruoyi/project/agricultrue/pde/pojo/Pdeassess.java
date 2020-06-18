package com.ruoyi.project.agricultrue.pde.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@WebMapping(value = "pdeassess")
public class Pdeassess {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "姓名")
    private String name;
    @FieldMapping(value = "部门")
    private String dept;
    @FieldMapping(value = "专业技能得分")
    private Integer skillscore;
    @FieldMapping(value = "沟通协调得分")
    private Integer commucationscore;
    @FieldMapping(value = "工作效率得分")
    private Integer efficientscore;
    @FieldMapping(value = "计划能力得分")
    private Integer planscore;
    @FieldMapping(value = "工作态度得分")
    private Integer attitudescore;
    @FieldMapping(value = "考核日期")
    private String assessTime;
    @FieldMapping(value = "考核日期整型")
    private String assessLongTime;
    @FieldMapping(value = "领导意见")
    private String comments;


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
    @Column(name = "dept")
    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Basic
    @Column(name = "skillscore")
    public Integer getSkillscore() {
        return skillscore;
    }

    public void setSkillscore(Integer skillscore) {
        this.skillscore = skillscore;
    }

    @Basic
    @Column(name = "commucationscore")
    public Integer getCommucationscore() {
        return commucationscore;
    }

    public void setCommucationscore(Integer commucationscore) {
        this.commucationscore = commucationscore;
    }

    @Basic
    @Column(name = "efficientscore")
    public Integer getEfficientscore() {
        return efficientscore;
    }

    public void setEfficientscore(Integer efficientscore) {
        this.efficientscore = efficientscore;
    }

    @Basic
    @Column(name = "planscore")
    public Integer getPlanscore() {
        return planscore;
    }

    public void setPlanscore(Integer planscore) {
        this.planscore = planscore;
    }

    @Basic
    @Column(name = "attitudescore")
    public Integer getAttitudescore() {
        return attitudescore;
    }

    public void setAttitudescore(Integer attitudescore) {
        this.attitudescore = attitudescore;
    }

    @Basic
    @Column(name = "assessTime")
    public String getAssessTime() {
        return assessTime;
    }

    public void setAssessTime(String assessTime) {
        this.assessTime = assessTime;
    }

    @Basic
    @Column(name = "assessLongTime")
    public String getAssessLongTime() {
        return assessLongTime;
    }

    public void setAssessLongTime(String assessLongTime) {
        this.assessLongTime = assessLongTime;
    }

    @Basic
    @Column(name = "comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pdeassess pdeassess = (Pdeassess) o;
        return id == pdeassess.id &&
                Objects.equals(name, pdeassess.name) &&
                Objects.equals(dept, pdeassess.dept) &&
                Objects.equals(skillscore, pdeassess.skillscore) &&
                Objects.equals(commucationscore, pdeassess.commucationscore) &&
                Objects.equals(efficientscore, pdeassess.efficientscore) &&
                Objects.equals(planscore, pdeassess.planscore) &&
                Objects.equals(attitudescore, pdeassess.attitudescore) &&
                Objects.equals(assessTime, pdeassess.assessTime) &&
                Objects.equals(assessLongTime, pdeassess.assessLongTime) &&
                Objects.equals(comments, pdeassess.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dept, skillscore, commucationscore, efficientscore, planscore, attitudescore, assessTime, assessLongTime, comments);
    }
}
