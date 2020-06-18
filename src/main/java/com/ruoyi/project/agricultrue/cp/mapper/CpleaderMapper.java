package com.ruoyi.project.agricultrue.cp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpleader;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CpleaderMapper extends BaseMapper<Cpleader> {
    List<Cpleader> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Cpleader> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);

    List<Cpleader> selectMySelf(@Param("loginName") String loginName);
}
