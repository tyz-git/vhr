package org.javaboy.vhr.controller;

import org.javaboy.vhr.model.Hr;
import org.javaboy.vhr.model.Menu;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/system/config")
public class SystemConfigController {

    @Autowired
    MenuService menuService;


    @GetMapping(value = "/getMenuListByHrId")
    public RespBean getMenuListByHrId(){
        //((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()  --从SpringSecurity中获取用户id
        List<Menu> menuList = menuService.getMenuListByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        return RespBean.success(null, menuList);
    }
}
