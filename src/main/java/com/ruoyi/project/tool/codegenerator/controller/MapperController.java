package com.ruoyi.project.tool.codegenerator.controller;

import com.ruoyi.project.tool.codegenerator.constants.LocationConstants;

import java.lang.reflect.Field;

public class MapperController {

    private String mapperPackage;
    private String pojoQuafierName;

    private String lowwerPojoName;
    private String project;

    private String concatString;


    public MapperController(String project, String pojoPackage) {
        this.project = project;
        this.pojoQuafierName = pojoPackage;
        pojoPackage = pojoPackage.replaceAll("pojo", "mapper");
        this.mapperPackage = pojoPackage + "Mapper";
        String pojoname = pojoPackage.substring(pojoPackage.lastIndexOf(".") + 1, pojoPackage.length());
        this.mapperName = pojoname + "Mapper";
        String firstch = pojoname.charAt(0) + "";
        this.lowwerPojoName = firstch.toLowerCase() + pojoname.substring(1, pojoname.length());
        this.upperPojoName = firstch.toUpperCase() + pojoname.substring(1, pojoname.length());
        this.concatString = concatString();
    }

    public String concatString() {
        Class clazz = null;
        try {
            clazz = Class.forName(this.pojoQuafierName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder builder = new StringBuilder();
        for (Field field : fields) {
            builder.append(field.getName()).append(",");
        }
        String concat = builder.substring(0, builder.length() - 1);
        return concat;
    }

    public String getPojoQuafierName() {
        return pojoQuafierName;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public String getMapperName() {
        return mapperName;
    }

    public String getUpperPojoName() {
        return upperPojoName;
    }

    public String getLowwerPojoName() {
        return lowwerPojoName;
    }

    public String mapperName;
    public String upperPojoName;

    //得到Mapper类
    public String getMapperClass() {
        String packageDeclaration = "package com.ruoyi.project." + this.project + ".mapper;\n" +
                "import com.baomidou.mybatisplus.mapper.BaseMapper;\n" +
                "import " + this.getPojoQuafierName() + ";\n" +
                "import org.apache.ibatis.annotations.Param;\n" +
                "import java.util.List;\n";

        String classDeclaration = "public interface " + getMapperName() + " extends BaseMapper<" + getUpperPojoName() + "> {\n";
        classDeclaration += "List<" + getUpperPojoName() + "> list(@Param(\"pageIndex\") int pageIndex,@Param(\"pageSize\") int pageSize);\n";
        classDeclaration += "List<" + getUpperPojoName() + "> conditionlSel(@Param(\"pageIndex\") int pageIndex, @Param(\"pageSize\") int pageSize, @Param(\"value\") String value);\n" +
                        "    int conditionlSelCount(@Param(\"value\") String value); \n";
        classDeclaration += "}\n";
        StringBuilder builder = new StringBuilder();
        builder.append(packageDeclaration);
        builder.append(classDeclaration);

        String filePath = LocationConstants.MAPPER_LOCATION + "\\" + this.getMapperName() + ".java";
        LocationConstants.writeToFile(builder.toString(), filePath);
        return builder.toString();
    }

    //得到mapper.xml
    public String getMapperXml() {
        String mapperxml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >\n" +
                "<mapper namespace=\"" + getMapperPackage() + "\">\n" +
                "\n" +
                "  <select id=\"list\" resultType=\"" + getPojoQuafierName() + "\">\n" +
                "      SELECT * FROM " + this.lowwerPojoName + " order by id desc  limit #{pageIndex},#{pageSize}\n" +
                "  </select>\n" +
                "\n" +
                " <select id=\"conditionlSel\" resultType=\"" + this.pojoQuafierName + "\">\n" +
                "      select * from " + this.lowwerPojoName + " where concat(" + this.concatString + ") like '%${value}%' limit #{pageIndex},#{pageSize}\n" +
                "  </select>\n" +
                "\n" +
                "    <select id=\"conditionlSelCount\" resultType=\"int\">\n" +
                "        select count(*) from " + this.lowwerPojoName + " where concat(" + this.concatString + ") like '%${value}%'\n" +
                "    </select>" +
                "</mapper>";
        String filePath = LocationConstants.MAPPER_XML_LOCATION + "\\" + this.getMapperName() + ".xml";
        LocationConstants.writeToFile(mapperxml, filePath);
        return mapperxml;
    }

}
