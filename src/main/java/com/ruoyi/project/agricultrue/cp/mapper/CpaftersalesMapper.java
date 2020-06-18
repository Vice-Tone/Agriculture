package com.ruoyi.project.agricultrue.cp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpaftersales;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CpaftersalesMapper extends BaseMapper<Cpaftersales> {
    List<Cpaftersales> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Cpaftersales> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);

    List<Cpaftersales> listByCode(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("loginName") String loginName);

    int selectCountByCode(@Param("loginName") String loginName);
}
