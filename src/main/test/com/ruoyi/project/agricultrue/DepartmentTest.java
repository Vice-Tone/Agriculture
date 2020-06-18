package com.ruoyi.project.agricultrue;


import com.ruoyi.AgricultrueApplication;
import com.ruoyi.project.system.dept.domain.Dept;
import com.ruoyi.project.system.dept.mapper.DeptMapper;
import com.ruoyi.project.system.user.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = AgricultrueApplication.class)
@RunWith(SpringRunner.class)
public class DepartmentTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DeptMapper deptMapper;


    @Test
    public void getDeptName() {
        String loginname = "admin";
        Long deptId = userMapper.selectUserByLoginName(loginname).getDeptId();
        Dept dept=deptMapper.selectDeptById(deptId);

    }

}
