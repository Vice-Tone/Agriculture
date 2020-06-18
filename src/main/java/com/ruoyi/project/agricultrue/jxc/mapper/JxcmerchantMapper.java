package com.ruoyi.project.agricultrue.jxc.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcmerchant;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface JxcmerchantMapper extends BaseMapper<Jxcmerchant> {
List<Jxcmerchant> list(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);
List<Jxcmerchant> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
