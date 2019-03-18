package tongji.sse.student.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import tongji.sse.student.domain.Experience;
import tongji.sse.student.domain.ExperienceExample;

public interface ExperienceMapper extends Mapper<Experience> {
    @Select("select e.* "+
            "from experience e "+
            "where e.user_id=#{userId}")
    ArrayList<Experience> getUserExpList(@Param("userId")Integer userId);


    @Select("select max(id) "+
            "from experience ")
    Integer getMaxId();
}