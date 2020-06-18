package com.ruoyi.project.agricultrue.jxc.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcassetin;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface JxcassetinMapper extends BaseMapper<Jxcassetin> {
List<Jxcassetin> list(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);
List<Jxcassetin> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
