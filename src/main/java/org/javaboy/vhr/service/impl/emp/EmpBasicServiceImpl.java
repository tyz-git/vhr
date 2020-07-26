package org.javaboy.vhr.service.impl.emp;

import org.javaboy.vhr.mapper.EmpBasicMapper;
import org.javaboy.vhr.model.Employee;
import org.javaboy.vhr.service.emp.EmpBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-07-11 10:16
 **/
@Service
public class EmpBasicServiceImpl implements EmpBasicService {

    @Autowired
    EmpBasicMapper empBasicMapper;

    @Override
    public int updateEmployee(Employee employee) {
        int result = empBasicMapper.updateEmployee(employee);
        return result;
    }

    @Override
    public int deleteEmployee(Integer id) {
        int result = empBasicMapper.deleteEmployee(id);
        return result;
    }

    @Override
    public Integer getMaxWorkId() {
        Integer maxWorkId = empBasicMapper.getMaxWorkId();
        return maxWorkId;
    }

    @Override
    public int addEmployee(Employee employee) {
        int result = empBasicMapper.addEmployee(employee);
        return result;
    }

    @Override
    public List<Employee> getEmpBasicListByPage(Integer page, Integer size, Employee employee, Date[] beginDate) {
        List<Employee> employeeList = empBasicMapper.getEmpBasicListByPage(page, size, employee, beginDate);
        return employeeList;
    }

    @Override
    public int getEmployeeCount(Employee employee, Date[] beginDate) {
        int empCount = empBasicMapper.getEmployeeCount(employee, beginDate);
        return empCount;
    }
}
