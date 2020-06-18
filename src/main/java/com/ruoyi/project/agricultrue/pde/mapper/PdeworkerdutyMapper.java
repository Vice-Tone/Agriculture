package com.ruoyi.project.agricultrue.pde.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.pde.pojo.Pdeworkerduty;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PdeworkerdutyMapper extends BaseMapper<Pdeworkerduty> {
    List<Pdeworkerduty> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Pdeworkerduty> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);

    List<Pdeworkerduty> selectByMobile(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("loginName") String loginName);

    int selectCountByMobile(@Param("loginName") String loginName);
}
