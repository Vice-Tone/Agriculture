package com.ruoyi.project.agricultrue.cp.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ruoyi.common.TableModels;
import com.ruoyi.project.agricultrue.cp.mapper.CpdeptMapper;
import com.ruoyi.project.agricultrue.cp.mapper.CpenrollMapper;
import com.ruoyi.project.agricultrue.cp.mapper.CpleaderMapper;
import com.ruoyi.project.agricultrue.cp.mapper.CpworkerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/count")
public class CountController {

    @Autowired
    private CpdeptMapper cpdeptMapper;

    @Autowired
    private CpleaderMapper cpleaderMapper;

    @Autowired
    private CpenrollMapper cpenrollMapper;

    @Autowired
    private CpworkerMapper cpworkerMapper;


    @RequestMapping("/getNums")
    public TableModels getNums() {
        Map<String, Object> map = new HashMap<>();
        map.put("depts", cpdeptMapper.selectCount(new EntityWrapper<>()));
        map.put("workers", cpworkerMapper.selectCount(new EntityWrapper<>()));
        map.put("leaders", cpleaderMapper.selectCount(new EntityWrapper<>()));
        map.put("enrolls", cpenrollMapper.selectCount(new EntityWrapper<>()));
        return TableModels.success(map);
    }


}
