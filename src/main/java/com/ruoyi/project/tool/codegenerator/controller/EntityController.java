package com.ruoyi.project.tool.codegenerator.controller;

import com.ruoyi.project.tool.codegenerator.utils.SqlTableAnalysis;

import java.util.HashMap;
import java.util.List;

/*
 * 用法：传入数据库表名
 * */
public class EntityController {

    private String tableName;
    private HashMap<String, String> table2Entity = new HashMap<>();

    {
        table2Entity.put("VARCHAR", "String");
        table2Entity.put("INT", "int");
    }

    public EntityController() {
    }

    public EntityController(String tableName) {
        this.tableName = tableName;
    }


    public String getEntity() {
        SqlTableAnalysis sqlTableAnalysis = new SqlTableAnalysis();
        List<String> colTypes = sqlTableAnalysis.getColumnTypes(tableName);
        List<String> colNames = sqlTableAnalysis.getColumnNames(tableName);

        String backUrl = tableName;
        //生成类名
        String firstCh = tableName.charAt(0) + "";
        tableName = tableName.substring(1, tableName.length());
        String entityClassName = firstCh.toUpperCase() + tableName;

        String packageHeader = "import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;\n" +
                "import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;\n" +
                "import com.baomidou.mybatisplus.annotations.TableName;\n" +
                "import lombok.ToString;\n" +
                "import lombok.Data;\n";

        String entityClass = "@Data\n" +
                "@ToString\n" +
                "@WebMapping(value = \"" + backUrl + "\")\n" +
                "@TableName(value = \"" + backUrl + "\")\n" +
                "public class " + entityClassName + " {\n";


        for (int i = 0; i < colNames.size(); i++) {
            String type = colTypes.get(i);
            String name = colNames.get(i);
            entityClass += " @FieldMapping\n" +
                    "    private " + table2Entity.get(type) + " " + name + ";\n";
        }

        entityClass += "}\n";

        StringBuilder builder = new StringBuilder();
        builder.append(packageHeader);
        builder.append(entityClass);

        return builder.toString();
    }


}
