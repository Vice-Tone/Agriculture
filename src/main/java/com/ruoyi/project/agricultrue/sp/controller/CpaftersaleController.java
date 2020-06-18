package com.ruoyi.project.agricultrue.sp.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sp.mapper.CpaftersaleMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Cpaftersales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/cpaftersale")
public class CpaftersaleController {

    private String prefix = "agricultrue/cpaftersales";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private CpaftersaleMapper cpaftersaleMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Cpaftersales> datas = cpaftersaleMapper.list(pageIndex, pageSize);
        int count = cpaftersaleMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Cpaftersales> datas = cpaftersaleMapper.conditionlSel(pageIndex, pageSize, value);
        int count = cpaftersaleMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Cpaftersales cpaftersales) {
        cpaftersaleMapper.insert(cpaftersales);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Cpaftersales cpaftersales = cpaftersaleMapper.selectById(id);
        return TableModels.success(cpaftersales);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Cpaftersales cpaftersales) {
        cpaftersaleMapper.updateById(cpaftersales);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        cpaftersaleMapper.deleteById(id);
        return TableModels.success();
    }

}
