package com.ruoyi.project.tool.codegenerator.pojo;

import com.baomidou.mybatisplus.annotations.TableName;
import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@WebMapping(value = "songs")
@TableName(value = "songs")
public class Songs {
    @FieldMapping
    private int id;
    @FieldMapping
    private String songName;
    @FieldMapping
    private String author;
    @FieldMapping
    private String type;
    @FieldMapping
    private String headImage;
    @FieldMapping
    private String conentUrl;
}