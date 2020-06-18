package com.ruoyi.project.agricultrue.pde.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.pde.mapper.PdedutyMapper;
import com.ruoyi.project.agricultrue.pde.mapper.PdesubmissionMapper;
import com.ruoyi.project.agricultrue.pde.pojo.Pdeduty;
import com.ruoyi.project.agricultrue.pde.pojo.Pdesubmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.NumberFormat;
import java.util.List;

@Controller
@RequestMapping("/pdesubmission")
public class PdesubmissionController {

    private String prefix = "agricultrue/pde/pdesubmission";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private PdesubmissionMapper pdesubmissionMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Pdesubmission> datas = pdesubmissionMapper.list(pageIndex, pageSize);
        int count = pdesubmissionMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

    @RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize, @RequestParam(name = "value", required = false, defaultValue = "") String value) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Pdesubmission> datas = pdesubmissionMapper.conditionlSel(pageIndex, pageSize, value);
        int count = pdesubmissionMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }

    @Autowired
    private PdedutyMapper pdedutyMapper;

    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Pdesubmission pdesubmission) {
        pdesubmission.setStau("未完成");
        pdesubmissionMapper.insert(pdesubmission);
        //设置父级任务的进度
        int parentId = pdesubmission.getParentId();
        this.resetProcess(parentId);
        return TableModels.success();
    }

    private void resetProcess(int parentId) {
        Pdeduty pdeduty = pdedutyMapper.selectById(parentId);
        int totalCount = pdesubmissionMapper.selectAllParentId(parentId);
        int finishedCount = pdesubmissionMapper.selectFinishedParentId(parentId);
        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(0);
        String result = numberFormat.format((float) finishedCount / (float) totalCount * 100);//所占百分比
        int ret = Integer.valueOf(result);
        pdeduty.setProcess(ret);
        pdedutyMapper.updateById(pdeduty);
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Pdesubmission pdesubmission = pdesubmissionMapper.selectById(id);
        return TableModels.success(pdesubmission);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Pdesubmission pdesubmission) {
        pdesubmissionMapper.updateById(pdesubmission);
        //设置父级任务的进度
        int parentId = pdesubmission.getParentId();
        this.resetProcess(parentId);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        pdesubmissionMapper.deleteById(id);
        //设置父级任务的进度
        this.resetProcess(id);
        return TableModels.success();
    }

}
