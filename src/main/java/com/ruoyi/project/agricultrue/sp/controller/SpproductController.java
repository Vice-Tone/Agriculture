package com.ruoyi.project.agricultrue.sp.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sp.mapper.SpproductMapper;
import com.ruoyi.project.agricultrue.sp.mapper.SptypeMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Spproduct;
import com.ruoyi.project.agricultrue.sp.pojo.Sptype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/spproduct")
public class SpproductController {

    private String prefix = "agricultrue/sp/spproduct";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private SpproductMapper spproductMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Spproduct> datas = spproductMapper.list(pageIndex, pageSize);
        int count = spproductMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

    @RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Spproduct> datas = spproductMapper.conditionlSel(pageIndex, pageSize, value);
        int count = spproductMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }


    @Autowired
    private SptypeMapper sptypeMapper;

    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Spproduct spproduct) {
        int typeId = spproduct.getTypeId();
        Sptype sptype=sptypeMapper.selectById(typeId);
        spproduct.setTypeName(sptype.getTypeName());
        spproductMapper.insert(spproduct);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Spproduct spproduct = spproductMapper.selectById(id);
        return TableModels.success(spproduct);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Spproduct spproduct) {
        int typeId = spproduct.getTypeId();
        Sptype sptype=sptypeMapper.selectById(typeId);
        spproduct.setTypeName(sptype.getTypeName());
        spproductMapper.updateById(spproduct);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        spproductMapper.deleteById(id);
        return TableModels.success();
    }

}
