package com.ruoyi.project.agricultrue.jxc.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.jxc.mapper.JxcspecificationMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcspecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/jxcspecification")
public class JxcspecificationController {

    private String prefix = "agricultrue/jxc/jxcspecification";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private JxcspecificationMapper jxcspecificationMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcspecification> datas = jxcspecificationMapper.list(pageIndex, pageSize);
        int count = jxcspecificationMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Jxcspecification> datas = jxcspecificationMapper.conditionlSel(pageIndex, pageSize, value);
        int count = jxcspecificationMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Jxcspecification jxcspecification) {
        jxcspecificationMapper.insert(jxcspecification);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Jxcspecification jxcspecification = jxcspecificationMapper.selectById(id);
        return TableModels.success(jxcspecification);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Jxcspecification jxcspecification) {
        jxcspecificationMapper.updateById(jxcspecification);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        jxcspecificationMapper.deleteById(id);
        return TableModels.success();
    }

}
