package com.ruoyi.project.agricultrue.jxc.controller;

import com.ruoyi.common.TableModels;
import com.ruoyi.common.utils.DateUtils2;
import com.ruoyi.project.agricultrue.jxc.mapper.JxcwareinMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcwarein;
import org.apache.commons.lang.time.DateUtils;
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
@RequestMapping("/jxcchart")
public class JxcChartController {

    private String prefix = "agricultrue/jxc/calculate";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private JxcwareinMapper jxcwareinMapper;

    //统计图
    @RequestMapping("/getChart")
    public @ResponseBody
    TableModels getChart(@RequestParam("startTime") String startTime,
                         @RequestParam("endTime") String endTime) {
        List<Jxcwarein> sales = null;

        try {

            long datemillsStart = 0;
            long datemillsEnd = 0;
            datemillsStart = DateUtils2.getLongByStr(startTime, "yyyy-MM-dd");
            datemillsEnd = DateUtils2.getLongByStr(endTime, "yyyy-MM-dd");

            sales = jxcwareinMapper.getList(datemillsStart, datemillsEnd);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        //名称
        String[] names = new String[sales.size()];
        //次数
        Integer[] times = new Integer[sales.size()];
        for (int i = 0; i < sales.size(); i++) {
            Jxcwarein tocansales = sales.get(i);
            names[i] = tocansales.getGoodInfo();
            times[i] = tocansales.getNum();
        }
        Map<String, Object> map = new HashMap<>();
        map.put("names", names);
        map.put("times", times);
        return TableModels.success(map);
    }

    public static void main(String[] args) {
        try {
            long mills1=DateUtils2.getLongByStr("2020-05-29", "yyyy-MM-dd");
            long mills2=DateUtils2.getLongByStr("2020-05-27", "yyyy-MM-dd");
            System.out.println(mills1);
            System.out.println(mills2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //查询是否有小于10的物品
    @RequestMapping("/getNum")
    public @ResponseBody
    TableModels getNum() {
        List<String> goodNames = jxcwareinMapper.selectByNum(10);
        StringBuilder builder = new StringBuilder();
        builder.append("以下商品库存不足哦，[");
        for (int k = 0; k < goodNames.size(); k++) {
            if (k == goodNames.size() - 1) {
                builder.append(goodNames.get(k)).append("]");
            } else {
                builder.append(goodNames.get(k)).append(",");
            }
        }
        if (goodNames.size() == 0) return TableModels.failure();

        return TableModels.success(builder.toString());
    }
}
