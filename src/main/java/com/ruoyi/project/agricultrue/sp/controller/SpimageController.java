package com.ruoyi.project.agricultrue.sp.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sp.mapper.SpimageMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Spimage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping("/spimage")
public class SpimageController {

    private String prefix = "agricultrue/sp/spimage";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private SpimageMapper spimageMapper;

    //列表
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Spimage> datas = spimageMapper.list(pageIndex, pageSize);
        int count = spimageMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

@RequestMapping("/conditionlSel")
    public @ResponseBody
    TableModels conditionlSel(@RequestParam("pageIndex") int pageIndex
            , @RequestParam("pageSize") int pageSize,@RequestParam(name = "value", required = false, defaultValue = "") String value) {
         pageIndex = (pageIndex - 1) * pageSize;
        List<Spimage> datas = spimageMapper.conditionlSel(pageIndex, pageSize, value);
        int count = spimageMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }
    //添加
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(Spimage spimage) {
        spimageMapper.insert(spimage);
        return TableModels.success();
    }

    //详情
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Spimage spimage = spimageMapper.selectById(id);
        return TableModels.success(spimage);
    }

    //编辑
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Spimage spimage) {
        spimageMapper.updateById(spimage);
        return TableModels.success();
    }

    //删除
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        spimageMapper.deleteById(id);
        return TableModels.success();
    }

}
