package com.ruoyi.project.agricultrue.sp.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.sp.pojo.Sptype;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface SptypeMapper extends BaseMapper<Sptype> {
List<Sptype> list(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);
List<Sptype> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
