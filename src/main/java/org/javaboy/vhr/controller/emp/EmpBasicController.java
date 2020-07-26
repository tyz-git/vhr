package org.javaboy.vhr.controller.emp;

import com.alibaba.excel.EasyExcel;
import org.javaboy.vhr.mapper.EmpBasicMapper;
import org.javaboy.vhr.model.*;
import org.javaboy.vhr.service.emp.EmpBasicService;
import org.javaboy.vhr.service.emp.NationService;
import org.javaboy.vhr.service.emp.PoliticsStatusService;
import org.javaboy.vhr.service.system.DepartmentService;
import org.javaboy.vhr.service.system.JobLevelService;
import org.javaboy.vhr.service.system.PositionService;
import org.javaboy.vhr.utils.EmployeeListener;
import org.javaboy.vhr.utils.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

    //excel直接存库
    @Autowired
    EmpBasicMapper empBasicMapper;

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
     * @param page 当前页
     * @param size 每页展示条数
     * @return
     */
    @RequestMapping(value = "/getEmpBasicListByPage")
    public RespPageBean getEmpBasicListByPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestBody Employee employee, HttpServletRequest request, Date[] beginDate){

        //beginDate参数默认不为null，这里做一下处理，防止sql索引越界
        if (beginDate.length != 2){
            beginDate = null;
        }
        //计算数据开始位置索引，对应limit的第一个参数
        page = (page - 1) * size;
        //获取员工数据 -- 分页
        List<Employee> employeeList = empBasicService.getEmpBasicListByPage(page, size, employee, beginDate);
        //数据装入session中，为导出excel做准备
        request.getSession().setAttribute("employeeList", employeeList);
        //获取数据总条数
        int EmpCount = empBasicService.getEmployeeCount(employee, beginDate);
        //分页响应结果
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setList(employeeList);
        respPageBean.setTotal(EmpCount);
        return respPageBean;
    }


    //添加员工
    @PostMapping(value = "/")
    public RespBean addEmployee(@RequestBody Employee employee){
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        DecimalFormat decimalFormat = new DecimalFormat("##.00");

        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        //根据合同起始日期和结束日期计算出合同是几年的
        double month = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract))) * 12 +
                (Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract)));

        employee.setContractTerm(Double.parseDouble(decimalFormat.format(month / 12)));
        int result = empBasicService.addEmployee(employee);
        if (result > 0){
            return RespBean.success("添加员工成功");
        }
        return RespBean.error("添加员工失败");
    }

    //删除员工
    @DeleteMapping(value = "/{id}")
    public RespBean deleteEmployee(@PathVariable Integer id){
        int result = empBasicService.deleteEmployee(id);
        if (result > 0){
            return RespBean.success("删除员工成功");
        }
        return RespBean.error("删除员工失败");
    }

    //修改员工
    @PutMapping(value = "/")
    public RespBean updateEmployee(@RequestBody Employee employee){
        int result = empBasicService.updateEmployee(employee);
        if (result > 0){
            return RespBean.success("修改员工成功");
        }
        return RespBean.error("修改员工失败");
    }

    @GetMapping(value = "/export")
    public void export(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Employee> employeeList = (List<Employee>) request.getSession().getAttribute("employeeList");
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("员工信息", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Employee.class).sheet("员工信息sheet页").doWrite(employeeList);
    }

    @PostMapping(value = "/uploadImport")
    public void uploadImport(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), Employee.class, new EmployeeListener(empBasicMapper)).sheet().doRead();
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
