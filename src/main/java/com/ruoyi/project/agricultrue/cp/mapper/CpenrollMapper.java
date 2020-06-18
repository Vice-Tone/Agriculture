package com.ruoyi.project.agricultrue.cp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpenroll;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CpenrollMapper extends BaseMapper<Cpenroll> {
    List<Cpenroll> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Cpenroll> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);
}
