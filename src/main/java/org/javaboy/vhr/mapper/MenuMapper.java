package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {

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
