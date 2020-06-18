package com.ruoyi.project.agricultrue.pde.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.agricultrue.pde.mapper.PdeworkerdutyMapper;
import com.ruoyi.project.agricultrue.pde.pojo.Pdeworkerduty;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.mapper.UserMapper;
import com.ruoyi.project.system.user.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/pdeworkerduty")
public class PdeworkerdutyController {

    private String prefix = "agricultrue/pde/pdeworkerduty";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private PdeworkerdutyMapper pdeworkerdutyMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

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
            List<Pdeworkerduty> datas = pdeworkerdutyMapper.selectByMobile(pageIndex, pageSize, loginName);
            int count = pdeworkerdutyMapper.selectCountByMobile(loginName);
            return TableModels.success(count, datas);
        } else {
            List<Pdeworkerduty> datas = pdeworkerdutyMapper.list(pageIndex, pageSize);
            int count = pdeworkerdutyMapper.selectCount(new EntityWrapper<>());
            return TableModels.success(count, datas);
        }
    }

    @RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Pdeworkerduty> datas = pdeworkerdutyMapper.conditionlSel(pageIndex, pageSize, value);
        int count = pdeworkerdutyMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }

    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Pdeworkerduty pdeworkerduty) {
        pdeworkerdutyMapper.insert(pdeworkerduty);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Pdeworkerduty pdeworkerduty = pdeworkerdutyMapper.selectById(id);
        return TableModels.success(pdeworkerduty);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Pdeworkerduty pdeworkerduty) {
        pdeworkerdutyMapper.updateById(pdeworkerduty);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        pdeworkerdutyMapper.deleteById(id);
        return TableModels.success();
    }

}
