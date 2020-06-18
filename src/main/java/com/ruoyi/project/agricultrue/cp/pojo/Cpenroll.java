package com.ruoyi.project.agricultrue.cp.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@WebMapping("cpenroll")
public class Cpenroll {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "招聘内容")
    private String content;
    @FieldMapping(value = "招聘部门")
    private String dept;
    @FieldMapping(value = "发布人")
    private String publishman;
    @FieldMapping(value = "发布时间")
    private String publishTime;


}
