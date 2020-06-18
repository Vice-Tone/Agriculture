package com.ruoyi.project.agricultrue.sev.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@WebMapping(value = "sevcarousel")
public class Sevcarousel {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "轮播图名称")
    private String name;
    @FieldMapping(value = "轮播图图片")
    private String image;


}
