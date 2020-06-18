package com.ruoyi.project.agricultrue.cp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpprise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CppriseMapper extends BaseMapper<Cpprise> {
    List<Cpprise> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Cpprise> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);

    Cpprise selectByCodeDayTime(@Param("code") String code, @Param("dayTime") String dayTime);

    List<Cpprise> selectMyCprise(@Param("loginName") String loginName, @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    int selectMyCpriseCount(@Param("loginName") String loginName);
}
