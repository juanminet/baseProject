package com.base.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.project.dao.IBaseDao;
import com.base.project.model.Base;

@Service("baseService")
public class BaseServiceImpl implements IBaseService {
	
	@Autowired
	IBaseDao baseDao;

	public void setBase(Base base) {
		baseDao.setBase(base);
	}

	public Base getBaseById(Long id) {
		return baseDao.getBaseById(id);
	}

	public void deleteBase(Base base) {
		baseDao.deleteBase(base);
	}

	public void deleteBase(Long id) {
		baseDao.deleteBase(id);
	}

}
