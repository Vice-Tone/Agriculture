package com.ruoyi.project.agricultrue.sev.services;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sev.mapper.SevconsulMapper;
import com.ruoyi.project.agricultrue.sev.pojo.Sevconsul;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/service/sevconsul")
@Api(value = "/service/sevconsul", description = "咨询或技术管理")
public class H5SevconsulController {


    @Autowired
    private SevconsulMapper sevconsulMapper;

    //列表
    @ApiOperation(value = "根据typeId获取咨询或者技术列表", httpMethod = "GET", notes = "根据typeId获取咨询或者技术列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "typeId", value = "类别id,1是咨询，2是技术")})
    @RequestMapping("/list")
    public 
    TableModels list(@RequestParam("typeId") int typeId) {
        List<Sevconsul> datas = sevconsulMapper.selectByTypeId(typeId);
        Collections.shuffle(datas);
        List<Sevconsul> sevconsuls = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            sevconsuls.add(datas.get(i));
        }
        return TableModels.success(sevconsuls);
    }

    //详情
    @ApiOperation(value = "根据id获取咨询或者技术记录", httpMethod = "GET", notes = "根据id获取咨询或者技术记录")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "咨询或技术id")})
    @RequestMapping("/detail")
    public TableModels detail(@RequestParam("id") int id) {
        Sevconsul sevconsul = sevconsulMapper.selectById(id);
        return TableModels.success(sevconsul);
    }

}
