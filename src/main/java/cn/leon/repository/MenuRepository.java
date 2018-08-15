package cn.leon.repository;

import cn.leon.entity.MenuEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository{

    /**
     * 通过用户Id得到一级菜单List
     *
     * @param id
     * @return
     */
    List<MenuEntity> getParentMenuListById(@Param("ids") String[] ids);

    List<MenuEntity> getMenuListById(@Param("ids") String[] ids);

    /**
     * 获取menus列表
     *
     * @param pageSize
     * @param start
     * @param menuId
     * @return
     */
    List<MenuEntity> menusList(@Param("pageSize") int pageSize, @Param("start") int start,
                                      @Param("menuId") String menuId);

    /**
     * 获取menus列表的总量
     *
     * @param pageSize
     * @param start
     * @param menuId
     * @return
     */
    Integer menusSize(@Param("pageSize") int pageSize, @Param("start") int start,
                             @Param("menuId") String menuId);

    /**
     * 新建菜单信息
     *
     * @param menuEntity
     */
    void insertMenu(@Param("menuEntity") MenuEntity menuEntity);

    /**
     * 修改菜单信息
     *
     * @param menuEntity
     */
    void updateMenu(@Param("menuEntity") MenuEntity menuEntity);

    /**
     * 删除菜单信息
     *
     * @param groupId
     */
    void deleteMenus(@Param("groupId") List<String> groupId);

    /**
     * 通过parentId得到menus列表
     *
     * @param parentId
     * @return
     */
    List<MenuEntity> menusByParentId(@Param("parentId") int parentId);

    /**
     * 获取二级菜单
     * @return
     */
    List<MenuEntity> getSubmenus();
}