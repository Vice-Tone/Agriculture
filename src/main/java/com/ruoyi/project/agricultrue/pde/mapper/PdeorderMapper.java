package com.ruoyi.project.agricultrue.pde.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.pde.pojo.Pdeorder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PdeorderMapper extends BaseMapper<Pdeorder> {
    List<Pdeorder> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Pdeorder> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);
}
