package com.ruoyi.project.agricultrue.sp.shop;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sp.mapper.SptypeMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Sptype;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop/sptype")
@Api(value = "/shop/sptype", description = "农机类别*")
public class H5SptypeController {


    @Autowired
    private SptypeMapper sptypeMapper;

    @ApiOperation(value = "获取农机类别列表", httpMethod = "GET", notes = "获取农机类别列表")
    @RequestMapping("/list")
    public TableModels list() {
        List<Sptype> sptypes = sptypeMapper.selectList(new EntityWrapper<>());
        return TableModels.success(sptypes);
    }


}
