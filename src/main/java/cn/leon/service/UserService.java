package cn.leon.service;

import cn.leon.dao.UserDao;
import cn.leon.model.UserEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService{

	@Resource
	private UserDao userDao;
	
	public void insert(UserEntity userEntity) {
		userDao.insert(userEntity);
	}

	public void del(UserEntity userEntity) {
		userDao.del(userEntity);
	}

	public UserEntity getUserEntityByLoginName(String loginName) {
		return userDao.getUserEntityByLoginName(loginName);
	}

	public List<UserEntity> usersList(String loginName, int pageSize, int start) {
		return userDao.usersList( loginName,  pageSize,  start);
	}

	public Integer usersSize(String loginName, int pageSize, int start) {
		return userDao.usersSize(loginName, pageSize, start);
	}

	public void insertUser(UserEntity userEntity) {
		/*String password = null;
		try {
			password = MD5Util.encrypt(userEntity.getPassword());
			userEntity.setPassword(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}*/
		//userEntity.setPassword(new Md5PasswordEncoder().encodePassword(userEntity.getPassword(), null));
		userEntity.setPassword("{bcrypt}"+new BCryptPasswordEncoder().encode(userEntity.getPassword()));
		userDao.insertUser(userEntity);
	}

	public void updateUser(UserEntity userEntity) {
		//userEntity.setPassword(new Md5PasswordEncoder().encodePassword(userEntity.getPassword(), null));
		userEntity.setPassword("{bcrypt}"+new BCryptPasswordEncoder().encode(userEntity.getPassword()));
		userDao.updateUser(userEntity);
	}

	public void deleteUsers(List<String> groupId) {
		userDao.deleteUsers(groupId);
	}

}
