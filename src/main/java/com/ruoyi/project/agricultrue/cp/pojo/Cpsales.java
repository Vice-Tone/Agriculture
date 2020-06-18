package com.ruoyi.project.agricultrue.cp.pojo;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@WebMapping("cpsales")
public class Cpsales {
    @FieldMapping(value = "编号",isNeed = false)
    private int id;
    @FieldMapping(value = "客户名")
    private String customer;
    @FieldMapping(value = "单据编号")
    private String receiptsCode;
    @FieldMapping(value = "商品信息")
    private String goodInfo;
    @FieldMapping(value = "单据日期")
    private String receiptsdate;
    @FieldMapping(value = "操作员")
    private String operator;
    @FieldMapping(value = "金额合计")
    private String total;
}
