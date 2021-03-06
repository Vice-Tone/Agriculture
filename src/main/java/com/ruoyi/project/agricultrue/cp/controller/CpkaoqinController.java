package com.ruoyi.project.agricultrue.cp.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.cp.mapper.CpkaoqinMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpkaoqin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cpkaoqin")
public class CpkaoqinController {

    private String prefix = "agricultrue/cp/cpkaoqin";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private CpkaoqinMapper cpkaoqinMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Cpkaoqin> datas = cpkaoqinMapper.list(pageIndex, pageSize);
        int count = cpkaoqinMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Cpkaoqin> datas = cpkaoqinMapper.conditionlSel(pageIndex, pageSize, value);
        int count = cpkaoqinMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Cpkaoqin cpkaoqin) {
        cpkaoqinMapper.insert(cpkaoqin);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Cpkaoqin cpkaoqin = cpkaoqinMapper.selectById(id);
        return TableModels.success(cpkaoqin);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Cpkaoqin cpkaoqin) {
        cpkaoqinMapper.updateById(cpkaoqin);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        cpkaoqinMapper.deleteById(id);
        return TableModels.success();
    }

}
