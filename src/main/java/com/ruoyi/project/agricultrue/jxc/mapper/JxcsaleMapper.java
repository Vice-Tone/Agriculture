package com.ruoyi.project.agricultrue.jxc.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcsale;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JxcsaleMapper extends BaseMapper<Jxcsale> {
    List<Jxcsale> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("typeId") int typeId);

    List<Jxcsale> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value, @Param("typeId") int typeId);

    int conditionlSelCount(@Param("value") String value, @Param("typeId") int typeId);

    int selectCountTypeId(@Param("typeId") int typeId);
}
