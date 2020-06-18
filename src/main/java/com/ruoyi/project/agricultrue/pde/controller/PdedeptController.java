package com.ruoyi.project.agricultrue.pde.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.pde.mapper.PdedeptMapper;
import com.ruoyi.project.agricultrue.pde.pojo.Pdedept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/pdedept")
public class PdedeptController {

    private String prefix = "agricultrue/pde/pdedept";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private PdedeptMapper pdedeptMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Pdedept> datas = pdedeptMapper.list(pageIndex, pageSize);
        int count = pdedeptMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Pdedept> datas = pdedeptMapper.conditionlSel(pageIndex, pageSize, value);
        int count = pdedeptMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Pdedept pdedept) {
        pdedeptMapper.insert(pdedept);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Pdedept pdedept = pdedeptMapper.selectById(id);
        return TableModels.success(pdedept);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Pdedept pdedept) {
        pdedeptMapper.updateById(pdedept);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        pdedeptMapper.deleteById(id);
        return TableModels.success();
    }

}
