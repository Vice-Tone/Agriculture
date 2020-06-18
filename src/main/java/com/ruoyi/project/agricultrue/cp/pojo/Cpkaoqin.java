package com.ruoyi.project.agricultrue.cp.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@WebMapping("cpkaoqin")
public class Cpkaoqin {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "工号")
    private String code;
    @FieldMapping(value = "姓名")
    private String name;
    @FieldMapping(value = "所在部门")
    private String dept;
    @FieldMapping(value = "请假日期")
    private String qingjia;
    @FieldMapping(value = "旷工时长")
    private String kuanggong;

}
