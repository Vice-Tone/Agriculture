package com.ruoyi.project.agricultrue.cp.pojo;


import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@WebMapping("cpcustomer")
public class Cpcustomer {
    @FieldMapping(value = "编号", isNeed = false)
    private int id;
    @FieldMapping(value = "客户名")
    private String name;
    @FieldMapping(value = "性别")
    private String gender;
    @FieldMapping(value = "手机号码")
    private String phone;
    @FieldMapping(value = "电子邮箱")
    private String email;
    @FieldMapping(value = "邮政编号")
    private String postcode;
    @FieldMapping(value = "所在公司")
    private String company;
    @FieldMapping(value = "职位")
    private String position;
}
