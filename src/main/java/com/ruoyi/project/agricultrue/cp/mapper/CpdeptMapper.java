package com.ruoyi.project.agricultrue.cp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpdept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CpdeptMapper extends BaseMapper<Cpdept> {
List<Cpdept> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
List<Cpdept> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
