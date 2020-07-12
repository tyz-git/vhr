package org.javaboy.vhr.service.impl.emp;

import org.javaboy.vhr.mapper.NationMapper;
import org.javaboy.vhr.model.Nation;
import org.javaboy.vhr.service.emp.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-07-12 13:51
 **/
@Service
public class NationServiceImpl implements NationService {

    @Autowired
    NationMapper nationMapper;

    @Override
    public List<Nation> getNations() {
        List<Nation> nations = nationMapper.getNations();
        return nations;
    }
}
