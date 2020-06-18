package com.ruoyi.project.agricultrue.sev.services;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.sev.mapper.SevannounceMapper;
import com.ruoyi.project.agricultrue.sev.mapper.SevcommentMapper;
import com.ruoyi.project.agricultrue.sev.pojo.SevactivityWithComment;
import com.ruoyi.project.agricultrue.sev.pojo.Sevannounce;
import com.ruoyi.project.agricultrue.sev.pojo.Sevcomment;
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
@RequestMapping("/service/sevannounce")
@Api(value = "/service/sevannounce", description = "公告列表")
public class H5SevannounceController {


    @Autowired
    private SevannounceMapper sevannounceMapper;

    @Autowired
    private SevcommentMapper sevcommentMapper;


    //列表
    @RequestMapping("/list")
    @ApiOperation(value = "获取公告及其下的评论", httpMethod = "GET", notes = "获取公告及其下的评论")
    public @ResponseBody
    TableModels list() {
        List<String> orders = new ArrayList<>();
        orders.add("id");
        List<Sevannounce> datas = sevannounceMapper.selectList(new EntityWrapper<Sevannounce>().orderDesc(orders));
        List<SevactivityWithComment> sevactivityWithComments = new ArrayList<>();
        int typeId = 1;
        for (Sevannounce sevannounce : datas) {
            int aId = sevannounce.getId();
            List<Sevcomment> sevcomments = sevcommentMapper.selectByLinkId(typeId, aId);
            sevactivityWithComments.add(new SevactivityWithComment(sevannounce, sevcomments));
        }
        return TableModels.success(sevactivityWithComments);
    }

    @RequestMapping("/publishComment")
    @ApiOperation(value = "在公告下发布评论", httpMethod = "GET", notes = "在公告下发布评论")
    @ApiImplicitParams({@ApiImplicitParam(name = "content", value = "评论内容"),
            @ApiImplicitParam(name = "username", value = "用户名"),
            @ApiImplicitParam(name = "linkId", value = "公告id")})
    public TableModels publishComment(@RequestParam("content") String content,
                                      @RequestParam("username") String username,
                                      @RequestParam("linkId") int linkId) {
        Sevcomment sevcomment = new Sevcomment();
        sevcomment.setUsername(username);
        sevcomment.setPublishTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        sevcomment.setLinkId(linkId);
        sevcomment.setContent(content);
        sevcomment.setTypeId(1);
        sevcommentMapper.insert(sevcomment);
        return TableModels.success("发布成功");
    }


}
