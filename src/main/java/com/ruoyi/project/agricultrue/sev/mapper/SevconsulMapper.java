package com.ruoyi.project.agricultrue.sev.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.sev.pojo.Sevconsul;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface SevconsulMapper extends BaseMapper<Sevconsul> {
    List<Sevconsul> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Sevconsul> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);

    List<Sevconsul> selectByTypeId(@RequestParam("typeId") int typeId);
}
