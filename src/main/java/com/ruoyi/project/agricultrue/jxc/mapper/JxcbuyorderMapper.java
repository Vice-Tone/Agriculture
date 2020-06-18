package com.ruoyi.project.agricultrue.jxc.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcbuyorder;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface JxcbuyorderMapper extends BaseMapper<Jxcbuyorder> {
List<Jxcbuyorder> list(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);
List<Jxcbuyorder> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
