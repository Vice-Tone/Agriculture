package com.ruoyi.project.agricultrue.sp.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Cpaftersales;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface CpaftersaleMapper extends BaseMapper<Cpaftersales> {
List<Cpaftersales> list(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);
List<Cpaftersales> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
