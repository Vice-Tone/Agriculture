package com.ruoyi.project.agricultrue.sev.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.sev.pojo.Sevactivity;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface SevactivityMapper extends BaseMapper<Sevactivity> {
List<Sevactivity> list(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);
List<Sevactivity> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
