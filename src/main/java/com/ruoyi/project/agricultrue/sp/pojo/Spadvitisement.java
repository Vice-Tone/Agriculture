package com.ruoyi.project.agricultrue.sp.pojo;


import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;

@Data
@ToString
@WebMapping(value = "spadvitisement")
public class Spadvitisement {

    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "广告位位置")
    private String name;
    @FieldMapping(value = "广告位图片")
    private String image;
}
