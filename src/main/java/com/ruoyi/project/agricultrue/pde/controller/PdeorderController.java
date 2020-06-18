package com.ruoyi.project.agricultrue.pde.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.pde.mapper.PdeorderMapper;
import com.ruoyi.project.agricultrue.pde.pojo.Pdeorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/pdeorder")
public class PdeorderController {

    private String prefix = "agricultrue/pde/pdeorder";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private PdeorderMapper pdeorderMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Pdeorder> datas = pdeorderMapper.list(pageIndex, pageSize);
        int count = pdeorderMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Pdeorder> datas = pdeorderMapper.conditionlSel(pageIndex, pageSize, value);
        int count = pdeorderMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Pdeorder pdeorder) {
        pdeorderMapper.insert(pdeorder);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Pdeorder pdeorder = pdeorderMapper.selectById(id);
        return TableModels.success(pdeorder);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Pdeorder pdeorder) {
        pdeorderMapper.updateById(pdeorder);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        pdeorderMapper.deleteById(id);
        return TableModels.success();
    }

}
