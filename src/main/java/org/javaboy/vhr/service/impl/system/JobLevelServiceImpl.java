package org.javaboy.vhr.service.impl.system;

import org.javaboy.vhr.mapper.JobLevelMapper;
import org.javaboy.vhr.model.JobLevel;
import org.javaboy.vhr.service.system.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-06-07 19:16
 **/
@Service
public class JobLevelServiceImpl implements JobLevelService {

    @Autowired
    JobLevelMapper jobLevelMapper;

    @Override
    public int deleteJobLevel(Integer id) {
        int result = jobLevelMapper.deleteJobLevel(id);
        return result;
    }

    @Override
    public int updateJobLevelSelective(JobLevel jobLevel) {
        int result = jobLevelMapper.updateJobLevelSelective(jobLevel);
        return result;
    }

    @Override
    public int addJobLevelSelective(JobLevel jobLevel) {
        int result = jobLevelMapper.addJobLevelSelective(jobLevel);
        return result;
    }

    @Override
    public int deleteJobLevels(Integer[] ids) {
        int result = jobLevelMapper.deleteJobLevels(ids);
        return result;
    }

    @Override
    public List<JobLevel> getJobLevelList() {
        List<JobLevel> jobLevels = jobLevelMapper.getJobLevelList();
        return jobLevels;
    }
}
