package org.javaboy.vhr.controller.emp;

import org.javaboy.vhr.model.*;
import org.javaboy.vhr.service.emp.EmpBasicService;
import org.javaboy.vhr.service.emp.NationService;
import org.javaboy.vhr.service.emp.PoliticsStatusService;
import org.javaboy.vhr.service.system.DepartmentService;
import org.javaboy.vhr.service.system.JobLevelService;
import org.javaboy.vhr.service.system.PositionService;
import org.javaboy.vhr.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * 员工基本信息表
 * @author: TongYaZhou
 * @create: 2020-07-11 10:05
 **/
@RestController
@RequestMapping(value = "/emp/basic")
public class EmpBasicController {

    @Autowired
    EmpBasicService empBasicService;

    //政治面貌
    @Autowired
    PoliticsStatusService politicsStatusService;

    //民族
    @Autowired
    NationService nationService;

    //职位
    @Autowired
    PositionService positionService;

    //职称
    @Autowired
    JobLevelService jobLevelService;

    //部门
    @Autowired
    DepartmentService departmentService;

    /**
     * @param page 第几页
     * @param size 每页展示条数
     * @return
     */
    @GetMapping(value = "/")
    public RespPageBean getEmpBasicListByPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size){

        //计算数据开始位置索引，对应limit的第一个参数
        page = (page - 1) * size;
        //获取员工数据 -- 分页
        List<Employee> employeeList = empBasicService.getEmpBasicListByPage(page, size);
        //获取数据总条数
        int EmpCount = empBasicService.getEmployeeCount();
        //分页响应结果
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setList(employeeList);
        respPageBean.setTotal(EmpCount);
        return respPageBean;
    }


    @PostMapping(value = "/")
    public RespBean addEmployee(@RequestBody Employee employee){
        int result = empBasicService.addEmployee(employee);
        if (result > 0){
            return RespBean.success("添加员工成功");
        }
        return RespBean.error("添加员工失败");
    }

    //加载政治面貌字典数据
    @GetMapping(value = "/politicsStatus")
    public RespBean getPoliticsStatus(){
        List<Politicsstatus> politicsstatuses = politicsStatusService.getPoliticsStatus();
        if (!Objects.isNull(politicsstatuses)){
            return RespBean.success("加载政治面貌成功",politicsstatuses, "false");
        }
        return RespBean.error("加载政治面貌失败");
    }

    //加载民族字典数据
    @GetMapping(value = "/nations")
    public  RespBean getNations(){
        List<Nation> nations = nationService.getNations();
        if (!Objects.isNull(nations)){
            return RespBean.success("加载民族成功",nations, "false");
        }
        return RespBean.error("加载民族失败");
    }

    //加载职位字典数据
    @GetMapping(value = "/positions")
    public  RespBean getPositions(){
        List<Position> positions = positionService.getPositionList();
        if (!Objects.isNull(positions)){
            return RespBean.success("加载职位成功",positions, "false");
        }
        return RespBean.error("加载职位失败");
    }

    //加载职职称字典数据
    @GetMapping(value = "/joblevels")
    public  RespBean getJobLevels(){
        List<JobLevel> jobLevels = jobLevelService.getJobLevelList();
        if (!Objects.isNull(jobLevels)){
            return RespBean.success("加载职称成功",jobLevels, "false");
        }
        return RespBean.error("加载职称失败");
    }

    //获取当前员工列表中最大的工号 -- 工号回显功能
    @GetMapping(value = "/getMaxWorkId")
    public RespBean getMaxWorkId(){
        //获取员工表中的最大工号，取到后在其基础上加1，得到的值就是新员工的工号
        String workID = String.format("%08d", empBasicService.getMaxWorkId() + 1);
        return RespBean.success("成功", workID, "false");
    }

    //获取部门列表
    @GetMapping(value = "/departments")
    public RespBean getDepartments(){
        List<Department> departments = departmentService.getDepartmentList();
        if (!Objects.isNull(departments)){
            return RespBean.success("加载部门列表成功", departments, "false");
        }
        return RespBean.error("加载部门列表失败");
    }


}
