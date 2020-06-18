package com.ruoyi.project.agricultrue.pde.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.DateUtils2;
import com.ruoyi.project.agricultrue.pde.mapper.PdeassessMapper;
import com.ruoyi.project.agricultrue.pde.pojo.Pdeassess;
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
@RequestMapping("/pdeassess")
public class PdeassessController {

    private String prefix = "agricultrue/pde/pdeassess";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private PdeassessMapper pdeassessMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Pdeassess> datas = pdeassessMapper.list(pageIndex, pageSize);
        int count = pdeassessMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

    @RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Pdeassess> datas = pdeassessMapper.conditionlSel(pageIndex, pageSize, value);
        int count = pdeassessMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }

    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Pdeassess pdeassess) {
        long datemills = 0;
        try {
            datemills = DateUtils2.getLongByStr(pdeassess.getAssessTime(), "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        pdeassess.setAssessLongTime(datemills + "");
        pdeassessMapper.insert(pdeassess);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Pdeassess pdeassess = pdeassessMapper.selectById(id);
        return TableModels.success(pdeassess);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Pdeassess pdeassess) {
        pdeassessMapper.updateById(pdeassess);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        pdeassessMapper.deleteById(id);
        return TableModels.success();
    }

}
