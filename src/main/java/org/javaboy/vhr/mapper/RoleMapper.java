package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-06-13 19:00
 **/
@Repository
public interface RoleMapper {


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
