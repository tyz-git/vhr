package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-06-14 21:37
 **/
@Repository
public interface EmpBasicMapper {

    /**
     * 获取员工数据 -- 分页
     * @param page 第几页
     * @param size 每页展示条数
     * @param employee
     * @param beginDate
     * @return
     */
    List<Employee> getEmpBasicListByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("emp") Employee employee, @Param("beginDate") Date[] beginDate);

    /**
     * 获取数据总条数
     * @return
     * @param employee
     * @param beginDate
     */
    int getEmployeeCount(@Param("emp") Employee employee, Date[] beginDate);

    /**
     * 添加员工信息
     * @param employee 员工信息
     * @return
     */
    int addEmployee(Employee employee);

    /**
     * 获取工号员工列表中最大的工号
     * @return
     */
    Integer getMaxWorkId();

    /**
     * 删除用户
     * @param id 用户id
     * @return
     */
    int deleteEmployee(@Param("id") Integer id);

    /**
     * 修改员工信息
     * @param employee
     * @return
     */
    int updateEmployee(Employee employee);
}
