package com.ruoyi.project.agricultrue.jxc.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.DateUtils2;
import com.ruoyi.project.agricultrue.jxc.mapper.JxcsaleorderMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcsaleorder;
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
@RequestMapping("/jxcsaleorder")
public class JxcsaleorderController {

    private String prefix = "agricultrue/jxc/jxcsaleorder";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private JxcsaleorderMapper jxcsaleorderMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcsaleorder> datas = jxcsaleorderMapper.list(pageIndex, pageSize);
        int count = jxcsaleorderMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcsaleorder> datas = jxcsaleorderMapper.conditionlSel(pageIndex, pageSize, value);
        int count = jxcsaleorderMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Jxcsaleorder jxcsaleorder) {
        long datemills = 0;
        try {
            datemills = DateUtils2.getLongByStr(jxcsaleorder.getReceiptsdate(), "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jxcsaleorder.setReceiptslongdate(datemills);
        jxcsaleorderMapper.insert(jxcsaleorder);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Jxcsaleorder jxcsaleorder = jxcsaleorderMapper.selectById(id);
        return TableModels.success(jxcsaleorder);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Jxcsaleorder jxcsaleorder) {
        jxcsaleorderMapper.updateById(jxcsaleorder);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        jxcsaleorderMapper.deleteById(id);
        return TableModels.success();
    }

}
