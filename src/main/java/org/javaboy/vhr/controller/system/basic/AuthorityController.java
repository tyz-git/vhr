package org.javaboy.vhr.controller.system.basic;

import org.javaboy.vhr.model.Menu;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.Role;
import org.javaboy.vhr.service.MenuService;
import org.javaboy.vhr.service.RoleService;
import org.javaboy.vhr.service.system.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author: TongYaZhou
 * @create: 2020-06-13 18:56
 **/
@RestController
@RequestMapping(value = "/system/basic/Authority")
public class AuthorityController {

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;

    @Autowired
    RoleMenuService roleMenuService;

    @GetMapping(value = "/")
    public RespBean getRoleListRe(){
        List<Role> roleList = roleService.getRoleList();
        if (!Objects.isNull(roleList)) {
            return RespBean.success("获取角色列表成功", roleList, "false");
        }
        return RespBean.error("获取角色列表失败");
    }

    @GetMapping(value = "/menus")
    public RespBean getMenuList() {
        List<Menu> menuList = menuService.getMenuList();
        if (!Objects.isNull(menuList)) {
            return RespBean.success("获取菜单列表成功", menuList, "false");
        }
        return RespBean.error("获取菜单列表失败");
    }

    @GetMapping(value = "/selectMenus/{rid}")
    public RespBean getSelectMenuListByRid(@PathVariable("rid") Integer rid) {
        List<Integer> selectMenuList = roleMenuService.getSelectMenuListByRid(rid);
        if (!Objects.isNull(selectMenuList)) {
            return RespBean.success("获取被选中菜单列表成功", selectMenuList, "false");
        }
        return RespBean.error("获取被选中菜单列表失败");
    }

    @PutMapping(value = "/")
    public RespBean updateMenuListByRoleId(Integer rid, Integer[] mids) {
        int result = roleMenuService.updateMenuListByRoleId(rid, mids);
        if ((!Objects.isNull(mids) && result == mids.length) || result > 0) {
            return RespBean.success("修改菜单项成功");
        }
        return RespBean.error("修改菜单项失败");
    }

    @PostMapping(value = "/")
    public RespBean addRole(@RequestBody Role role) {
        if (!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_" + role.getName());
        }
        int result = roleService.addRole(role);
        if (result > 0) {
            return RespBean.success("添加角色成功");
        }
        return RespBean.error("添加角色失败");
    }

    @DeleteMapping(value = "/{id}")
    public RespBean deleteRole(@PathVariable("id") Integer id) {
        int result = roleService.deleteRole(id);
        if (result > 0){
            return RespBean.success("删除角色成功");
        }
        return RespBean.error("删除角色失败");
    }

}
