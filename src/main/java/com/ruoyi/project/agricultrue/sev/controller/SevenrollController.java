package com.ruoyi.project.agricultrue.sev.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sev.mapper.SevenrollMapper;
import com.ruoyi.project.agricultrue.sev.pojo.Sevenroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/sevenroll")
public class SevenrollController {

    private String prefix = "agricultrue/sev/sevenroll";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private SevenrollMapper sevenrollMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Sevenroll> datas = sevenrollMapper.list(pageIndex, pageSize);
        int count = sevenrollMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Sevenroll> datas = sevenrollMapper.conditionlSel(pageIndex, pageSize, value);
        int count = sevenrollMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Sevenroll sevenroll) {
        sevenrollMapper.insert(sevenroll);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Sevenroll sevenroll = sevenrollMapper.selectById(id);
        return TableModels.success(sevenroll);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Sevenroll sevenroll) {
        sevenrollMapper.updateById(sevenroll);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        sevenrollMapper.deleteById(id);
        return TableModels.success();
    }

}
