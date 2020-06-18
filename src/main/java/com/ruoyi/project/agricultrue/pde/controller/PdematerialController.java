package com.ruoyi.project.agricultrue.pde.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.DateUtils2;
import com.ruoyi.project.agricultrue.pde.mapper.PdematerialMapper;
import com.ruoyi.project.agricultrue.pde.pojo.Pdematerial;
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
@RequestMapping("/pdematerial")
public class PdematerialController {

    private String prefix = "agricultrue/pde/pdematerial";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private PdematerialMapper pdematerialMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Pdematerial> datas = pdematerialMapper.list(pageIndex, pageSize);
        int count = pdematerialMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Pdematerial> datas = pdematerialMapper.conditionlSel(pageIndex, pageSize, value);
        int count = pdematerialMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Pdematerial pdematerial) {
        long datemills = 0;
        try {
            datemills = DateUtils2.getLongByStr(pdematerial.getSaveTime(), "yyyy-MM-dd");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        pdematerial.setSaveLongTime(datemills+"");
        pdematerialMapper.insert(pdematerial);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Pdematerial pdematerial = pdematerialMapper.selectById(id);
        return TableModels.success(pdematerial);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Pdematerial pdematerial) {
        pdematerialMapper.updateById(pdematerial);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        pdematerialMapper.deleteById(id);
        return TableModels.success();
    }

}
