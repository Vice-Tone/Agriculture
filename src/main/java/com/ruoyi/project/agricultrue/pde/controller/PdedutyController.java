package com.ruoyi.project.agricultrue.pde.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.pde.mapper.PdedutyMapper;
import com.ruoyi.project.agricultrue.pde.pojo.Pdeduty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/pdeduty")
public class PdedutyController {

    private String prefix = "agricultrue/pde/pdeduty";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private PdedutyMapper pdedutyMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Pdeduty> datas = pdedutyMapper.list(pageIndex, pageSize);
        int count = pdedutyMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

    @RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Pdeduty> datas = pdedutyMapper.conditionlSel(pageIndex, pageSize, value);
        int count = pdedutyMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }

    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Pdeduty pdeduty) {
        pdedutyMapper.insert(pdeduty);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Pdeduty pdeduty = pdedutyMapper.selectById(id);
        return TableModels.success(pdeduty);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Pdeduty pdeduty) {
        pdedutyMapper.updateById(pdeduty);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        pdedutyMapper.deleteById(id);
        return TableModels.success();
    }

}
