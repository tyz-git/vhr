package org.javaboy.vhr.mapper;

import org.javaboy.vhr.model.Department;
import org.javaboy.vhr.model.Politicsstatus;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-06-14 21:37
 **/
@Repository
public interface PoliticsStatusMapper {

    /**
     * 加载政治面貌列表
     * @return
     */
    List<Politicsstatus> getPoliticsStatus();
}
