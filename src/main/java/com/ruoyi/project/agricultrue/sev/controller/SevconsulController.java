package com.ruoyi.project.agricultrue.sev.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sev.mapper.SevconsulMapper;
import com.ruoyi.project.agricultrue.sev.pojo.Sevconsul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/sevconsul")
public class SevconsulController {

    private String prefix = "agricultrue/sev/sevconsul";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private SevconsulMapper sevconsulMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Sevconsul> datas = sevconsulMapper.list(pageIndex, pageSize);
        int count = sevconsulMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Sevconsul> datas = sevconsulMapper.conditionlSel(pageIndex, pageSize, value);
        int count = sevconsulMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Sevconsul sevconsul) {
        sevconsulMapper.insert(sevconsul);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Sevconsul sevconsul = sevconsulMapper.selectById(id);
        return TableModels.success(sevconsul);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Sevconsul sevconsul) {
        sevconsulMapper.updateById(sevconsul);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        sevconsulMapper.deleteById(id);
        return TableModels.success();
    }

}
