package com.ruoyi.project.agricultrue.cp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpattendance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CpattendanceMapper extends BaseMapper<Cpattendance> {
    List<Cpattendance> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Cpattendance> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);

    Cpattendance selectCodeDayTime(@Param("code") String code, @Param("dayTime") String dayTime);

    List<Cpattendance> selectMyAttendence(@Param("loginName") String loginName, @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    int selectMyAttendenceCount(@Param("loginName") String loginName);
}
