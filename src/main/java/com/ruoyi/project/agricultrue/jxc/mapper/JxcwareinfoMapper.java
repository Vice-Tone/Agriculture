package com.ruoyi.project.agricultrue.jxc.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcwareinfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface JxcwareinfoMapper extends BaseMapper<Jxcwareinfo> {
List<Jxcwareinfo> list(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);
List<Jxcwareinfo> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
