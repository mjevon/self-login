package cn.leon.service.Impl;

import cn.leon.entity.MenuEntity;
import cn.leon.repository.MenuRepository;
import cn.leon.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private static final Logger _LOGGER = LoggerFactory.getLogger(MenuService.class);

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<MenuEntity> menuList(int id) {
        return null;
    }

    @Override
    public List<MenuEntity> menusList(int pageSize, int start, String menuId) {
        return null;
    }

    @Override
    public Integer menusSize(int pageSize, int start, String menuId) {
        return null;
    }

    @Override
    public void insertMenu(MenuEntity menuEntity) {
        menuRepository.insertMenu(menuEntity);
    }

    @Override
    public void updateMenu(MenuEntity menuEntity) {
        menuRepository.updateMenu(menuEntity);
    }

    @Override
    public void deleteMenus(List<String> groupId) {

    }

    @Override
    public List<MenuEntity> menusByParentId(int parentId) {
        return null;
    }

    @Override
    public List<MenuEntity> getSubmenus() {
        return null;
    }
}