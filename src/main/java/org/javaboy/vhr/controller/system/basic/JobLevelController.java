package org.javaboy.vhr.controller.system.basic;

import org.javaboy.vhr.model.JobLevel;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.system.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author: TongYaZhou
 * @create: 2020-06-07 19:14
 **/
@RestController
@RequestMapping(value = "/system/basic/jobLevel")
public class JobLevelController {

    @Autowired
    JobLevelService jobLevelService;

    @GetMapping(value = "/")
    public RespBean getJobLevelList(){
        List<JobLevel> jobLevelList = jobLevelService.getJobLevelList();
        if (!Objects.isNull(jobLevelList)) {
            return RespBean.success("获取职称列表成功!", jobLevelList, "false");
        }
        return RespBean.error("获取职称列表失败!");
    }

    @PostMapping(value = "/")
    public RespBean addJobLevelSelective(@RequestBody JobLevel jobLevel){
        int result = jobLevelService.addJobLevelSelective(jobLevel);
        if (result > 0) {
            return RespBean.success("添加职称成功!");
        }
        return RespBean.error("添加职称失败!");
    }

    @PutMapping(value = "/")
    public RespBean updateJobLevelSelective(@RequestBody JobLevel jobLevel) {
        int result = jobLevelService.updateJobLevelSelective(jobLevel);
        if (result > 0) {
            return RespBean.success("修改职称成功!");
        }
        return RespBean.error("修改职称失败!");
    }

    @DeleteMapping(value = "/{id}")
    public RespBean deleteJobLevel(@PathVariable Integer id) {
        int result = jobLevelService.deleteJobLevel(id);
        if (result > 0) {
            return RespBean.success("删除职称成功!");
        }
        return RespBean.error("删除职称失败!");
    }

    @DeleteMapping(value = "/")
    public RespBean deleteJobLevels(Integer[] ids) {
        int result = jobLevelService.deleteJobLevels(ids);
        if (result == ids.length) {
            return RespBean.success("批量删除职称成功!");
        }
        return RespBean.error("批量职称失败!");
    }
}
