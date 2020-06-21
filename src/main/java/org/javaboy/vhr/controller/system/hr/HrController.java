package org.javaboy.vhr.controller.system.hr;

import org.javaboy.vhr.model.Hr;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.Role;
import org.javaboy.vhr.service.HrRoleService;
import org.javaboy.vhr.service.HrService;
import org.javaboy.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author: TongYaZhou
 * @create: 2020-06-21 11:28
 **/
@RestController
@RequestMapping(value = "/system/hr")
public class HrController {

    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;
    @Autowired
    HrRoleService hrRoleService;

    @GetMapping(value = "/")
    public RespBean getHrList(String hrName){
        List<Hr> hrList = hrService.getHrList(hrName);
        if (!Objects.isNull(hrList)){
            return RespBean.success("获取操作员列表成功",hrList, "false");
        }
        return RespBean.error("获取操作员列表失败");
    }

    @PutMapping(value = "/")
    public RespBean updateHr(@RequestBody Hr hr){
        int result = hrService.updateHr(hr);
        if (result > 0){
            return RespBean.success("更新操作员成功");
        }
        return RespBean.error("更新操作员你失败");
    }

    @GetMapping(value = "/getRoles")
    public RespBean getRoles(){
        List<Role> roleList = roleService.getRoleList();
        if (!Objects.isNull(roleList)){
            return RespBean.success("获取角色列表成功",roleList, "false");
        }
        return RespBean.error("获取角色列表失败");
    }

    @PutMapping("/updateHrRoles")
    public RespBean updateHrRoles(Integer hrid, Integer[] rids){
        int result = hrRoleService.updateHrRoles(hrid,rids);
        if (result > 0){
            return RespBean.success("更新角色成功");
        }
        return RespBean.error("更新角色失败");
    }

    @DeleteMapping(value = "deleteHr/{id}")
    public RespBean deleteHr(@PathVariable("id") Integer id){
        int result = hrService.deleteHr(id);
        if (result > 0){
            return RespBean.success("删除用户成功");
        }
        return RespBean.error("删除用户失败");
    }
}
