package com.ruoyi.project.agricultrue.cp.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@WebMapping("cpenrolladvice")
public class Cpenrolladvice {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "姓名")
    private String name;
    @FieldMapping(value = "性别")
    private String gender;
    @FieldMapping(value = "年龄")
    private int age;
    @FieldMapping(value = "籍贯")
    private String address;
    @FieldMapping(value = "学历")
    private String xueli;
    @FieldMapping(value = "技能特长")
    private String jineng;
    @FieldMapping(value = "应聘部门")
    private String dept;
    @FieldMapping(value = "应聘职位")
    private String job;
    @FieldMapping(value = "期望薪资")
    private String salary;
}
