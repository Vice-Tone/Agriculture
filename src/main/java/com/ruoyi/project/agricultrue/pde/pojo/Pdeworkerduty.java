package com.ruoyi.project.agricultrue.pde.pojo;


import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;
import lombok.Data;

@Data
@WebMapping(value = "pdeworkerduty")
public class Pdeworkerduty {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "阶段")
    private String stage;
    @FieldMapping(value = "生产内容")
    private String produce;
    @FieldMapping(value = "完成时间")
    private String finishTime;
    @FieldMapping(value = "负责人编号")
    private String chargecode;
    @FieldMapping(value = "负责人")
    private String chargename;



}
