package org.javaboy.vhr.service.emp;

import org.javaboy.vhr.model.Nation;

import java.util.List;

/**
 * @author: TongYaZhou
 * @create: 2020-07-12 13:51
 **/
public interface NationService {

    /**
     * 加载民族列表
     * @return
     */
    List<Nation> getNations();

}
