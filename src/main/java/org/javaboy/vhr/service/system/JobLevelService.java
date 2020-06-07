package org.javaboy.vhr.service.system;

import org.javaboy.vhr.model.JobLevel;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-06-07 19:15
 **/
public interface JobLevelService {

    List<JobLevel> getJobLevelList();

    int addJobLevelSelective(JobLevel jobLevel);

    int updateJobLevelSelective(JobLevel jobLevel);

    int deleteJobLevel(Integer id);

    int deleteJobLevels(Integer[] ids);
}
