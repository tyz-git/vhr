package org.javaboy.vhr.service.impl;

import org.javaboy.vhr.mapper.MenuMapper;
import org.javaboy.vhr.model.Menu;
import org.javaboy.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> getMenuListByHrId(Integer userId) {
        List<Menu> menuList = menuMapper.getMenuListByHrId(userId);
        return menuList;
    }

    @Override
    public List<Menu> getMenuList() {
        List<Menu> menuList = menuMapper.getMenuList();
        return menuList;
    }

    @Override
    public List<Menu> getMenuListWithRole() {
        List<Menu> menuListWithRole = menuMapper.getMenuListWithRole();
        return menuListWithRole;
    }
}
