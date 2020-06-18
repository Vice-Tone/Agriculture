package com.ruoyi.project.agricultrue.pde.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.pde.pojo.Pdesubmission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PdesubmissionMapper extends BaseMapper<Pdesubmission> {
    List<Pdesubmission> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Pdesubmission> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);

    int selectAllParentId(@Param("parentId") int parentId);

    int selectFinishedParentId(@Param("parentId") int parentId);
}
