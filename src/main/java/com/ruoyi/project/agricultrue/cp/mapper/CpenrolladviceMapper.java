package com.ruoyi.project.agricultrue.cp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.cp.pojo.Cpenrolladvice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CpenrolladviceMapper extends BaseMapper<Cpenrolladvice> {
List<Cpenrolladvice> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
List<Cpenrolladvice> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
