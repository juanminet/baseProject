package com.base.project.dao;

import java.util.List;

import com.base.project.model.Base;

public interface IBaseDao {
	
	public void setBase(Base base);
	public Base getBaseById(Long id);
	public void deleteBase(Base base);
	public void deleteBase(Long id);
	
	public List<Base> getAllBases();

}
