package com.ruoyi.project.agricultrue.jxc.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcspecification;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface JxcspecificationMapper extends BaseMapper<Jxcspecification> {
List<Jxcspecification> list(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);
List<Jxcspecification> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value); 
}
