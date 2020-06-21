package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-06-14 21:37
 **/
@Repository
public interface DepartmentMapper {

    /**
     * 获取部门列表
     * @param id
     * @return
     */
    List<Department> getDepartmentList(int id);

    /**
     * 添加部门
     * @param department
     */
    void addDepartment(Department department);

    /**
     * 删除部门
     * @param department
     * @return
     */
    void deleteDepartment(Department department);
}
