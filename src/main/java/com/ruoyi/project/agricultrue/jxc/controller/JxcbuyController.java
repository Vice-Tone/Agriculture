package com.ruoyi.project.agricultrue.jxc.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.DateUtils2;
import com.ruoyi.project.agricultrue.jxc.mapper.JxcbuyMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcbuy;
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
@RequestMapping("/jxcbuy")
public class JxcbuyController {

    private String prefix = "agricultrue/jxc/jxcbuy";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private JxcbuyMapper jxcbuyMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcbuy> datas = jxcbuyMapper.list(pageIndex, pageSize);
        int count = jxcbuyMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcbuy> datas = jxcbuyMapper.conditionlSel(pageIndex, pageSize, value);
        int count = jxcbuyMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Jxcbuy jxcbuy) {
        long datemills = 0;
        try {
            datemills = DateUtils2.getLongByStr(jxcbuy.getReceiptsdate(), "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jxcbuy.setReceiptslongdate(datemills);
        jxcbuyMapper.insert(jxcbuy);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Jxcbuy jxcbuy = jxcbuyMapper.selectById(id);
        return TableModels.success(jxcbuy);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Jxcbuy jxcbuy) {
        jxcbuyMapper.updateById(jxcbuy);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        jxcbuyMapper.deleteById(id);
        return TableModels.success();
    }

}
