package com.ruoyi.project.agricultrue.sev.controller;

import com.ruoyi.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class UEditorController {


    @RequestMapping("/sevactivityadd")
    public String uEditorDemo() {
        return "/agricultrue/sev/sevactivityadd";
    }


    @RequestMapping("/sevconsuladd")
    public String questionList() {
        return "/agricultrue/sev/sevconsuladd";
    }

    //查看问卷转发链接
    @GetMapping("/viewQues")
    public String viewQues(@RequestParam("id") int id, ModelMap map) {
        map.put("id", id);
        return "/viewQues";
    }

    //查看回复转发链接
    @GetMapping("/viewReply")
    public String viewReply(@RequestParam("id") int id, ModelMap map) {
        map.put("id", id);
        return "/viewReply";
    }

    //添加回复转发链接
    @GetMapping("/addReply")
    public String addReply(@RequestParam("id") int id, ModelMap map) {
        map.put("id", id);
        return "/addReply";
    }


    @RequestMapping("/uEditor/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");

        try {
            String exec = new ActionEnter(request, rootPath).exec();
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
