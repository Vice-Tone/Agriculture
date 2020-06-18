package com.ruoyi.project.agricultrue.cp.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.cp.mapper.CpcustomerMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpcustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cpcustomer")
public class CpcustomerController {

    private String prefix = "agricultrue/cp/cpcustomer";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private CpcustomerMapper cpcustomerMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Cpcustomer> datas = cpcustomerMapper.list(pageIndex, pageSize);
        int count = cpcustomerMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Cpcustomer> datas = cpcustomerMapper.conditionlSel(pageIndex, pageSize, value);
        int count = cpcustomerMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Cpcustomer cpcustomer) {
        cpcustomerMapper.insert(cpcustomer);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Cpcustomer cpcustomer = cpcustomerMapper.selectById(id);
        return TableModels.success(cpcustomer);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Cpcustomer cpcustomer) {
        cpcustomerMapper.updateById(cpcustomer);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        cpcustomerMapper.deleteById(id);
        return TableModels.success();
    }

}
