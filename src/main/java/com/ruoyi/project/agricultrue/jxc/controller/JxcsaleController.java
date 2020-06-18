package com.ruoyi.project.agricultrue.jxc.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.DateUtils2;
import com.ruoyi.project.agricultrue.jxc.mapper.JxcsaleMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcsale;
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
@RequestMapping("/jxcsale")
public class JxcsaleController {

    private String prefix = "agricultrue/jxc/jxcsalein";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @GetMapping("/out")
    public String configOut() {
        return "agricultrue/jxc/jxcsaleout";
    }

    @Autowired
    private JxcsaleMapper jxcsaleMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,
                     @RequestParam("typeId") int typeId) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcsale> datas = jxcsaleMapper.list(pageIndex, pageSize,typeId);
        int count = jxcsaleMapper.selectCountTypeId(typeId);
        return TableModels.success(count, datas);
    }

    @RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,
                              @RequestParam("typeId") int typeId,
                              @RequestParam(name = "value", required = false, defaultValue = "") String value) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcsale> datas = jxcsaleMapper.conditionlSel(pageIndex, pageSize, value,typeId);
        int count = jxcsaleMapper.conditionlSelCount(value,typeId);
        return TableModels.success(count, datas);
    }

    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Jxcsale jxcsale) {
        long datemills = 0;
        try {
            datemills = DateUtils2.getLongByStr(jxcsale.getReceiptsdate(), "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jxcsale.setReceiptslongdate(datemills);
        jxcsaleMapper.insert(jxcsale);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Jxcsale jxcsale = jxcsaleMapper.selectById(id);
        return TableModels.success(jxcsale);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Jxcsale jxcsale) {
        jxcsaleMapper.updateById(jxcsale);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        jxcsaleMapper.deleteById(id);
        return TableModels.success();
    }

}
