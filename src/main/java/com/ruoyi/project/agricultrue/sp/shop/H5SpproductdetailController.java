package com.ruoyi.project.agricultrue.sp.shop;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sp.mapper.SpproductdetailMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Spproductdetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop/spproductdetail")
@Api(value = "/shop/spproductdetail", description = "关于农机详情*")
public class H5SpproductdetailController {

    @Autowired
    private SpproductdetailMapper spproductdetailMapper;

    @ApiOperation(value = "农机详情", httpMethod = "GET", notes = "农机详情")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "农机id")})
    @RequestMapping("/detail")
    public TableModels detail(@RequestParam("id") int id) {
        Spproductdetail spproductdetail = spproductdetailMapper.selectByLinkId(id);
        return TableModels.success(spproductdetail);
    }


}
