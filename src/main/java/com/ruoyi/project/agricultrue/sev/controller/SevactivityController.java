package com.ruoyi.project.agricultrue.sev.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sev.mapper.SevactivityMapper;
import com.ruoyi.project.agricultrue.sev.pojo.Sevactivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/sevactivity")
public class SevactivityController {

    private String prefix = "agricultrue/sev/sevactivity";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private SevactivityMapper sevactivityMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Sevactivity> datas = sevactivityMapper.list(pageIndex, pageSize);
        int count = sevactivityMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

    @RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Sevactivity> datas = sevactivityMapper.conditionlSel(pageIndex, pageSize, value);
        int count = sevactivityMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }

    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Sevactivity sevactivity) {
        sevactivityMapper.insert(sevactivity);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Sevactivity sevactivity = sevactivityMapper.selectById(id);
        return TableModels.success(sevactivity);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Sevactivity sevactivity) {
        sevactivityMapper.updateById(sevactivity);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        sevactivityMapper.deleteById(id);
        return TableModels.success();
    }

}
