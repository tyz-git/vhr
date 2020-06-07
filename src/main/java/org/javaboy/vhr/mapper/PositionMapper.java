package org.javaboy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.Position;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-06-06 18:09
 **/
@Repository
public interface PositionMapper {


    List<Position> getPositionList();

    int addPositionSelective(Position position);

    int updatePositionByPrimaryKeySelective(Position position);

    int deletePositionByPrimaryKey(Integer id);

    int deletePositions(@Param("ids") Integer[] ids);
}
