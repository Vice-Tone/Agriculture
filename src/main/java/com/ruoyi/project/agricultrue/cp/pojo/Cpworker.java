package com.ruoyi.project.agricultrue.cp.pojo;


import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@WebMapping("cpworker")
public class Cpworker {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "工号")
    private String code;
    @FieldMapping(value = "姓名")
    private String name;
    @FieldMapping(value = "性别")
    private String gender;
    @FieldMapping(value = "手机号")
    private String phone;
    @FieldMapping(value = "邮箱")
    private String email;
    @FieldMapping(value = "所在部门")
    private String dept;
    @FieldMapping(value = "部门id")
    private Integer deptId;
    @FieldMapping(value = "部门经理编号")
    private String leadercode;

}
