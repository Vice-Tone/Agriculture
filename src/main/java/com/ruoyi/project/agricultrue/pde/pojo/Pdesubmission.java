package com.ruoyi.project.agricultrue.pde.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@WebMapping(value = "pdesubmission")
public class Pdesubmission {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "名称")
    private String name;
    @FieldMapping(value = "状态")
    private String stau;
    @FieldMapping(value = "时间")
    private String createTime;
    @FieldMapping(value = "父级id")
    private int parentId;

    private String startTime;

    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


}
