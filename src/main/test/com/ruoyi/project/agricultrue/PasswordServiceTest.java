package com.ruoyi.project.agricultrue;

import com.ruoyi.AgricultrueApplication;
import com.ruoyi.framework.shiro.service.PasswordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = AgricultrueApplication.class)
@RunWith(SpringRunner.class)
public class PasswordServiceTest {

    @Autowired
    private PasswordService passwordService;

    @Test
    public void test(){
        String code="13633809314";
        String password=passwordService.encryptPassword(code,code,code);
        //user.setPassword();
        System.out.println("  "+password);
    }
}
