package com.ruoyi.project.agricultrue.jxc.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@WebMapping(value = "jxcsuppiler")
@Data
public class Jxcsuppiler {

    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "供应商名称")
    private String name;

}
