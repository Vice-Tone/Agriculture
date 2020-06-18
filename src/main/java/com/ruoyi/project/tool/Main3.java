package com.ruoyi.project.tool;

import com.ruoyi.project.tool.codegenerator.controller.EntityController;

public class Main3 {

    public static void main(String[] args) {
        EntityController entityController=new EntityController("songs");
        String ret=entityController.getEntity();
        System.out.println(ret);
    }
}
