package com.ruoyi.project.agricultrue.sp.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sp.mapper.SpusersMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Spusers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/spusers")
public class SpusersController {

    private String prefix = "agricultrue/sp/spusers";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private SpusersMapper spusersMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Spusers> datas = spusersMapper.list(pageIndex, pageSize);
        int count = spusersMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

    @RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Spusers> datas = spusersMapper.conditionlSel(pageIndex, pageSize, value);
        int count = spusersMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }

    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Spusers spusers) {
        spusersMapper.insert(spusers);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Spusers spusers = spusersMapper.selectById(id);
        return TableModels.success(spusers);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Spusers spusers) {
        spusersMapper.updateById(spusers);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        spusersMapper.deleteById(id);
        return TableModels.success();
    }

}
