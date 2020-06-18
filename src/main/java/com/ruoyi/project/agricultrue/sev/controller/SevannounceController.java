package com.ruoyi.project.agricultrue.sev.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sev.mapper.SevannounceMapper;
import com.ruoyi.project.agricultrue.sev.pojo.Sevannounce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/sevannounce")
public class SevannounceController {

    private String prefix = "agricultrue/sev/sevannounce";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private SevannounceMapper sevannounceMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Sevannounce> datas = sevannounceMapper.list(pageIndex, pageSize);
        int count = sevannounceMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Sevannounce> datas = sevannounceMapper.conditionlSel(pageIndex, pageSize, value);
        int count = sevannounceMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Sevannounce sevannounce) {
        sevannounceMapper.insert(sevannounce);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Sevannounce sevannounce = sevannounceMapper.selectById(id);
        return TableModels.success(sevannounce);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Sevannounce sevannounce) {
        sevannounceMapper.updateById(sevannounce);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        sevannounceMapper.deleteById(id);
        return TableModels.success();
    }

}
