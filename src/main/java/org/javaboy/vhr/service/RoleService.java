package org.javaboy.vhr.service;

import org.javaboy.vhr.model.Role;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-06-13 18:59
 **/
public interface RoleService {

    /**
     * 获取角色列表
     * @return
     */
    List<Role> getRoleList();

    /**
     * 添加角色
     * @param role
     * @return
     */
    int addRole(Role role);

    /**
     * 删除角色
     * @param id
     * @return
     */
    int deleteRole(Integer id);
}
