package com.ruoyi.project.agricultrue.sev.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.sev.pojo.Sevcomment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SevcommentMapper extends BaseMapper<Sevcomment> {
    List<Sevcomment> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Sevcomment> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);

    List<Sevcomment> selectByLinkId(@Param("typeId") int typeId,@Param("aId")  int aId);
}
