package com.ruoyi.project.agricultrue.jxc.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.DateUtils2;
import com.ruoyi.project.agricultrue.jxc.mapper.JxcassetoutMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcassetout;
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
@RequestMapping("/jxcassetout")
public class JxcassetoutController {

    private String prefix = "agricultrue/jxc/jxcassetout";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private JxcassetoutMapper jxcassetoutMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcassetout> datas = jxcassetoutMapper.list(pageIndex, pageSize);
        int count = jxcassetoutMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcassetout> datas = jxcassetoutMapper.conditionlSel(pageIndex, pageSize, value);
        int count = jxcassetoutMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Jxcassetout jxcassetout) {

        long datemills = 0;
        try {
            datemills = DateUtils2.getLongByStr(jxcassetout.getReceiptsdate(), "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jxcassetout.setReceiptslongdate(datemills);
        jxcassetoutMapper.insert(jxcassetout);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Jxcassetout jxcassetout = jxcassetoutMapper.selectById(id);
        return TableModels.success(jxcassetout);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Jxcassetout jxcassetout) {
        jxcassetoutMapper.updateById(jxcassetout);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        jxcassetoutMapper.deleteById(id);
        return TableModels.success();
    }

}
