package org.javaboy.vhr.service.system;

import org.javaboy.vhr.model.Position;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-06-06 18:07
 **/
public interface PositionService {

    List<Position> getPositionList();

    int addPositionSelective(Position position);

    int updatePositionByPrimaryKeySelective(Position position);

    int deletePositionByPrimaryKey(Integer id);

    int deletePositions(Integer[] ids);
}
