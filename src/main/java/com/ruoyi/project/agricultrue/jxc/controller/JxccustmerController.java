package com.ruoyi.project.agricultrue.jxc.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.DateUtils2;
import com.ruoyi.project.agricultrue.jxc.mapper.JxccustmerMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxccustmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/jxccustmer")
public class JxccustmerController {

    private String prefix = "agricultrue/jxc/jxccustmer";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private JxccustmerMapper jxccustmerMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Jxccustmer> datas = jxccustmerMapper.list(pageIndex, pageSize);
        int count = jxccustmerMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Jxccustmer> datas = jxccustmerMapper.conditionlSel(pageIndex, pageSize, value);
        int count = jxccustmerMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Jxccustmer jxccustmer) {

        jxccustmerMapper.insert(jxccustmer);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Jxccustmer jxccustmer = jxccustmerMapper.selectById(id);
        return TableModels.success(jxccustmer);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Jxccustmer jxccustmer) {
        jxccustmerMapper.updateById(jxccustmer);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        jxccustmerMapper.deleteById(id);
        return TableModels.success();
    }

}
