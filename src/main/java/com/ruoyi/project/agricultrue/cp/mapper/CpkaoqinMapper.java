package com.ruoyi.project.agricultrue.cp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpkaoqin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CpkaoqinMapper extends BaseMapper<Cpkaoqin> {
    List<Cpkaoqin> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Cpkaoqin> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);
}
