package com.ruoyi.project.agricultrue.cp.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.shiro.service.PasswordService;
import com.ruoyi.project.agricultrue.cp.mapper.CpaftersalesMapper;
import com.ruoyi.project.agricultrue.cp.mapper.CpworkerMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpaftersales;
import com.ruoyi.project.agricultrue.cp.pojo.Cpworker;
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
@RequestMapping("/cpworker")
public class CpworkerController {

    private String prefix = "agricultrue/cp/cpworker";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @GetMapping("/workerduty")
    public String configWorkerduty() {
        return "agricultrue/cp/cpworkerduty";
    }


    @Autowired
    private CpworkerMapper cpworkerMapper;


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
        pageIndex = (pageIndex - 1) * pageSize;
        String loginName = ShiroUtils.getLoginName();
        User user = userMapper.selectUserByLoginName(loginName);
        Long roleId = userRoleMapper.selectByUserId(user.getUserId());

        if (roleId == 6) {
            //如果是部门经理 ，只看到自己部门下的员工
            List<Cpworker> cpworkers = cpworkerMapper.selectDeptWorkers(loginName, pageIndex, pageSize);
            int count = cpworkerMapper.selectDeptWorkersCount(loginName);
            return TableModels.success(count, cpworkers);
        } else if (roleId == 8) {
            //如果是员工  只看到自己
            List<Cpworker> cpworkers = cpworkerMapper.selectMySelf(loginName);
            return TableModels.success(1, cpworkers);
        } else {
            List<Cpworker> datas = cpworkerMapper.list(pageIndex, pageSize);
            int count = cpworkerMapper.selectCount(new EntityWrapper<>());
            return TableModels.success(count, datas);
        }
    }

    @Autowired
    private CpaftersalesMapper cpaftersalesMapper;


    @RequestMapping("/workerdutylist")
    public @ResponseBody
    TableModels workerdutylist(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        String loginName = ShiroUtils.getLoginName();
        if (loginName.equals("admin")) {
            List<Cpaftersales> datas = cpaftersalesMapper.list(pageIndex, pageSize);
            int count = cpaftersalesMapper.selectCount(new EntityWrapper<>());
            return TableModels.success(count, datas);
        } else {
            List<Cpaftersales> datas = cpaftersalesMapper.listByCode(pageIndex, pageSize,loginName);
            int count = cpaftersalesMapper.selectCountByCode(loginName);
            return TableModels.success(count, datas);
        }
    }


    //获取所有员工
    @RequestMapping("/getWorkers")
    public @ResponseBody
    TableModels getWorkers() {
        List<Cpworker> cpworkers = cpworkerMapper.selectList(new EntityWrapper<>());
        return TableModels.success(cpworkers);
    }


    @RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Cpworker> datas = cpworkerMapper.conditionlSel(pageIndex, pageSize, value);
        int count = cpworkerMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }

    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Cpworker cpworker) {

        String loginName = cpworker.getCode();
        User user = userMapper.selectUserByLoginName(loginName);
        if (user != null) {
            return TableModels.failure();//用户名已存在
        }

        //插入一条数据到用户表
        User user1 = new User();
        user1.setUserName(cpworker.getName());
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
        userRole.setRoleId((long) 8);
        List<UserRole> userRoles = new ArrayList<>();
        userRoles.add(userRole);
        userRoleMapper.batchUserRole(userRoles);

        cpworkerMapper.insert(cpworker);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Cpworker cpworker = cpworkerMapper.selectById(id);
        return TableModels.success(cpworker);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Cpworker cpworker) {
        cpworkerMapper.updateById(cpworker);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        String code = cpworkerMapper.selectById(id).getCode();
        userMapper.deleteByLoginName(code);

        cpworkerMapper.deleteById(id);

        return TableModels.success();
    }

}
