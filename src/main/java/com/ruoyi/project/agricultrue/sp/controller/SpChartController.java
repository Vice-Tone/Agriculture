package com.ruoyi.project.agricultrue.sp.controller;

import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.DateUtils2;
import com.ruoyi.project.agricultrue.jxc.mapper.JxcwareinMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcwarein;
import com.ruoyi.project.agricultrue.sp.mapper.SpordersMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Sporders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/spchart")
public class SpChartController {

    private String prefix = "agricultrue/sp/calculate";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private SpordersMapper spordersMapper;

    //统计图
    @RequestMapping("/getChart")
    public @ResponseBody
    TableModels getChart() {

        List<Map<String, Object>> sales = null;
        sales = spordersMapper.getList();
        //名称
        String[] names = new String[sales.size()];
        //次数
        Long[] times = new Long[sales.size()];
        for (int i = 0; i < sales.size(); i++) {
            Map<String, Object> tocansales = sales.get(i);
            names[i] = (String) tocansales.get("brand");
            times[i] = (Long) tocansales.get("num");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("names", names);
        map.put("times", times);
        return TableModels.success(map);
    }

}
