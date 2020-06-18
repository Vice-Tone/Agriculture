package com.ruoyi.project.agricultrue.cp.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@WebMapping("cpattendance")
public class Cpattendance {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "工号")
    private String code;
    @FieldMapping(value = "姓名")
    private String name;
    @FieldMapping(value = "所在部门")
    private String dept;
    @FieldMapping(value = "打卡时间")
    private String realTime;
    @FieldMapping(value = "考勤日期")
    private String dayTime;
    @FieldMapping(value = "部门id")
    private Integer deptId;
    @FieldMapping(value = "部门经理编号")
    private String leadercode;

    private String delay;//是否迟到



}
