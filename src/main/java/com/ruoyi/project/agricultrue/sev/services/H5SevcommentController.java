package com.ruoyi.project.agricultrue.sev.services;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sev.mapper.SevcommentMapper;
import com.ruoyi.project.agricultrue.sev.pojo.Sevcomment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service/sevcomment")
public class H5SevcommentController {

    private String prefix = "agricultrue/sev/sevcomment";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private SevcommentMapper sevcommentMapper;

    //列表
    @RequestMapping("/list")
    public TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Sevcomment> datas = sevcommentMapper.list(pageIndex, pageSize);
        int count = sevcommentMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }


    @RequestMapping("/conditionlSel")
    public TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Sevcomment> datas = sevcommentMapper.conditionlSel(pageIndex, pageSize, value);
        int count = sevcommentMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }

    //添加
    @RequestMapping("/add")
    public TableModels add(Sevcomment sevcomment) {
        sevcommentMapper.insert(sevcomment);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public TableModels detail(@RequestParam("id") int id) {
        Sevcomment sevcomment = sevcommentMapper.selectById(id);
        return TableModels.success(sevcomment);
    }

    //编辑
    @RequestMapping("/edit")
    public TableModels edit(Sevcomment sevcomment) {
        sevcommentMapper.updateById(sevcomment);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public TableModels delete(@RequestParam("id") int id) {
        sevcommentMapper.deleteById(id);
        return TableModels.success();
    }

}
