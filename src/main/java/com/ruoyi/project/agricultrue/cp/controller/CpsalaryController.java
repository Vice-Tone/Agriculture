package com.ruoyi.project.agricultrue.cp.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.agricultrue.cp.mapper.CpsalaryMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpsalary;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.mapper.UserMapper;
import com.ruoyi.project.system.user.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/cpsalary")
public class CpsalaryController {

    private String prefix = "agricultrue/cp/cpsalary";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private CpsalaryMapper cpsalaryMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        String loginName = ShiroUtils.getLoginName();
        User user = userMapper.selectUserByLoginName(loginName);
        Long roleId = userRoleMapper.selectByUserId(user.getUserId());
        if (roleId == 8) {
            //如果是员工  看到自己所有薪水
            List<Cpsalary> cpsalaries = cpsalaryMapper.selectMySalary(loginName, pageIndex, pageSize);
            int count = cpsalaryMapper.selectMySalaryCount(loginName);
            return TableModels.success(count, cpsalaries);
        }

        List<Cpsalary> datas = cpsalaryMapper.list(pageIndex, pageSize);
        int count = cpsalaryMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

    @RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Cpsalary> datas = cpsalaryMapper.conditionlSel(pageIndex, pageSize, value);
        int count = cpsalaryMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }

    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Cpsalary cpsalary) {
        String code = cpsalary.getCode();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        String dayTime = format.format(new Date());
        Cpsalary tmp = cpsalaryMapper.selectByCodeDayTime(code, dayTime);
        if (tmp != null) {
            return TableModels.failure("已分配工资");
        }
        cpsalary.setCreateTime(dayTime);
        cpsalaryMapper.insert(cpsalary);
        return TableModels.success("分配成功");
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Cpsalary cpsalary = cpsalaryMapper.selectById(id);
        return TableModels.success(cpsalary);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Cpsalary cpsalary) {
        cpsalaryMapper.updateById(cpsalary);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        cpsalaryMapper.deleteById(id);
        return TableModels.success();
    }

}
