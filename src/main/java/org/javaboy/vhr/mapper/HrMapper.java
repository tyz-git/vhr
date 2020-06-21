package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Hr;
import org.javaboy.vhr.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    /**
     * springSecurity登录方法
     * @param username
     * @return
     */
    Hr loadUserByUsername(String username);

    List<Role> getRoleListByHrId(Integer id);

    /**
     * 获取操作员列表
     * @param id
     * @return
     */
    List<Hr> getHrList(@Param("id") Integer id, @Param("hrName") String hrName);

    /**
     * 更新操作员
     * @param hr
     * @return
     */
    int updateHr(Hr hr);

    /**
     * 删除操作员
     * @param id
     * @return
     */
    int deleteHr(Integer id);
}