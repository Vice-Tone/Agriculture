package com.ruoyi.project.agricultrue.sev.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sev.mapper.SevquestionMapper;
import com.ruoyi.project.agricultrue.sev.pojo.Sevquestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sevquestion")
public class SevquestionController {

    private String prefix = "agricultrue/sev/sevquestion";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private SevquestionMapper sevquestionMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Sevquestion> datas = sevquestionMapper.list(pageIndex, pageSize);
        int count = sevquestionMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

    @RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Sevquestion> datas = sevquestionMapper.conditionlSel(pageIndex, pageSize, value);
        int count = sevquestionMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }

    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Sevquestion sevquestion) {
        sevquestionMapper.insert(sevquestion);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Sevquestion sevquestion = sevquestionMapper.selectById(id);
        return TableModels.success(sevquestion);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Sevquestion sevquestion) {
        sevquestionMapper.updateById(sevquestion);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        sevquestionMapper.deleteById(id);
        return TableModels.success();
    }

}
