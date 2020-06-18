package com.ruoyi.project.agricultrue.sp.shop;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sp.mapper.SpadvitisementMapper;
import com.ruoyi.project.agricultrue.sp.mapper.SpimageMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Spadvitisement;
import com.ruoyi.project.agricultrue.sp.pojo.Spimage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop/spimage")
@Api(value = "/shop/spimage", description = "获取农机图片列表*")
public class H5SpimageController {

    @Autowired
    private SpimageMapper spimageMapper;

    @ApiOperation(value = "农机图片列表", httpMethod = "GET", notes = "农机图片列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "农机id")})
    @RequestMapping("/getImages")
    public TableModels getImages(@RequestParam("id") int id) {
        List<Spimage> spimages = spimageMapper.selectByLinkId(id);
        return TableModels.success(spimages);
    }

    @Autowired
    private SpadvitisementMapper spadvitisementMapper;

    //添加
    @RequestMapping("/selectById")
    public @ResponseBody
    TableModels selectById(@RequestParam("id") int id) {
        Spadvitisement spadvitisement=spadvitisementMapper.selectById(id);
        return TableModels.success(spadvitisement);
    }

}
