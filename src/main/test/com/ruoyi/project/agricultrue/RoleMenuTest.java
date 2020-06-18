package com.ruoyi.project.agricultrue;

import com.ruoyi.AgricultrueApplication;
import com.ruoyi.project.system.role.domain.RoleMenu;
import com.ruoyi.project.system.role.mapper.RoleMenuMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = AgricultrueApplication.class)
@RunWith(SpringRunner.class)
public class RoleMenuTest {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Test
    public void link() {
        List<RoleMenu> roleMenus = new ArrayList<>();
        for (long roleId = 10; roleId <= 12; roleId++) {
            for (int i = 1062; i <= 1122; i++) {
                roleMenus.add(new RoleMenu(roleId, (long) i));
            }
        }

        roleMenuMapper.batchRoleMenu(roleMenus);
    }


    @Test
    public void removeLink() {

    }


}
