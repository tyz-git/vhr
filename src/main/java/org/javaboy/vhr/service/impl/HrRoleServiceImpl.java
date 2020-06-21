package org.javaboy.vhr.service.impl;

import org.javaboy.vhr.mapper.HrRoleMapper;
import org.javaboy.vhr.service.HrRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: TongYaZhou
 * @create: 2020-06-21 21:51
 **/
@Service
public class HrRoleServiceImpl implements HrRoleService {

    @Autowired
    HrRoleMapper hrRoleMapper;

    @Override
    public int updateHrRoles(Integer hrid, Integer[] rids) {
        int result = 0;
        result = hrRoleMapper.deleteRolesByHrId(hrid);
        result = hrRoleMapper.insertRolesByHrId(hrid, rids);
        return result;
    }
}
