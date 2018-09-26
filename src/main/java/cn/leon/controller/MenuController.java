package cn.leon.controller;

import cn.leon.model.MenuEntity;
import cn.leon.model.PageResult;
import cn.leon.model.UserEntity;
import cn.leon.service.MenuService;
import cn.leon.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MenuController {

	private Logger log = LoggerFactory.getLogger(MenuController.class);

	@Resource
	private MenuService menuService;

	@Resource
	private UserService userService;

	/**
	 * 获取该用户的菜单权限
	 * 
	 * @param loginName
	 * @return
	 */
	@GetMapping("/menu/{loginName}")
	public List<MenuEntity> menuList(@PathVariable String loginName) {
		UserEntity userEntity = userService.getUserEntityByLoginName(loginName);
		List<MenuEntity> menuList = menuService.menuList(userEntity.getId());
		return menuList;
	}

	/**
	 * 获取menus表数据
	 * 
	 * @param pageSize
	 * @param page
	 * @return
	 */
	@GetMapping("/menus")
	public PageResult menusList(int pageSize, int page, String menuId) {
		PageResult pageResult = new PageResult();
		pageResult.setData(menuService.menusList(pageSize, page * pageSize, menuId));
		pageResult.setTotalCount(menuService.menusSize(pageSize, page * pageSize, menuId));
		log.debug("The method is ending");
		return pageResult;
	}

	/**
	 * 通过parentId得到menus列表
	 * 
	 * @param parentId
	 * @return
	 */
	@GetMapping("/menus/parentId")
	public List<MenuEntity> menusByParentId(int parentId) {
		return menuService.menusByParentId(parentId);
	}

	/**
	 * 新建菜单信息
	 * 
	 * @param menuEntity
	 * @return
	 */
	@PostMapping("/menus/menu")
	public MenuEntity insertMenu(@RequestBody MenuEntity menuEntity) {
		menuService.insertMenu(menuEntity);
		log.debug("The method is ending");
		return menuEntity;
	}

	/**
	 * 修改菜单信息
	 * 
	 * @param menuEntity
	 * @param id
	 * @return
	 */
	@PutMapping("/menus/{id}")
	public MenuEntity updateMenu(@RequestBody MenuEntity menuEntity, @PathVariable int id) {
		if (menuEntity.getId() == id) {
			menuService.updateMenu(menuEntity);
		}
		log.debug("The method is ending");
		return menuEntity;
	}

	/**
	 * 删除菜单信息
	 * 
	 * @param groupId
	 * @return
	 */
	@DeleteMapping("/menus")
	public List<String> deleteMenus(@RequestBody List<String> groupId) {
		menuService.deleteMenus(groupId);
		return groupId;
	}

	/**
	 * 获取二级菜单
	 * @return
	 */
	@GetMapping("/menus/submenus")
	public List<MenuEntity> getSubmenus() {
		return menuService.getSubmenus();
	}
}
