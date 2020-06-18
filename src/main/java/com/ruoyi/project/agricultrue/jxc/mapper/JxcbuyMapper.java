package com.ruoyi.project.agricultrue.jxc.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcbuy;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface JxcbuyMapper extends BaseMapper<Jxcbuy> {
List<Jxcbuy> list(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);
List<Jxcbuy> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
