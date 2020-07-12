package org.javaboy.vhr.service.impl.system;

import org.javaboy.vhr.mapper.DepartmentMapper;
import org.javaboy.vhr.model.Department;
import org.javaboy.vhr.service.system.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-06-14 21:37
 **/
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public void deleteDepartment(Department department) {
        departmentMapper.deleteDepartment(department);
    }

    @Override
    public void addDepartment(Department department) {
        department.setEnabled(true);
        departmentMapper.addDepartment(department);
    }

    @Override
    public List<Department> getDepartmentList() {
        List<Department> departmentList = departmentMapper.getDepartmentList(-1);
        return departmentList;
    }
}
