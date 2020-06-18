package com.ruoyi.project.agricultrue.sp.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sp.mapper.SpadvitisementMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Spadvitisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/spadvitisement")
public class SpadvitisementController {

    private String prefix = "agricultrue/sp/spadvitisement";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private SpadvitisementMapper spadvitisementMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Spadvitisement> datas = spadvitisementMapper.list(pageIndex, pageSize);
        int count = spadvitisementMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Spadvitisement> datas = spadvitisementMapper.conditionlSel(pageIndex, pageSize, value);
        int count = spadvitisementMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }




    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Spadvitisement spadvitisement = spadvitisementMapper.selectById(id);
        return TableModels.success(spadvitisement);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Spadvitisement spadvitisement) {
        spadvitisementMapper.updateById(spadvitisement);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        spadvitisementMapper.deleteById(id);
        return TableModels.success();
    }

}
