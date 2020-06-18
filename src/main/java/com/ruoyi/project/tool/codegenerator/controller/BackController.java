package com.ruoyi.project.tool.codegenerator.controller;


import com.ruoyi.project.tool.codegenerator.constants.LocationConstants;

public class BackController {
    private String upperMapper;
    private String lowwerMapper;
    private String project;
    private MapperController mapperController;


    public BackController(String project, String pojoPackage) {
        this.project = project;
        this.mapperController = new MapperController(project,pojoPackage);
        this.upperMapper = mapperController.getMapperName();
        this.lowwerMapper = mapperController.getLowwerPojoName() + "Mapper";
    }

    public String getController() {
        String packageDeclaration = "package com.ruoyi.project." + project + ".controller;\n" +
                "import com.baomidou.mybatisplus.mapper.EntityWrapper;\n" +
                "import com.ruoyi.common.TableModels;\n" +
                "import " + this.mapperController.getMapperPackage() + ";\n" +
                "import " + this.mapperController.getPojoQuafierName() + ";\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.stereotype.Controller;\n" +
                "import org.springframework.ui.ModelMap;\n" +
                "import org.springframework.web.bind.annotation.GetMapping;\n" +
                "import org.springframework.web.bind.annotation.RequestMapping;\n" +
                "import org.springframework.web.bind.annotation.RequestParam;\n" +
                "import org.springframework.web.bind.annotation.ResponseBody;\n" +
                "import java.util.List;\n";

        String classDeclaration = "\n" +
                "@Controller\n" +
                "@RequestMapping(\"/" + this.mapperController.getLowwerPojoName() + "\")\n" +
                "public class " + this.mapperController.getUpperPojoName() + "Controller {\n" +
                "\n" +
                "    private String prefix = \"" + this.project + "/" + this.mapperController.getLowwerPojoName() + "\";\n" +
                "\n" +
                "    @GetMapping()\n" +
                "    public String config() {\n" +
                "        return prefix;\n" +
                "    }\n" +
                "\n" +
                "    @Autowired\n" +
                "    private " + this.mapperController.getUpperPojoName() + "Mapper " + this.mapperController.getLowwerPojoName() + "Mapper;\n" +
                "\n" +
                "    //列表\n" +
                "    @RequestMapping(\"/list\")\n" +
                "    public @ResponseBody\n" +
                "    TableModels list(@RequestParam(\"pageIndex\") int pageIndex\n" +
                "            , @RequestParam(\"pageSize\") int pageSize) {\n" +
                "        pageIndex = (pageIndex - 1) * pageSize;\n" +
                "        List<" + this.mapperController.getUpperPojoName() + "> datas = " + this.mapperController.getLowwerPojoName() + "Mapper.list(pageIndex, pageSize);\n" +
                "        int count = " + this.mapperController.getLowwerPojoName() + "Mapper.selectCount(new EntityWrapper<>());\n" +
                "        return TableModels.success(count, datas);\n" +
                "    }\n" +
                "\n" +
                "@RequestMapping(\"/conditionlSel\")\n" +
                "    public @ResponseBody\n" +
                "    TableModels conditionlSel(@RequestParam(\"pageIndex\") int pageIndex\n" +
                "            , @RequestParam(\"pageSize\") int pageSize,@RequestParam(name = \"value\", required = false, defaultValue = \"\") String value) {\n" +
               "         pageIndex = (pageIndex - 1) * pageSize;\n"+
                "        List<"+this.mapperController.getUpperPojoName()+"> datas = "+this.mapperController.getLowwerPojoName()+"Mapper.conditionlSel(pageIndex, pageSize, value);\n" +
                "        int count = "+this.mapperController.getLowwerPojoName()+"Mapper.conditionlSelCount(value);\n"+
                "        return TableModels.success(count, datas);\n" +
                "    }\n"+
                "    //添加\n" +
                "    @RequestMapping(\"/add\")\n" +
                "    public @ResponseBody\n" +
                "    TableModels add(" + this.mapperController.getUpperPojoName() + " " + this.mapperController.getLowwerPojoName() + ") {\n" +
                "        " + this.mapperController.getLowwerPojoName() + "Mapper.insert(" + this.mapperController.getLowwerPojoName() + ");\n" +
                "        return TableModels.success();\n" +
                "    }\n" +
                "\n" +
                "    //详情\n" +
                "    @RequestMapping(\"/detail\")\n" +
                "    public @ResponseBody\n" +
                "    TableModels detail(@RequestParam(\"id\") int id) {\n" +
                "        " + this.mapperController.getUpperPojoName() + " " + this.mapperController.getLowwerPojoName() + " = " + this.mapperController.getLowwerPojoName() + "Mapper.selectById(id);\n" +
                "        return TableModels.success(" + this.mapperController.getLowwerPojoName() + ");\n" +
                "    }\n" +
                "\n" +
                "    //编辑\n" +
                "    @RequestMapping(\"/edit\")\n" +
                "    public @ResponseBody\n" +
                "    TableModels edit(" + this.mapperController.getUpperPojoName() + " " + this.mapperController.getLowwerPojoName() + ") {\n" +
                "        " + this.mapperController.getLowwerPojoName() + "Mapper.updateById(" + this.mapperController.getLowwerPojoName() + ");\n" +
                "        return TableModels.success();\n" +
                "    }\n" +
                "\n" +
                "    //删除\n" +
                "    @RequestMapping(\"/delete\")\n" +
                "    public @ResponseBody\n" +
                "    TableModels delete(@RequestParam(\"id\") int id) {\n" +
                "        " + this.mapperController.getLowwerPojoName() + "Mapper.deleteById(id);\n" +
                "        return TableModels.success();\n" +
                "    }\n" +
                "\n" +
                "}\n";

        StringBuilder builder = new StringBuilder();
        builder.append(packageDeclaration);
        builder.append(classDeclaration);
        String content = builder.toString();
        String filePath = LocationConstants.CONTROLLER_LOCATION + "\\" + this.mapperController.getUpperPojoName() + "Controller.java";
        LocationConstants.writeToFile(content, filePath);
        return content;
    }


}
