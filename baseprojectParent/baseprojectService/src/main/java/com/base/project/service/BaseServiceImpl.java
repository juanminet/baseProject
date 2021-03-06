package com.base.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.base.project.dao.IBaseDao;
import com.base.project.model.Base;

@Service("baseService")
public class BaseServiceImpl implements IBaseService {
	
	@Autowired
	IBaseDao baseDao;

	@Transactional
	public void setBase(Base base) {
		baseDao.setBase(base);
	}

	@Transactional
	public Base getBaseById(Long id) {
		return baseDao.getBaseById(id);
	}

	@Transactional
	public void deleteBase(Base base) {
		baseDao.deleteBase(base);
	}

	@Transactional
	public void deleteBase(Long id) {
		baseDao.deleteBase(id);
	}

	@Transactional
	public List<Base> getAllBases() {
		return baseDao.getAllBases();
	}

}
