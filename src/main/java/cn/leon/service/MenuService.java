package cn.leon.service;

import cn.leon.dao.MenuDao;
import cn.leon.dao.RoleDao;
import cn.leon.model.MenuEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    @Resource
    private MenuDao menuDao;

    @Resource
    private RoleDao roleDao;

    public List<MenuEntity> menuList(Integer id) {
        List<String> idList = roleDao.getModulesById(id);

        String idstemp = "";
        for (String idtemp : idList) {
            idstemp = idstemp + idtemp;
        }
        String[] ids = idstemp.split(";");
        List<MenuEntity> parentMenuList = menuDao.getParentMenuListById(ids);
        List<MenuEntity> childrenMenuList = menuDao.getMenuListById(ids);
        List<MenuEntity> menuList = new ArrayList<MenuEntity>();

        for (MenuEntity parentMenu : parentMenuList) {
            List<MenuEntity> menuListTemp = new ArrayList<MenuEntity>();
            for (MenuEntity childrenMenu : childrenMenuList) {
                if (parentMenu.getId() == childrenMenu.getParentId()) {
                    menuListTemp.add(childrenMenu);
                }
            }
            parentMenu.setChildren(menuListTemp);
            menuList.add(parentMenu);
        }

        return menuList;
    }

    public List<MenuEntity> menusList(int pageSize, int start, String menuId) {
        return menuDao.menusList(pageSize, start, menuId);
    }

    public Integer menusSize(int pageSize, int start, String menuId) {
        return menuDao.menusSize(pageSize, start, menuId);
    }

    public void insertMenu(MenuEntity menuEntity) {
        menuDao.insertMenu(menuEntity);
    }

    public void updateMenu(MenuEntity menuEntity) {
        menuDao.updateMenu(menuEntity);
    }

    public void deleteMenus(List<String> groupId) {
        menuDao.deleteMenus(groupId);
    }

    public List<MenuEntity> menusByParentId(int parentId) {
        return menuDao.menusByParentId(parentId);
    }

    public List<MenuEntity> getSubmenus() {
        return menuDao.getSubmenus();
    }

}
