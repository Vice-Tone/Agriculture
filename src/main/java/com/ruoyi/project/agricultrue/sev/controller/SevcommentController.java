package com.ruoyi.project.agricultrue.sev.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sev.mapper.SevcommentMapper;
import com.ruoyi.project.agricultrue.sev.pojo.Sevcomment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/sevcomment")
public class SevcommentController {

    private String prefix = "agricultrue/sev/sevcomment";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private SevcommentMapper sevcommentMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Sevcomment> datas = sevcommentMapper.list(pageIndex, pageSize);
        int count = sevcommentMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Sevcomment> datas = sevcommentMapper.conditionlSel(pageIndex, pageSize, value);
        int count = sevcommentMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Sevcomment sevcomment) {
        sevcommentMapper.insert(sevcomment);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Sevcomment sevcomment = sevcommentMapper.selectById(id);
        return TableModels.success(sevcomment);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Sevcomment sevcomment) {
        sevcommentMapper.updateById(sevcomment);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        sevcommentMapper.deleteById(id);
        return TableModels.success();
    }

}
