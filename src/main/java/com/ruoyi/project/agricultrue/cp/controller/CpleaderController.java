package com.ruoyi.project.agricultrue.cp.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.shiro.service.PasswordService;
import com.ruoyi.project.agricultrue.cp.mapper.CpleaderMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpleader;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.domain.UserRole;
import com.ruoyi.project.system.user.mapper.UserMapper;
import com.ruoyi.project.system.user.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/*
 * 角色划分：部门经理为6  人事经理为7   员工为8
 * */
@Controller
@RequestMapping("/cpleader")
public class CpleaderController {

    private String prefix = "agricultrue/cp/cpleader";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private CpleaderMapper cpleaderMapper;

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
        if (roleId == 6) {
            List<Cpleader> cpleaderList = cpleaderMapper.selectMySelf(loginName);
            return TableModels.success(1, cpleaderList);
        } else {
            pageIndex = (pageIndex - 1) * pageSize;
            List<Cpleader> datas = cpleaderMapper.list(pageIndex, pageSize);
            int count = cpleaderMapper.selectCount(new EntityWrapper<>());
            return TableModels.success(count, datas);
        }

    }

    @RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Cpleader> datas = cpleaderMapper.conditionlSel(pageIndex, pageSize, value);
        int count = cpleaderMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }

    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Cpleader cpleader) {
        String loginName = cpleader.getCode();
        User user = userMapper.selectUserByLoginName(loginName);
        if (user != null) {
            return TableModels.failure();//用户名已存在
        }

        //插入一条数据到用户表
        User user1 = new User();
        user1.setUserName(cpleader.getName());
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
        userRole.setRoleId((long) 6);
        List<UserRole> userRoles = new ArrayList<>();
        userRoles.add(userRole);
        userRoleMapper.batchUserRole(userRoles);
        cpleaderMapper.insert(cpleader);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Cpleader cpleader = cpleaderMapper.selectById(id);
        return TableModels.success(cpleader);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Cpleader cpleader) {
        cpleaderMapper.updateById(cpleader);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        String code = cpleaderMapper.selectById(id).getCode();
        userMapper.deleteByLoginName(code);
        cpleaderMapper.deleteById(id);
        return TableModels.success();
    }

}
