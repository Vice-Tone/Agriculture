package com.ruoyi.project.agricultrue.jxc.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcsuppiler;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface JxcsuppilerMapper extends BaseMapper<Jxcsuppiler> {
List<Jxcsuppiler> list(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);
List<Jxcsuppiler> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
