package com.ruoyi.project.agricultrue.jxc.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcwareout;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface JxcwareoutMapper extends BaseMapper<Jxcwareout> {
List<Jxcwareout> list(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);
List<Jxcwareout> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
