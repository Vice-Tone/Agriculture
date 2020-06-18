package com.ruoyi.project.agricultrue.cp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpsalary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CpsalaryMapper extends BaseMapper<Cpsalary> {
    List<Cpsalary> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Cpsalary> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);

    Cpsalary selectByCodeDayTime(@Param("code") String code, @Param("dayTime") String dayTime);

    List<Cpsalary> selectMySalary(@Param("loginName") String loginName, @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    int selectMySalaryCount(@Param("loginName") String loginName);
}
