package com.ruoyi.project.agricultrue.pde.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.pde.pojo.Pdeassess;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface PdeassessMapper extends BaseMapper<Pdeassess> {
List<Pdeassess> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
List<Pdeassess> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
