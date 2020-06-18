package com.ruoyi.project.agricultrue.cp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpcustomer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CpcustomerMapper extends BaseMapper<Cpcustomer> {
List<Cpcustomer> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
List<Cpcustomer> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
