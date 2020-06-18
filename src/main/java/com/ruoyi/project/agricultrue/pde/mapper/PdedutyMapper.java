package com.ruoyi.project.agricultrue.pde.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.pde.pojo.Pdeduty;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PdedutyMapper extends BaseMapper<Pdeduty> {
    List<Pdeduty> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Pdeduty> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);
}
