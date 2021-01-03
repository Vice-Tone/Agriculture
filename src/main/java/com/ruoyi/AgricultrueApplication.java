package com.ruoyi;

import com.ruoyi.common.utils.SnowflakeIdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

/* 启动程序
* 新增
* 销售部selling roleId 15
* 营销部business roleId 16
* */
@MapperScan(basePackages = {"com.ruoyi.project.agricultrue.mapper",
        "com.ruoyi.project.tool.gen.mapper",
        "com.ruoyi.project.system.*.mapper",
        "com.ruoyi.project.monitor.*.mapper"
        , "com.ruoyi.project.agricultrue.*.mapper"})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AgricultrueApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgricultrueApplication.class, args);
    }

    @Bean
    public SnowflakeIdWorker snowflakeIdWorker() {
        return new SnowflakeIdWorker(0, 0);
    }


//    public static class SpringBeanNameGenerator extends AnnotationBeanNameGenerator {
//        @Override
//        protected String buildDefaultBeanName(BeanDefinition definition) {
//            if (definition instanceof AnnotatedBeanDefinition) {
//                String beanName = determineBeanNameFromAnnotation((AnnotatedBeanDefinition) definition);
//                if (StringUtils.hasText(beanName)) {
//                    // Explicit bean name found.
//                    return beanName;
//                }
//            }
//            return definition.getBeanClassName();
//        }
//    }

}