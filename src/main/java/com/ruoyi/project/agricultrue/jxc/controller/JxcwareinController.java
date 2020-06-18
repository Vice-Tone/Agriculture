package com.ruoyi.project.agricultrue.jxc.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.DateUtils2;
import com.ruoyi.project.agricultrue.jxc.mapper.JxcwareinMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcwarein;
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
@RequestMapping("/jxcwarein")
public class JxcwareinController {

    private String prefix = "agricultrue/jxc/jxcwarein";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private JxcwareinMapper jxcwareinMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcwarein> datas = jxcwareinMapper.list(pageIndex, pageSize);
        int count = jxcwareinMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcwarein> datas = jxcwareinMapper.conditionlSel(pageIndex, pageSize, value);
        int count = jxcwareinMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Jxcwarein jxcwarein) {
        long datemills = 0;
        try {
            datemills = DateUtils2.getLongByStr(jxcwarein.getReceiptsdate(), "yyyy-MM-dd");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        jxcwarein.setReceiptslongdate(datemills);
        jxcwareinMapper.insert(jxcwarein);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Jxcwarein jxcwarein = jxcwareinMapper.selectById(id);
        return TableModels.success(jxcwarein);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Jxcwarein jxcwarein) {
        jxcwareinMapper.updateById(jxcwarein);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        jxcwareinMapper.deleteById(id);
        return TableModels.success();
    }

}
