package com.ruoyi.project.agricultrue;

import com.ruoyi.AgricultrueApplication;
import com.ruoyi.common.TableModels;
import com.ruoyi.framework.shiro.service.PasswordService;
import com.ruoyi.project.system.role.domain.RoleMenu;
import com.ruoyi.project.system.role.mapper.RoleMenuMapper;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.domain.UserRole;
import com.ruoyi.project.system.user.mapper.UserMapper;
import com.ruoyi.project.system.user.mapper.UserRoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 17253 on 2020/3/19.
 */

@SpringBootTest(classes = AgricultrueApplication.class)
@RunWith(SpringRunner.class)
public class RoleTest {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private PasswordService passwordService;


    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Test
    public void link() {
        List<RoleMenu> roleMenus = new ArrayList<>();
        List<Long> roleIds = new ArrayList<>();
        //添加角色id

        roleIds.add((long) 16);
        for (Long roleId : roleIds) {
            for (long i = 1062; i <= 1168; i++) {
                roleMenus.add(new RoleMenu(roleId, i));
            }
            roleMenuMapper.batchRoleMenu(roleMenus);
        }

    }


    // 菜单编号从1062到1121
    //操作员：角色3 视图（）
    //财务经理:角色4 视图（）
    //管理员:jxc

    @Test
    public void addNewUser() {

        String loginName = "business";
        String name = "营销部";
        User user = userMapper.selectUserByLoginName(loginName);
        if (user != null) {
            System.out.println("用户名已存在");
            System.exit(0);
        }

        //插入一条数据到用户表
        User user1 = new User();
        user1.setUserName(name);
        user1.setLoginName(loginName);
        user1.setSalt(loginName);
        String password = passwordService.encryptPassword(loginName, loginName, loginName);
        user1.setPassword(password);
        user1.setStatus("0");
        user1.setDelFlag("0");
        userMapper.insertUser(user1);

        //插入成功以后 根据loginName查询用户信息
        user = userMapper.selectUserByLoginName(loginName);
        long userId = user.getUserId();
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId((long) 16);
        List<UserRole> userRoles = new ArrayList<>();
        userRoles.add(userRole);
        userRoleMapper.batchUserRole(userRoles);

    }


}
