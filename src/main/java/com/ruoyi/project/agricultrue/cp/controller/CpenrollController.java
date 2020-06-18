package com.ruoyi.project.agricultrue.cp.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.cp.mapper.CpenrollMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpenroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cpenroll")
public class CpenrollController {

    private String prefix = "agricultrue/cp/cpenroll";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private CpenrollMapper cpenrollMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam(value = "pageIndex", required = false, defaultValue = "1") int pageIndex
            , @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Cpenroll> datas = cpenrollMapper.list(pageIndex, pageSize);
        int count = cpenrollMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

    @RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Cpenroll> datas = cpenrollMapper.conditionlSel(pageIndex, pageSize, value);
        int count = cpenrollMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }

    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Cpenroll cpenroll) {
        cpenrollMapper.insert(cpenroll);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Cpenroll cpenroll = cpenrollMapper.selectById(id);
        return TableModels.success(cpenroll);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Cpenroll cpenroll) {
        cpenrollMapper.updateById(cpenroll);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        cpenrollMapper.deleteById(id);
        return TableModels.success();
    }

}
