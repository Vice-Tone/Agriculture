package com.ruoyi.project.agricultrue.cp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpworker;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CpworkerMapper extends BaseMapper<Cpworker> {
    List<Cpworker> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Cpworker> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);

    List<Cpworker> selectMySelf(@Param("loginName") String loginName);

    List<Cpworker> selectDeptWorkers(@Param("loginName") String loginName, @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    int selectDeptWorkersCount(@Param("loginName") String loginName);
}
