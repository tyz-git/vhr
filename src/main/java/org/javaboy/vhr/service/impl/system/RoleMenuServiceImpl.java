package org.javaboy.vhr.service.impl.system;

import org.javaboy.vhr.mapper.RoleMenuMapper;
import org.javaboy.vhr.model.Menu;
import org.javaboy.vhr.service.system.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author: TongYaZhou
 * @create: 2020-06-14 13:35
 **/
@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Autowired
    RoleMenuMapper roleMenuMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateMenuListByRoleId(Integer rid, Integer[] mids) {
        int result = 0;
        result = roleMenuMapper.deleteMenuByRoleId(rid);
        if (!Objects.isNull(mids)){
            result = roleMenuMapper.insertMenuByRoleId(rid, mids);
        }
        return result;
    }

    @Override
    public List<Integer> getSelectMenuListByRid(Integer rid) {
        List<Integer> integerList = roleMenuMapper.getSelectMenuListByRid(rid);
        return integerList;
    }
}
