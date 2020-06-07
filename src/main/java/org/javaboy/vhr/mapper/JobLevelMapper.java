package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.JobLevel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-06-07 19:16
 **/
@Repository
public interface JobLevelMapper {

    List<JobLevel> getJobLevelList();

    int addJobLevelSelective(JobLevel jobLevel);

    int updateJobLevelSelective(JobLevel jobLevel);

    int deleteJobLevel(Integer id);

    int deleteJobLevels(@Param("ids") Integer[] ids);
}
