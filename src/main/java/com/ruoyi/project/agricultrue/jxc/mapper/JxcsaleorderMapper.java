package com.ruoyi.project.agricultrue.jxc.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcsaleorder;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface JxcsaleorderMapper extends BaseMapper<Jxcsaleorder> {
List<Jxcsaleorder> list(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);
List<Jxcsaleorder> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
