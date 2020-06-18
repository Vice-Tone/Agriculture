package com.ruoyi.project.agricultrue.sp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Spimage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpimageMapper extends BaseMapper<Spimage> {
    List<Spimage> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Spimage> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);

    List<Spimage> selectByLinkId(@Param("id") int id);
}
