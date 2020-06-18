package com.ruoyi.project.agricultrue.sp.shop;

import com.ruoyi.common.TableModels;
import com.ruoyi.framework.shiro.service.PasswordService;
import com.ruoyi.project.agricultrue.sp.mapper.CpaftersaleMapper;
import com.ruoyi.project.agricultrue.sp.mapper.SpordersMapper;
import com.ruoyi.project.agricultrue.sp.mapper.SpusersMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Cpaftersales;
import com.ruoyi.project.agricultrue.sp.pojo.Spusers;
import com.ruoyi.project.system.user.domain.User;
import com.ruoyi.project.system.user.domain.UserRole;
import com.ruoyi.project.system.user.mapper.UserMapper;
import com.ruoyi.project.system.user.mapper.UserRoleMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shop/spusers")
@Api(value = "/shop/spusers", description = "关于用户*")
public class H5SpusersController {


    @Autowired
    private SpusersMapper spusersMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private PasswordService passwordService;


    //添加
    @ApiOperation(value = "用户注册", httpMethod = "GET", notes = "用户注册")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名"),
            @ApiImplicitParam(name = "password", value = "密码")})
    @RequestMapping("/register")
    public @ResponseBody
    TableModels add(Spusers spusers) {
        String loginName = spusers.getUsername();
        User user = userMapper.selectUserByLoginName(loginName);
        if (user != null) {
            return TableModels.failure("用户名已存在");
        }

        //插入一条数据到用户表
        User user1 = new User();
        user1.setUserName("匿名用户");
        user1.setLoginName(loginName);
        user1.setSalt(loginName);
        String password = passwordService.encryptPassword(loginName, loginName, loginName);
        user1.setPassword(password);
        user1.setStatus("0");
        user1.setDelFlag("0");
        userMapper.insertUser(user1);

        //插入成功以后 根据loginName查询用户信息
        user = userMapper.selectUserByLoginName(loginName);
        long userId = user.getUserId();
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId((long) 2);
        List<UserRole> userRoles = new ArrayList<>();
        userRoles.add(userRole);
        userRoleMapper.batchUserRole(userRoles);

        spusersMapper.insert(spusers);
        return TableModels.success("注册成功");
    }

    //详情
    @ApiOperation(value = "用户详细信息", httpMethod = "GET", notes = "用户详细信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名")})
    @RequestMapping("/detail")
    public @ResponseBody
    TableModels detail(@RequestParam("username") String userName) {
        Spusers users = spusersMapper.selectByUName(userName);
        return TableModels.success(users);
    }


    //完善个人信息
    @ApiOperation(value = "完善个人信息", httpMethod = "GET", notes = "完善个人信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名"),
            @ApiImplicitParam(name = "name", value = "姓名"),
            @ApiImplicitParam(name = "gender", value = "性别"),
            @ApiImplicitParam(name = "school", value = "学校"),
            @ApiImplicitParam(name = "profession", value = "专业")})
    @RequestMapping("/edit")
    public @ResponseBody
    TableModels edit(Spusers users) {
        spusersMapper.updateByUserName(users);
        return TableModels.success();
    }

    //用户登录
    @ApiOperation(value = "用户登录", httpMethod = "GET", notes = "用户登录")
    @ApiImplicitParams({@ApiImplicitParam(name = "username", value = "用户名"),
            @ApiImplicitParam(name = "password", value = "密码")})
    @RequestMapping("/login")
    public @ResponseBody
    TableModels login(@RequestParam("username") String userName,
                      @RequestParam("password") String password) {
        Spusers users = spusersMapper.selectByUNameAndPwd(userName, password);
        if (users == null)
            return TableModels.failure("用户名或密码错误");
        return TableModels.success(userName);
    }

    @Autowired
    private SpordersMapper spordersMapper;

    @Autowired
    private CpaftersaleMapper cpaftersaleMapper;

    @ApiOperation(value = "售后问题", httpMethod = "GET", notes = "售后问题")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "orderNum", value = "订单编号"),
                    @ApiImplicitParam(name = "orderName", value = "订单名称"),
                    @ApiImplicitParam(name = "customername", value = "客户编号"),
                    @ApiImplicitParam(name = "customName", value = "客户姓名"),
            @ApiImplicitParam(name = "problem", value = "问题详情")})
    @RequestMapping("/afterSales")
    public TableModels afterSales(Cpaftersales cpaftersales) {
        cpaftersaleMapper.insert(cpaftersales);
        return TableModels.success("上传成功");
    }


}
