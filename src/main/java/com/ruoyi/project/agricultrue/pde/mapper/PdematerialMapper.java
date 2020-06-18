package com.ruoyi.project.agricultrue.pde.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.pde.pojo.Pdematerial;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PdematerialMapper extends BaseMapper<Pdematerial> {
    List<Pdematerial> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Pdematerial> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);
}
