package com.ruoyi.project.agricultrue.sev.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.sev.pojo.Sevcarousel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SevcarouselMapper extends BaseMapper<Sevcarousel> {
List<Sevcarousel> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
List<Sevcarousel> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
