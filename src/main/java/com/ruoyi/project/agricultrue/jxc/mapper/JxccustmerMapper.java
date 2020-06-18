package com.ruoyi.project.agricultrue.jxc.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxccustmer;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface JxccustmerMapper extends BaseMapper<Jxccustmer> {
List<Jxccustmer> list(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);
List<Jxccustmer> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
