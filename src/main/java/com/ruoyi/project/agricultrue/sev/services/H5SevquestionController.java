package com.ruoyi.project.agricultrue.sev.services;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sev.mapper.SevcommentMapper;
import com.ruoyi.project.agricultrue.sev.mapper.SevquestionMapper;
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
@RequestMapping("/service/sevquestion")
@Api(value = "/service/sevquestion", description = "问题列表")
public class H5SevquestionController {


    @Autowired
    private SevquestionMapper sevquestionMapper;


    @RequestMapping("/publishQuestion")
    @ApiOperation(value = "发布问题", httpMethod = "GET", notes = "发布问题")
    @ApiImplicitParams({@ApiImplicitParam(name = "content", value = "内容"),
            @ApiImplicitParam(name = "username", value = "用户名")})
    public TableModels publishQuestion(Sevquestion sevquestion) {
        sevquestion.setPublishTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        sevquestionMapper.insert(sevquestion);
        return TableModels.success("添加成功");
    }

    @Autowired
    private SevcommentMapper sevcommentMapper;


    //列表
    @RequestMapping("/list")
    @ApiOperation(value = "获取问题及其下的评论", httpMethod = "GET", notes = "获取问题及其下的评论")
    public TableModels list() {
        List<String> orders = new ArrayList<>();
        orders.add("id");
        List<Sevquestion> datas = sevquestionMapper.selectList(new EntityWrapper<Sevquestion>().orderDesc(orders));
        List<SevquestionWithComment> sevquestionWithComments = new ArrayList<>();
        int typeId = 3;
        for (Sevquestion sevquestion : datas) {
            int aId = sevquestion.getId();
            List<Sevcomment> sevcomments = sevcommentMapper.selectByLinkId(typeId, aId);
            sevquestionWithComments.add(new SevquestionWithComment(sevquestion, sevcomments));
        }
        return TableModels.success(sevquestionWithComments);
    }

    @RequestMapping("/publishComment")
    @ApiOperation(value = "在问题下发布评论", httpMethod = "GET", notes = "在问题下发布评论")
    @ApiImplicitParams({@ApiImplicitParam(name = "content", value = "评论内容"),
            @ApiImplicitParam(name = "username", value = "用户名"),
            @ApiImplicitParam(name = "linkId", value = "问题id")})
    public TableModels publishComment(@RequestParam("content") String content,
                                      @RequestParam("username") String username,
                                      @RequestParam("linkId") int linkId) {
        Sevcomment sevcomment = new Sevcomment();
        sevcomment.setUsername(username);
        sevcomment.setPublishTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        sevcomment.setLinkId(linkId);
        sevcomment.setContent(content);
        sevcomment.setTypeId(3);
        sevcommentMapper.insert(sevcomment);
        return TableModels.success("发布成功");
    }


}
