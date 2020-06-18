package com.ruoyi.project.agricultrue.cp.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.cp.mapper.CpaftersalesMapper;
import com.ruoyi.project.agricultrue.cp.mapper.CpworkerMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpaftersales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cpaftersales")
public class CpaftersalesController {

    private String prefix = "agricultrue/cp/cpaftersales";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private CpaftersalesMapper cpaftersalesMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Cpaftersales> datas = cpaftersalesMapper.list(pageIndex, pageSize);
        int count = cpaftersalesMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

    @Autowired
    private CpworkerMapper cpworkerMapper;

    @RequestMapping("/updateHandleMan")
    public @ResponseBody
    TableModels updateHandleMan(@RequestParam("id") int id, @RequestParam("code") String code) {
        Cpaftersales cpaftersales = cpaftersalesMapper.selectById(id);
        cpaftersales.setHandleman(code);
        cpaftersalesMapper.updateById(cpaftersales);
        return TableModels.success();
    }

    @RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Cpaftersales> datas = cpaftersalesMapper.conditionlSel(pageIndex, pageSize, value);
        int count = cpaftersalesMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }

    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Cpaftersales cpaftersales) {
        cpaftersalesMapper.insert(cpaftersales);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Cpaftersales cpaftersales = cpaftersalesMapper.selectById(id);
        return TableModels.success(cpaftersales);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Cpaftersales cpaftersales) {
        cpaftersalesMapper.updateById(cpaftersales);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        cpaftersalesMapper.deleteById(id);
        return TableModels.success();
    }

}
