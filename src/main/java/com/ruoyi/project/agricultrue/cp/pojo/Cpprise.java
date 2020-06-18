package com.ruoyi.project.agricultrue.cp.pojo;


import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@WebMapping("cpprise")
public class Cpprise {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "员工编号")
    private String code;
    @FieldMapping(value = "姓名")
    private String name;
    @FieldMapping(value = "所在部门")
    private String dept;
    @FieldMapping(value = "奖金")
    private String prise;
    @FieldMapping(value = "发放日期")
    private String dayTime;
    @FieldMapping(value = "部门id")
    private Integer deptId;
    @FieldMapping(value = "部门经理编号")
    private String leadercode;
}
