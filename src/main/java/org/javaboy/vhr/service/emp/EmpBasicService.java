package org.javaboy.vhr.service.emp;

import org.javaboy.vhr.model.Employee;

import java.util.Date;
import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-07-11 10:14
 **/
public interface EmpBasicService {

    /**
     * 获取员工数据 -- 分页
     * @param page 第几页
     * @param size 每页展示条数
     * @param employee
     * @param beginDate
     * @return
     */
    List<Employee> getEmpBasicListByPage(Integer page, Integer size, Employee employee, Date[] beginDate);

    /**
     * 获取数据总条数
     * @return
     * @param employee
     * @param beginDate
     */
    int getEmployeeCount(Employee employee, Date[] beginDate);

    /**
     * 添加员工信息
     * @param employee 员工信息
     * @return
     */
    int addEmployee(Employee employee);

    /**
     * 获取员工列表中的最大的工号
     * @return
     */
    Integer getMaxWorkId();

    /**
     * 删除用户
     * @param id 用户id
     * @return
     */
    int deleteEmployee(Integer id);

    /**
     * 修改员工信息
     * @param employee
     * @return
     */
    int updateEmployee(Employee employee);
}
