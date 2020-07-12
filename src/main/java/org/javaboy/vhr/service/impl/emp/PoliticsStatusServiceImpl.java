package org.javaboy.vhr.service.impl.emp;

import org.javaboy.vhr.mapper.PoliticsStatusMapper;
import org.javaboy.vhr.model.Politicsstatus;
import org.javaboy.vhr.service.emp.PoliticsStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-07-12 13:41
 **/
@Service
public class PoliticsStatusServiceImpl implements PoliticsStatusService {

    @Autowired
    PoliticsStatusMapper politicsStatusMapper;

    @Override
    public List<Politicsstatus> getPoliticsStatus() {
        List<Politicsstatus> politicsstatuses = politicsStatusMapper.getPoliticsStatus();
        return politicsstatuses;
    }
}
