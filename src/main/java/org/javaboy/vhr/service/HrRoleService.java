package org.javaboy.vhr.service;

/**
 * @author: TongYaZhou
 * @create: 2020-06-21 21:51
 **/
public interface HrRoleService {

    /**
     * 更新角色
     * @param hrid
     * @param rids
     * @return
     */
    int updateHrRoles(Integer hrid, Integer[] rids);
}
