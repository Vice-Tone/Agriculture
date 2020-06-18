package com.ruoyi.project.agricultrue.sev.services;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sev.mapper.SevactivityMapper;
import com.ruoyi.project.agricultrue.sev.mapper.SevcarouselMapper;
import com.ruoyi.project.agricultrue.sev.pojo.Sevactivity;
import com.ruoyi.project.agricultrue.sev.pojo.Sevcarousel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/service/sevactivity")
@Api(value = "/service/sevactivity", description = "活动列表")
public class H5SevactivityController {


    @Autowired
    private SevactivityMapper sevactivityMapper;

    //列表
    @ApiOperation(value = "获取活动列表", httpMethod = "GET", notes = "获取活动列表")
    @RequestMapping("/list")
    public TableModels list() {
        List<Sevactivity> datas = sevactivityMapper.selectList(new EntityWrapper<>());
        Collections.shuffle(datas);
        List<Sevactivity> sevactivityList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            sevactivityList.add(datas.get(i));
        }
        return TableModels.success(sevactivityList);
    }


    //详情
    @ApiOperation(value = "活动详情", httpMethod = "GET", notes = "活动详情")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "活动id")})
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Sevactivity sevactivity = sevactivityMapper.selectById(id);
        return TableModels.success(sevactivity);
    }


    @Autowired
    private SevcarouselMapper sevcarouselMapper;

    //获取所有轮播图
    @RequestMapping("/getAllCoursel")
    public @ResponseBody
    TableModels getAllCoursel() {
        List<Sevcarousel> sevcarouselList=sevcarouselMapper.selectList(new EntityWrapper<>());
        return TableModels.success(sevcarouselList);
    }


}
