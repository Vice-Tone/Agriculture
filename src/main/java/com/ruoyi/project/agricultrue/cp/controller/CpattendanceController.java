package com.ruoyi.project.agricultrue.cp.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.DateUtils2;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.agricultrue.cp.mapper.CpattendanceMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpattendance;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.mapper.UserMapper;
import com.ruoyi.project.system.user.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/*
 * 角色划分：部门经理为6  人事经理为7   员工为8
 * */
@Controller
@RequestMapping("/cpattendance")
public class CpattendanceController {

    private String prefix = "agricultrue/cp/cpattendance";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private CpattendanceMapper cpattendanceMapper;
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
        //如果是員工看到自己所有考勤信息
        if (roleId == 8) {
            List<Cpattendance> cpattendances = cpattendanceMapper.selectMyAttendence(loginName, pageIndex, pageSize);
            int count = cpattendanceMapper.selectMyAttendenceCount(loginName);
            return TableModels.success(count, cpattendances);
        }
        List<Cpattendance> datas = cpattendanceMapper.list(pageIndex, pageSize);
        int count = cpattendanceMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

    @RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Cpattendance> datas = cpattendanceMapper.conditionlSel(pageIndex, pageSize, value);
        int count = cpattendanceMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }

    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Cpattendance cpattendance) {
        String code = cpattendance.getCode();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dayTime = format.format(new Date());
        Cpattendance tmp = cpattendanceMapper.selectCodeDayTime(code, dayTime);
        if (tmp != null) {
            return TableModels.failure("今日已打卡");
        }
        format = new SimpleDateFormat("HH:mm:ss");
        String realTime = format.format(new Date());
        cpattendance.setRealTime(realTime);
        cpattendance.setDayTime(dayTime);
        try {
            long datemillsReal = DateUtils2.getLongByStr(realTime, "HH:mm:ss");
            long datemillsStandard = DateUtils2.getLongByStr("09:00:00", "HH:mm:ss");
//          判断是否旷工
//            long datemillsStandard2 = DateUtils2.getLongByStr("09:30:00", "HH:mm:ss");
//            long datemillsStandard3 = DateUtils2.getLongByStr("16:30:00", "HH:mm:ss");
//            long datemillsStandard4 = DateUtils2.getLongByStr("17:00:00", "HH:mm:ss");
//            String delay2 = "未旷工";
//            if(datemillsReal>datemillsStandard3 && datemillsReal<datemillsStandard4){
//                delay2 = "旷工";
//            }
            //判断是否迟到
            String delay = "未迟到";
            if (datemillsReal > datemillsStandard) delay = "迟到";
            System.out.println(delay);
            cpattendance.setDelay(delay);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        cpattendanceMapper.insert(cpattendance);


        return TableModels.success("打卡成功");
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Cpattendance cpattendance = cpattendanceMapper.selectById(id);
        return TableModels.success(cpattendance);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Cpattendance cpattendance) {
        cpattendanceMapper.updateById(cpattendance);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        cpattendanceMapper.deleteById(id);
        return TableModels.success();
    }

}
