package org.javaboy.vhr.controller.system.basic;

import org.javaboy.vhr.model.Department;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.system.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 新增部门分为以下几个步骤：
     * 1、插入新增的部门名称和parentId(需要知道这个部门属于哪个部门),插入成功后返回自增的id
     * 2、根据此条数据的parentId找到父部门数据中的depPath
     * 3、把当前数据的depPath更新为(父部门depPath+当前数据的id)，并把父部门的isParent设置为true
     * @param department
     * @return
     */
    @PostMapping(value = "/")
    public RespBean addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
        if (department.getResult() == 1){
            System.out.println(department.getId());
            return RespBean.success("添加部门成功", department);
        }
        return RespBean.error("添加部门失败");
    }

    @DeleteMapping(value = "/{id}")
    public RespBean deleteDepartment(@PathVariable("id") Integer id){
        Department department = new Department();
        department.setId(id);
        departmentService.deleteDepartment(department);
        if (department.getResult() == -2){
            return RespBean.error("该部门下有子部门");
        }else if (department.getResult() == -1){
            return RespBean.error("该部门下有员工");
        }else if (department.getResult() == 1){
            return RespBean.success("删除部门成功", id);
        }
        return RespBean.error("删除部门失败");
    }
}
