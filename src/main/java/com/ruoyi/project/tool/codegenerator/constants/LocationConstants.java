package com.ruoyi.project.tool.codegenerator.constants;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class LocationConstants {
    public static final String CONTROLLER_LOCATION = "D:\\workspace\\agriculture-machine\\locations";
    public static final String MAPPER_LOCATION = CONTROLLER_LOCATION;
    public static final String MAPPER_XML_LOCATION = MAPPER_LOCATION;
    public static final String HTML_LOCATION = MAPPER_XML_LOCATION;

    public static void writeToFile(String content, String filePath) {
        try {
            FileUtils.write(new File(filePath), content, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
