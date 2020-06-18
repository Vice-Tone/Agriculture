package com.ruoyi.project.agricultrue.pde.mapper;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ruoyi.project.agricultrue.pde.pojo.Pdeworker;
import org.apache.ibatis.annotations.Param;
import java.util.List;
public interface PdeworkerMapper extends BaseMapper<Pdeworker> {
List<Pdeworker> list(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);
List<Pdeworker> conditionlSel(@Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize, @Param("value") String value);
    int conditionlSelCount(@Param("value") String value);

    List<Pdeworker> selectMySelf(@Param("loginName") String loginName);
}
