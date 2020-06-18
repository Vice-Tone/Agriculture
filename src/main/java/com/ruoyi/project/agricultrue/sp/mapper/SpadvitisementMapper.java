package com.ruoyi.project.agricultrue.sp.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Spadvitisement;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface SpadvitisementMapper extends BaseMapper<Spadvitisement> {
List<Spadvitisement> list(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);
List<Spadvitisement> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
