package com.ruoyi.project.agricultrue.sp.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sp.mapper.SptypeMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Sptype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/sptype")
public class SptypeController {

    private String prefix = "agricultrue/sp/sptype";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private SptypeMapper sptypeMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Sptype> datas = sptypeMapper.list(pageIndex, pageSize);
        int count = sptypeMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Sptype> datas = sptypeMapper.conditionlSel(pageIndex, pageSize, value);
        int count = sptypeMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Sptype sptype) {
        sptypeMapper.insert(sptype);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Sptype sptype = sptypeMapper.selectById(id);
        return TableModels.success(sptype);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Sptype sptype) {
        sptypeMapper.updateById(sptype);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        sptypeMapper.deleteById(id);
        return TableModels.success();
    }

}
