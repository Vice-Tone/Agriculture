package com.ruoyi.project.agricultrue;

import com.ruoyi.project.tool.codegenerator.interfaces.FieldMapping;
import com.ruoyi.project.tool.codegenerator.interfaces.WebMapping;
import org.junit.Test;

import java.lang.reflect.Field;

public class FieldMappingTest {

    @Test
    public void getFieldMapping() {
        try {
            Class clazz = Class.forName("com.ruoyi.project.tool.codegenerator.pojo.Activity");
            if (clazz.isAnnotationPresent(WebMapping.class)) {
                WebMapping webAnno = (WebMapping) clazz.getAnnotation(WebMapping.class);
                String value = webAnno.value();
                System.out.println(" web mappings:{}  " + value);
            }
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                FieldMapping fieldMapping = field.getAnnotation(FieldMapping.class);
                String value = fieldMapping.value();
                System.out.println(field.getName() + " value:{}  " + value);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
