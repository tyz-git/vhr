package org.javaboy.vhr.controller.system;

import org.javaboy.vhr.model.Department;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.system.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @author: TongYaZhou
 * @create: 2020-06-14 21:36
 **/
@RestController
@RequestMapping(value = "/system/basic/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping(value = "/")
    public RespBean getDepartmentList() {
        List<Department> departmentList = departmentService.getDepartmentList();
        if (!Objects.isNull(departmentList)){
            return RespBean.success("获取部门列表成功",departmentList, "false");
        }
        return RespBean.error("获取部门列表失败");
    }
}
