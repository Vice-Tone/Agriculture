package com.ruoyi.project.agricultrue.sev.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.sev.pojo.Sevannounce;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface SevannounceMapper extends BaseMapper<Sevannounce> {
List<Sevannounce> list(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);
List<Sevannounce> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
