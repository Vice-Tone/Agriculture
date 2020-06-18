package com.ruoyi.project.agricultrue.jxc.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.DateUtils2;
import com.ruoyi.project.agricultrue.jxc.mapper.JxcwareinfoMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcwareinfo;
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
@RequestMapping("/jxcwareinfo")
public class JxcwareinfoController {

    private String prefix = "agricultrue/jxc/jxcwareinfo";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private JxcwareinfoMapper jxcwareinfoMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcwareinfo> datas = jxcwareinfoMapper.list(pageIndex, pageSize);
        int count = jxcwareinfoMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcwareinfo> datas = jxcwareinfoMapper.conditionlSel(pageIndex, pageSize, value);
        int count = jxcwareinfoMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Jxcwareinfo jxcwareinfo) {
        jxcwareinfoMapper.insert(jxcwareinfo);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Jxcwareinfo jxcwareinfo = jxcwareinfoMapper.selectById(id);
        return TableModels.success(jxcwareinfo);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Jxcwareinfo jxcwareinfo) {
        jxcwareinfoMapper.updateById(jxcwareinfo);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        jxcwareinfoMapper.deleteById(id);
        return TableModels.success();
    }

}
