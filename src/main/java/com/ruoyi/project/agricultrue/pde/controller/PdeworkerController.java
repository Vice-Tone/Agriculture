package com.ruoyi.project.agricultrue.pde.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.shiro.service.PasswordService;
import com.ruoyi.project.agricultrue.pde.mapper.PdeworkerMapper;
import com.ruoyi.project.agricultrue.pde.pojo.Pdeworker;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.domain.UserRole;
import com.ruoyi.project.system.user.mapper.UserMapper;
import com.ruoyi.project.system.user.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pdeworker")
public class PdeworkerController {

    private String prefix = "agricultrue/pde/pdeworker";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private PdeworkerMapper pdeworkerMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private PasswordService passwordService;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        String loginName = ShiroUtils.getLoginName();
        User user = userMapper.selectUserByLoginName(loginName);
        Long roleId = userRoleMapper.selectByUserId(user.getUserId());
        pageIndex = (pageIndex - 1) * pageSize;
        //如果是普通员工
        if (roleId == 10) {
            List<Pdeworker> datas = pdeworkerMapper.selectMySelf(loginName);
            int count = 1;
            return TableModels.success(count, datas);
        } else {
            List<Pdeworker> datas = pdeworkerMapper.list(pageIndex, pageSize);
            int count = pdeworkerMapper.selectCount(new EntityWrapper<>());
            return TableModels.success(count, datas);
        }


    }

    @RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Pdeworker> datas = pdeworkerMapper.conditionlSel(pageIndex, pageSize, value);
        int count = pdeworkerMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }

    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Pdeworker pdeworker) {
        String loginName = pdeworker.getMobile();
        User user = userMapper.selectUserByLoginName(loginName);
        if (user != null) {
            return TableModels.failure("用户名已存在");
        }

        //插入一条数据到用户表
        User user1 = new User();
        user1.setUserName("匿名用户");
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
        userRole.setRoleId((long) 10);
        List<UserRole> userRoles = new ArrayList<>();
        userRoles.add(userRole);
        userRoleMapper.batchUserRole(userRoles);

        pdeworkerMapper.insert(pdeworker);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Pdeworker pdeworker = pdeworkerMapper.selectById(id);
        return TableModels.success(pdeworker);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Pdeworker pdeworker) {
        pdeworkerMapper.updateById(pdeworker);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        Pdeworker pdeworker = pdeworkerMapper.selectById(id);
        pdeworkerMapper.deleteById(id);
        userMapper.deleteByLoginName(pdeworker.getMobile());
        return TableModels.success();
    }

}
