package org.javaboy.vhr.service.impl;

import org.javaboy.vhr.mapper.RoleMapper;
import org.javaboy.vhr.model.Role;
import org.javaboy.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-06-13 18:59
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public int deleteRole(Integer id) {
        int result = roleMapper.deleteRole(id);
        return result;
    }

    @Override
    public int addRole(Role role) {
        int result = roleMapper.addRole(role);
        return result;
    }

    @Override
    public List<Role> getRoleList() {
        List<Role> roleList = roleMapper.getRoleList();
        return roleList;
    }
}
