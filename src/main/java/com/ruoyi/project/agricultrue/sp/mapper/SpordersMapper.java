package com.ruoyi.project.agricultrue.sp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Sporders;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SpordersMapper extends BaseMapper<Sporders> {
    List<Sporders> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Sporders> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);

    List<Sporders> listByUsername(@Param("username") String username);

    List<Map<String, Object>> getList();
}
