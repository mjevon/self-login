package cn.leon.service;

import cn.leon.dao.RelationDao;
import cn.leon.model.RelationEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RelationService{

	@Resource
	private RelationDao relationDao;

	
	public List<RelationEntity> getRelationByUserId(int userId) {
		return relationDao.getRelationByUserId(userId);
	}

	@Transactional
	public void insertRelations(List<RelationEntity> relationList) {
		relationDao.delById(relationList.get(0).getUserId());
		if (relationList.get(0).getRoleId() != null) {
			relationDao.insertRelations(relationList);
		}
	}

}
