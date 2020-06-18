package com.ruoyi.project.agricultrue.jxc.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.jxc.mapper.JxcsuppilerMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcsuppiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/jxcsuppiler")
public class JxcsuppilerController {

    private String prefix = "agricultrue/jxc/jxcsuppiler";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private JxcsuppilerMapper jxcsuppilerMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcsuppiler> datas = jxcsuppilerMapper.list(pageIndex, pageSize);
        int count = jxcsuppilerMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

    @RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcsuppiler> datas = jxcsuppilerMapper.conditionlSel(pageIndex, pageSize, value);
        int count = jxcsuppilerMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }

    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Jxcsuppiler jxcsuppiler) {
        jxcsuppilerMapper.insert(jxcsuppiler);
        return TableModels.success();
    }

    //供应商
    @RequestMapping("/getSuppilerList")
    public @ResponseBody
    TableModels getSuppilerList() {
        List<Jxcsuppiler> jxcsuppilers = jxcsuppilerMapper.selectList(new EntityWrapper<>());
        return TableModels.success(jxcsuppilers);
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Jxcsuppiler jxcsuppiler = jxcsuppilerMapper.selectById(id);
        return TableModels.success(jxcsuppiler);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Jxcsuppiler jxcsuppiler) {
        jxcsuppilerMapper.updateById(jxcsuppiler);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        jxcsuppilerMapper.deleteById(id);
        return TableModels.success();
    }

}
