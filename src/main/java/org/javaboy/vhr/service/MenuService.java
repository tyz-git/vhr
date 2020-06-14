package org.javaboy.vhr.service;

import org.javaboy.vhr.model.Menu;
import java.util.List;

public interface MenuService {

    /**
     * 根据用户id获取对应的菜单列表
     * @param userId 用户id
     * @return
     */
    List<Menu> getMenuListByHrId(Integer userId);

    /**
     * 获取每个菜单都需要哪些角色才可以访问
     * @return
     */
    List<Menu> getMenuListWithRole();

    /**
     * 获取菜单列表
     * @return
     */
    List<Menu> getMenuList();

}
