package com.ruoyi.project.agricultrue.sp.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sp.mapper.SpconsulMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Spconsul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/spconsul")
public class SpconsulController {

    private String prefix = "agricultrue/sp/spconsul";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @GetMapping("/tech")
    public String configtech() {
        return "agricultrue/sp/sptech";
    }


    @Autowired
    private SpconsulMapper spconsulMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam("typeId") int typeId) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Spconsul> datas = spconsulMapper.list(pageIndex, pageSize,typeId);
        int count = spconsulMapper.selectCountByTypeId(typeId);
        return TableModels.success(count, datas);
    }

    @RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,
                              @RequestParam(name = "value", required = false, defaultValue = "") String value, @RequestParam("typeId") int typeId) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Spconsul> datas = spconsulMapper.conditionlSel(pageIndex, pageSize, value,typeId);
        int count = spconsulMapper.conditionlSelCount(value,typeId);
        return TableModels.success(count, datas);
    }

    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Spconsul spconsul) {
        spconsulMapper.insert(spconsul);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Spconsul spconsul = spconsulMapper.selectById(id);
        return TableModels.success(spconsul);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Spconsul spconsul) {
        spconsulMapper.updateById(spconsul);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        spconsulMapper.deleteById(id);
        return TableModels.success();
    }

}
