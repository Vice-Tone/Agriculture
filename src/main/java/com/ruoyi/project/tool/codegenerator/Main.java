package com.ruoyi.project.tool.codegenerator;

import com.ruoyi.project.tool.codegenerator.controller.BackController;
import com.ruoyi.project.tool.codegenerator.controller.HtmlController;
import com.ruoyi.project.tool.codegenerator.controller.MapperController;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static String project = "agricultrue";

    public static void main(String[] args) {

        List<String> entityNames = new ArrayList<>();
        entityNames.add("com.ruoyi.project.agricultrue.sp.pojo.Spadvitisement");


        for (String entityName : entityNames) {
            BackController backController = new BackController(project, entityName);
            MapperController mapperController = new MapperController(project, entityName);
            HtmlController htmlController = new HtmlController(entityName);

            System.out.println(backController.getController());
            System.out.println(mapperController.getMapperClass());
            System.out.println(mapperController.getMapperXml());
            System.out.println(htmlController.getHtml());

        }

    }

}
