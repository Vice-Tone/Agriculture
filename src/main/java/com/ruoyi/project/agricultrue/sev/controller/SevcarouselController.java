package com.ruoyi.project.agricultrue.sev.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sev.mapper.SevcarouselMapper;
import com.ruoyi.project.agricultrue.sev.pojo.Sevcarousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sevcarousel")
public class SevcarouselController {

    private String prefix = "agricultrue/sev/sevcarousel";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private SevcarouselMapper sevcarouselMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Sevcarousel> datas = sevcarouselMapper.list(pageIndex, pageSize);
        int count = sevcarouselMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Sevcarousel> datas = sevcarouselMapper.conditionlSel(pageIndex, pageSize, value);
        int count = sevcarouselMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Sevcarousel sevcarousel) {
        sevcarouselMapper.insert(sevcarousel);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Sevcarousel sevcarousel = sevcarouselMapper.selectById(id);
        return TableModels.success(sevcarousel);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Sevcarousel sevcarousel) {
        sevcarouselMapper.updateById(sevcarousel);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        sevcarouselMapper.deleteById(id);
        return TableModels.success();
    }

}
