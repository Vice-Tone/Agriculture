package com.ruoyi.project.agricultrue.sp.shop;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sp.mapper.SpproductMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Spproduct;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop/spproduct")
@Api(value = "/shop/spproduct", description = "关于农机*")
public class H5SpproductController {


    @Autowired
    private SpproductMapper spproductMapper;

    //列表
    @ApiOperation(value = "获取农机列表", httpMethod = "GET", notes = "获取农机列表")
    @RequestMapping("/list")
    public @ResponseBody
    TableModels list(@RequestParam(value = "pageIndex", required = false, defaultValue = "1") int pageIndex
            , @RequestParam(value = "pageSize", required = false, defaultValue = "60") int pageSize) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Spproduct> datas = spproductMapper.list(pageIndex, pageSize);
        int count = spproductMapper.selectCount(new EntityWrapper<>());
        return TableModels.success(count, datas);
    }

    @ApiOperation(value = "根据关键字获取农机列表", httpMethod = "GET", notes = "根据关键字获取农机列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "value", value = "关键字")})
    @RequestMapping("/getByName")
    public @ResponseBody
    TableModels getByName(@RequestParam(value = "pageIndex", required = false, defaultValue = "1") int pageIndex
            , @RequestParam(value = "pageSize", required = false, defaultValue = "60") int pageSize,
                          @RequestParam(value = "value", required = false, defaultValue = "") String value) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Spproduct> datas = spproductMapper.conditionlSel(pageIndex, pageSize, value);
        int count = spproductMapper.conditionlSelCount(value);
        return TableModels.success(count, datas);
    }

    @ApiOperation(value = "根据类别获取农机列表", httpMethod = "GET", notes = "根据类别获取农机列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "typeId", value = "类别id")})
    @RequestMapping("/getByTypeId")
    public @ResponseBody
    TableModels getByTypeId(@RequestParam(value = "pageIndex", required = false, defaultValue = "1") int pageIndex
            , @RequestParam(value = "pageSize", required = false, defaultValue = "60") int pageSize,
                            @RequestParam(value = "typeId", required = false, defaultValue = "") int typeId) {
        pageIndex = (pageIndex - 1) * pageSize;
        List<Spproduct> datas = spproductMapper.selectByTypeId(pageIndex, pageSize, typeId);
        int count = spproductMapper.selectByTypeIdCount(typeId);

        return TableModels.success(count, datas);
    }

    @ApiOperation(value = "获取农机产品记录", httpMethod = "GET", notes = "获取农机产品记录")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "农机id")})
    @RequestMapping("/getById")
    public @ResponseBody
    TableModels getById(@RequestParam(value = "id") int id) {
        Spproduct spproduct = spproductMapper.selectById(id);
        return TableModels.success(spproduct);
    }


}
