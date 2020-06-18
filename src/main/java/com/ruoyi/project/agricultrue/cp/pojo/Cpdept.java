package com.ruoyi.project.agricultrue.cp.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@WebMapping("cpdept")
public class Cpdept {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "部门名称")
    private String name;
    @FieldMapping(value = "所在地")
    private String location;
    @FieldMapping(value = "备注")
    private String remark;

}
