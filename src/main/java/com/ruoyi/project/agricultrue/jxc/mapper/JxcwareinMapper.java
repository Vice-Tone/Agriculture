package com.ruoyi.project.agricultrue.jxc.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.jxc.pojo.Jxcwarein;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface JxcwareinMapper extends BaseMapper<Jxcwarein> {
List<Jxcwarein> list(@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);
List<Jxcwarein> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value);

    List<String> selectByNum(@Param("num") int num);

    List<Jxcwarein> getList(@Param("datemillsStart") long datemillsStart,@Param("datemillsEnd")  long datemillsEnd);
}
