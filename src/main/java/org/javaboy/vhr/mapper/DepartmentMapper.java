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


    List<Department> getDepartmentList(int id);
}
