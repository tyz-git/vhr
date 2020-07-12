package org.javaboy.vhr.service.emp;

import org.javaboy.vhr.model.Politicsstatus;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-07-12 13:40
 **/
public interface PoliticsStatusService {
    /**
     * 加载政治面貌列表
     * @return
     */
    List<Politicsstatus> getPoliticsStatus();

}
