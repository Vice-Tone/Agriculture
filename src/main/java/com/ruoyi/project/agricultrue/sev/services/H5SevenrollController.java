package com.ruoyi.project.agricultrue.sev.services;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sev.mapper.SevcommentMapper;
import com.ruoyi.project.agricultrue.sev.mapper.SevenrollMapper;
import com.ruoyi.project.agricultrue.sev.pojo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/service/sevenroll")
@Api(value = "/service/sevenroll", description = "招聘管理")
public class H5SevenrollController {


    @Autowired
    private SevenrollMapper sevenrollMapper;

    @Autowired
    private SevcommentMapper sevcommentMapper;


    //列表
    @RequestMapping("/list")
    @ApiOperation(value = "获取招聘及其下的评论", httpMethod = "GET", notes = "获取招聘及其下的评论")
    public @ResponseBody
    TableModels list() {
        List<String> orders = new ArrayList<>();
        orders.add("id");
        List<Sevenroll> datas = sevenrollMapper.selectList(new EntityWrapper<Sevenroll>().orderDesc(orders));
        List<SevenrollWithComment> sevenrollWithComments = new ArrayList<>();
        int typeId = 2;
        for (Sevenroll sevenroll : datas) {
            int aId = sevenroll.getId();
            List<Sevcomment> sevcomments = sevcommentMapper.selectByLinkId(typeId, aId);
            sevenrollWithComments.add(new SevenrollWithComment(sevenroll, sevcomments));
        }
        return TableModels.success(sevenrollWithComments);
    }

    @RequestMapping("/publishComment")
    @ApiOperation(value = "在招聘下发布评论", httpMethod = "GET", notes = "在招聘下发布评论")
    @ApiImplicitParams({@ApiImplicitParam(name = "content", value = "评论内容"),
            @ApiImplicitParam(name = "username", value = "用户名"),
            @ApiImplicitParam(name = "linkId", value = "招聘id")})
    public TableModels publishComment(@RequestParam("content") String content,
                                      @RequestParam("username") String username,
                                      @RequestParam("linkId") int linkId) {
        Sevcomment sevcomment = new Sevcomment();
        sevcomment.setUsername(username);
        sevcomment.setPublishTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        sevcomment.setLinkId(linkId);
        sevcomment.setContent(content);
        sevcomment.setTypeId(2);
        sevcommentMapper.insert(sevcomment);
        return TableModels.success("发布成功");
    }
}
