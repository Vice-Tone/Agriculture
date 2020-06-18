package com.ruoyi.project.agricultrue.sev.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.sev.pojo.Sevcomment;
import com.ruoyi.project.agricultrue.sev.pojo.Sevenroll;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SevenrollMapper extends BaseMapper<Sevenroll> {
    List<Sevenroll> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Sevenroll> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);

}
