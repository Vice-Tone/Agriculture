package com.ruoyi.project.agricultrue.cp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpsales;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CpsalesMapper extends BaseMapper<Cpsales> {
List<Cpsales> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
List<Cpsales> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
