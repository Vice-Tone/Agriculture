package com.ruoyi.project.agricultrue.pde.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.pde.pojo.Pdequality;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface PdequalityMapper extends BaseMapper<Pdequality> {
List<Pdequality> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
List<Pdequality> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
