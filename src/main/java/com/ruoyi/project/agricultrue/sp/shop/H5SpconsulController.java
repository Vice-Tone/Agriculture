package com.ruoyi.project.agricultrue.sp.shop;

import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sev.pojo.Sevconsul;
import com.ruoyi.project.agricultrue.sp.mapper.SpconsulMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Spconsul;
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
@RequestMapping("/shop/spconsul")
@Api(value = "/shop/spconsul", description = "获取农机咨询或技术列表*")
public class H5SpconsulController {


    @Autowired
    private SpconsulMapper spconsulMapper;

    //列表
    @ApiOperation(value = "咨询或技术类博客", httpMethod = "GET", notes = "咨询或技术类博客")
    @ApiImplicitParams({@ApiImplicitParam(name = "typeId", value = "类别id，1是咨询，2是技术")})
    @RequestMapping("/list")
    public TableModels list(@RequestParam("typeId") int typeId) {
        List<Spconsul> datas = spconsulMapper.selectByTypeId(typeId);
        Collections.shuffle(datas);
        List<Spconsul> spconsulList = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            spconsulList.add(datas.get(i));
        return TableModels.success(spconsulList);
    }

    //详情
    @ApiOperation(value = "根据id获取咨询或者技术记录", httpMethod = "GET", notes = "根据id获取咨询或者技术记录")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "咨询或技术id")})
    @RequestMapping("/detail")
    public TableModels detail(@RequestParam("id") int id) {
        Spconsul spconsul = spconsulMapper.selectById(id);
        return TableModels.success(spconsul);
    }




}
