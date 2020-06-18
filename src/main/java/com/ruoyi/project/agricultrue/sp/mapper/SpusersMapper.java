package com.ruoyi.project.agricultrue.sp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Spusers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpusersMapper extends BaseMapper<Spusers> {
    List<Spusers> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    List<Spusers> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);

    int conditionlSelCount(@Param("value") String value);

    Spusers selectByUName(@Param("userName") String userName);

    void updateByUserName(Spusers users);

    Spusers selectByUNameAndPwd(@Param("userName") String userName,@Param("password") String password);
}
