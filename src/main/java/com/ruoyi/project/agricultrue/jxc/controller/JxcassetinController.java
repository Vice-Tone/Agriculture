package com.ruoyi.project.agricultrue.jxc.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.DateUtils2;
import com.ruoyi.project.agricultrue.jxc.mapper.JxcassetinMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcassetin;
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
@RequestMapping("/jxcassetin")
public class JxcassetinController {

    private String prefix = "agricultrue/jxc/jxcassetin";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private JxcassetinMapper jxcassetinMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcassetin> datas = jxcassetinMapper.list(pageIndex, pageSize);
        int count = jxcassetinMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcassetin> datas = jxcassetinMapper.conditionlSel(pageIndex, pageSize, value);
        int count = jxcassetinMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Jxcassetin jxcassetin) {
        long datemills = 0;
        try {
            datemills = DateUtils2.getLongByStr(jxcassetin.getReceiptsdate(), "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jxcassetin.setPayStatus("未结算");
        jxcassetin.setReceiptslongdate(datemills);
        jxcassetinMapper.insert(jxcassetin);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Jxcassetin jxcassetin = jxcassetinMapper.selectById(id);
        return TableModels.success(jxcassetin);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Jxcassetin jxcassetin) {
        jxcassetinMapper.updateById(jxcassetin);
        return TableModels.success();
    }

    //结算
    @RequestMapping("/checkinit")
    public @ResponseBody
    TableModels checkinit(@RequestParam("id") int id) {
        Jxcassetin jxcassetin=jxcassetinMapper.selectById(id);
        jxcassetin.setPayStatus("结算");
        jxcassetinMapper.updateById(jxcassetin);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        jxcassetinMapper.deleteById(id);
        return TableModels.success();
    }

}
