package org.javaboy.vhr.service.system;

import org.javaboy.vhr.model.Department;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-06-14 21:37
 **/
public interface DepartmentService {

    /**
     * 获取部门列表
     * @return
     */
    List<Department> getDepartmentList();

}
