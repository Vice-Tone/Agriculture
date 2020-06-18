package com.ruoyi.project.agricultrue.cp.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@WebMapping("cpsalary")
public class Cpsalary {
    @FieldMapping(value = "编号",isNeed =false)
    private int id;
    @FieldMapping(value = "工号")
    private String code;
    @FieldMapping(value = "姓名")
    private String name;
    @FieldMapping(value = "所在部门")
    private String dept;
    @FieldMapping(value = "基本工资")
    private String salary;
    @FieldMapping(value = "绩效提成")
    private String hance;
    @FieldMapping(value = "当月日期")
    private String createTime;
    @FieldMapping(value = "部门id")
    private Integer deptId;
    @FieldMapping(value = "部门经理编号")
    private String leadercode;

    private String jishigongzi;//计时工资
    private String jijiangongzi;//计件工资
    private String jiabangongzi;//加班工资
    private String jintie;//津贴
    private String butie;//补贴
    private String bingjiagongzi;//病假工资


}
