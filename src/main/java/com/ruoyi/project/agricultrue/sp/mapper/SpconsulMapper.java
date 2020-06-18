package com.ruoyi.project.agricultrue.sp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Spconsul;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpconsulMapper extends BaseMapper<Spconsul> {
    List<Spconsul> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize,@Param("typeId") int typeId);

    List<Spconsul> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value,@Param("typeId") int typeId);

    int conditionlSelCount(@Param("value") String value,@Param("typeId") int typeId);

    int selectCountByTypeId(@Param("typeId") int typeId);

    List<Spconsul> selectByTypeId(@Param("typeId") int typeId);
}
