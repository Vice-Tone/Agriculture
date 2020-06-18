package com.ruoyi.project.agricultrue.sp.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sp.mapper.SpproductdetailMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Spproductdetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/spproductdetail")
public class SpproductdetailController {

    private String prefix = "agricultrue/sp/spproductdetail";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private SpproductdetailMapper spproductdetailMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Spproductdetail> datas = spproductdetailMapper.list(pageIndex, pageSize);
        int count = spproductdetailMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Spproductdetail> datas = spproductdetailMapper.conditionlSel(pageIndex, pageSize, value);
        int count = spproductdetailMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Spproductdetail spproductdetail) {
        spproductdetailMapper.insert(spproductdetail);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Spproductdetail spproductdetail = spproductdetailMapper.selectById(id);
        return TableModels.success(spproductdetail);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Spproductdetail spproductdetail) {
        spproductdetailMapper.updateById(spproductdetail);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        spproductdetailMapper.deleteById(id);
        return TableModels.success();
    }

}
