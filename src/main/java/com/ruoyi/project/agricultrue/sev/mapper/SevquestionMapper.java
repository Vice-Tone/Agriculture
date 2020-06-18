package com.ruoyi.project.agricultrue.sev.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.sev.pojo.Sevquestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SevquestionMapper extends BaseMapper<Sevquestion> {
    List<Sevquestion> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Sevquestion> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);
}
