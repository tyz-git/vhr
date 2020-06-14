package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-06-14 13:35
 **/
@Repository
public interface RoleMenuMapper {

    /**
     * 根据角色id获取当前角色可操作的菜单
     * @param rid
     * @return
     */
    List<Integer> getSelectMenuListByRid(Integer rid);

    /**
     * 根据当前角色id，修改当前角色可操作的菜单项
     * (第一步)：首先删除当前角色下的所有菜单项
     * @param rid
     */
    int deleteMenuByRoleId(Integer rid);

    /**
     * 根据当前角色id，修改当前角色可操作的菜单项
     * (第二步)：把用户此次选的菜单项都添加到该角色下
     * @param rid
     */
    int insertMenuByRoleId(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
