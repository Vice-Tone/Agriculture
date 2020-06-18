package com.ruoyi.project.agricultrue.sp.shop;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sp.mapper.SpordersMapper;
import com.ruoyi.project.agricultrue.sp.mapper.SpproductMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Sporders;
import com.ruoyi.project.agricultrue.sp.pojo.Spproduct;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shop/sporders")
@Api(value = "/shop/sporders", description = "关于订单的操作*")
public class H5SpordersController {

    private String prefix = "agricultrue/sp/sporders";

    @GetMapping()
    public String config() {
        return prefix;
    }

    @Autowired
    private SpordersMapper spordersMapper;

    @Autowired
    private SpproductMapper spproductMapper;

    //列表
    @ApiOperation(value = "获取用户的订单列表", httpMethod = "GET", notes = "获取用户的订单列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名")})
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam("username") String username) {
        List<Sporders> datas = spordersMapper.listByUsername(username);
        return TableModels.success(datas);
    }


    //添加
    @ApiOperation(value = "下订单", httpMethod = "GET", notes = "下订单")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名"),
            @ApiImplicitParam(name = "id", value = "产品id")})
    @RequestMapping("/add")
    public @ResponseBody
    TableModels add(@RequestParam("username") String username,
                    @RequestParam("id") int id) {

        Sporders sporders = new Sporders();
        Spproduct spproduct = spproductMapper.selectById(id);
        if (spproduct.getNum() == 0) {
            return TableModels.failure("库存不足");
        }
        int leftNum = spproduct.getNum() - 1;
        spproduct.setNum(leftNum);
        sporders.setUserId(username);
        sporders.setStat("未结算");
        sporders.setOrderNum(UUID.randomUUID().toString());
        sporders.setPrice(spproduct.getPrice());
        sporders.setProductName(spproduct.getName());
        sporders.setMainUrl(spproduct.getMainUrl());
        sporders.setLocation(spproduct.getLocation());
        sporders.setBrand(spproduct.getBrand());
        sporders.setOrderTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        spproductMapper.updateById(spproduct);
        spordersMapper.insert(sporders);
        return TableModels.success("添加成功");
    }

    //详情
    @ApiOperation(value = "订单详情", httpMethod = "GET", notes = "订单详情")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "订单id")})
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("id") int id) {
        Sporders sporders = spordersMapper.selectById(id);
        return TableModels.success(sporders);
    }


    //取消订单
    @ApiOperation(value = "取消订单", httpMethod = "GET", notes = "取消订单")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "订单id")})
    @RequestMapping("/delete")
    public @ResponseBody
    TableModels delete(@RequestParam("id") int id) {
        spordersMapper.deleteById(id);
        return TableModels.success("删除成功");
    }

}
