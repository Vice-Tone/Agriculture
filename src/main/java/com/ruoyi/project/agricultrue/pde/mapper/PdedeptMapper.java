package com.ruoyi.project.agricultrue.pde.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.pde.pojo.Pdedept;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface PdedeptMapper extends BaseMapper<Pdedept> {
List<Pdedept> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
List<Pdedept> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
