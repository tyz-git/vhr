package org.javaboy.vhr.service.impl.system;

import org.javaboy.vhr.mapper.PositionMapper;
import org.javaboy.vhr.model.Position;
import org.javaboy.vhr.service.system.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-06-06 18:08
 **/
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    PositionMapper positionMapper;

    @Override
    public int deletePositions(Integer[] ids) {
        int result = positionMapper.deletePositions(ids);
        return result;
    }

    @Override
    public int deletePositionByPrimaryKey(Integer id) {
        int result = positionMapper.deletePositionByPrimaryKey(id);
        return result;
    }

    @Override
    public int updatePositionByPrimaryKeySelective(Position position) {
        int result = positionMapper.updatePositionByPrimaryKeySelective(position);
        return result;
    }

    @Override
    public int addPositionSelective(Position position) {
        int result = positionMapper.addPositionSelective(position);
        return result;
    }

    @Override
    public List<Position> getPositionList() {
        List<Position> positionList = positionMapper.getPositionList();
        return positionList;
    }
}
