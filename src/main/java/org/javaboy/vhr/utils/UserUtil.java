package org.javaboy.vhr.utils;

import org.javaboy.vhr.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author: TongYaZhou
 * @create: 2020-06-21 11:33
 **/
public class UserUtil {

    public static Hr getUser(){
        Hr hr = (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return hr;
    }
}
