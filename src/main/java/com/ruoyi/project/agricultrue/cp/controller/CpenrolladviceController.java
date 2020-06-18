package com.ruoyi.project.agricultrue.cp.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.cp.mapper.CpenrolladviceMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpenrolladvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cpenrolladvice")
public class CpenrolladviceController {

    private String prefix = "agricultrue/cp/cpenrolladvice";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private CpenrolladviceMapper cpenrolladviceMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Cpenrolladvice> datas = cpenrolladviceMapper.list(pageIndex, pageSize);
        int count = cpenrolladviceMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Cpenrolladvice> datas = cpenrolladviceMapper.conditionlSel(pageIndex, pageSize, value);
        int count = cpenrolladviceMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Cpenrolladvice cpenrolladvice) {
        cpenrolladviceMapper.insert(cpenrolladvice);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Cpenrolladvice cpenrolladvice = cpenrolladviceMapper.selectById(id);
        return TableModels.success(cpenrolladvice);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Cpenrolladvice cpenrolladvice) {
        cpenrolladviceMapper.updateById(cpenrolladvice);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        cpenrolladviceMapper.deleteById(id);
        return TableModels.success();
    }

}
