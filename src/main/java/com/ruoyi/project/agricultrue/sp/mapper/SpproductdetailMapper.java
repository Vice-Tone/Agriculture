package com.ruoyi.project.agricultrue.sp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Spproductdetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpproductdetailMapper extends BaseMapper<Spproductdetail> {
    List<Spproductdetail> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Spproductdetail> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);

    Spproductdetail selectByLinkId(@Param("id") int id);
}
