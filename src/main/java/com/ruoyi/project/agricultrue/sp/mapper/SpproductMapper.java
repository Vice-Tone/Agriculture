package com.ruoyi.project.agricultrue.sp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Spproduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpproductMapper extends BaseMapper<Spproduct> {
    List<Spproduct> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Spproduct> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);

    List<Spproduct> selectByTypeId(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize,@Param("typeId") int typeId);

    int selectByTypeIdCount(@Param("typeId") int typeId);
}
