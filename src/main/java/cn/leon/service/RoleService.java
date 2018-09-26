package cn.leon.service;

import cn.leon.dao.RoleDao;
import cn.leon.model.RoleEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService{

	@Resource
	private RoleDao roleDao;

	public List<RoleEntity> rolesList(int pageSize, int start) {
		return roleDao.rolesList(pageSize, start);
	}

	public Integer rolesSize(int pageSize, int start) {
		return roleDao.rolesSize(pageSize, start);
	}

	public void insertRole(RoleEntity roleEntity) {
		roleDao.insertRole(roleEntity);
	}

	public void updateRole(RoleEntity roleEntity) {
		roleDao.updateRole(roleEntity);
	}

	public void deleteRoles(List<String> groupId) {
		roleDao.deleteRoles(groupId);
	}

	public List<RoleEntity> allRoles() {
		return roleDao.allRoles();
	}

}
