package com.ruoyi.project.agricultrue.jxc.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.DateUtils2;
import com.ruoyi.project.agricultrue.jxc.mapper.JxcmerchantMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcmerchant;
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
@RequestMapping("/jxcmerchant")
public class JxcmerchantController {

    private String prefix = "agricultrue/jxc/jxcmerchant";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private JxcmerchantMapper jxcmerchantMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcmerchant> datas = jxcmerchantMapper.list(pageIndex, pageSize);
        int count = jxcmerchantMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcmerchant> datas = jxcmerchantMapper.conditionlSel(pageIndex, pageSize, value);
        int count = jxcmerchantMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Jxcmerchant jxcmerchant) {
        long datemills = 0;
        try {
            datemills = DateUtils2.getLongByStr(jxcmerchant.getReceiptsdate(), "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jxcmerchant.setReceiptslongdate(datemills);
        jxcmerchantMapper.insert(jxcmerchant);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Jxcmerchant jxcmerchant = jxcmerchantMapper.selectById(id);
        return TableModels.success(jxcmerchant);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Jxcmerchant jxcmerchant) {
        jxcmerchantMapper.updateById(jxcmerchant);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        jxcmerchantMapper.deleteById(id);
        return TableModels.success();
    }

}
