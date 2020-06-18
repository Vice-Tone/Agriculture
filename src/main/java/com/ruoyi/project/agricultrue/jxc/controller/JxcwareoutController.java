package com.ruoyi.project.agricultrue.jxc.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.DateUtils2;
import com.ruoyi.project.agricultrue.jxc.mapper.JxcwareoutMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcwareout;
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
@RequestMapping("/jxcwareout")
public class JxcwareoutController {

    private String prefix = "agricultrue/jxc/jxcwareout";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private JxcwareoutMapper jxcwareoutMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcwareout> datas = jxcwareoutMapper.list(pageIndex, pageSize);
        int count = jxcwareoutMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcwareout> datas = jxcwareoutMapper.conditionlSel(pageIndex, pageSize, value);
        int count = jxcwareoutMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Jxcwareout jxcwareout) {
        long datemills = 0;
        try {
            datemills = DateUtils2.getLongByStr(jxcwareout.getReceiptsdate(), "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jxcwareout.setReceiptslongdate(datemills);
        jxcwareoutMapper.insert(jxcwareout);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Jxcwareout jxcwareout = jxcwareoutMapper.selectById(id);
        return TableModels.success(jxcwareout);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Jxcwareout jxcwareout) {
        jxcwareoutMapper.updateById(jxcwareout);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        jxcwareoutMapper.deleteById(id);
        return TableModels.success();
    }

}
