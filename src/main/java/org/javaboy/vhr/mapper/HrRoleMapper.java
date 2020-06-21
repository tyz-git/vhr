package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author: TongYaZhou
 * @create: 2020-06-21 21:52
 **/
@Repository
public interface HrRoleMapper {

    /**
     * 把用户拥有的角色全部删除
     * @param hrid
     * @return
     */
    int deleteRolesByHrId(Integer hrid);

    /**
     * 把此次操作选中的角色都添加到当前用户下
     * @param hrid
     * @param rids
     * @return
     */
    int insertRolesByHrId(@Param("hrid") Integer hrid, @Param("rids") Integer[] rids);
}
