package org.javaboy.vhr.service.system;

import org.javaboy.vhr.model.Menu;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-06-14 13:34
 **/
public interface RoleMenuService {

    /**
     * 根据角色id获取当前角色可操作性的菜单
     * @param rid
     * @return
     */
    List<Integer> getSelectMenuListByRid(Integer rid);

    /**
     * 根据角色id修改当前角色可操控的菜单项
     * @param rid
     * @param mids
     * @return
     */
    int updateMenuListByRoleId(Integer rid, Integer[] mids);

}
