package com.base.project.dao;

import com.base.project.model.Base;

public interface IBaseDao {
	
	public void setBase(Base base);
	public Base getBaseById(Long id);
	public void deleteBase(Base base);
	public void deleteBase(Long id);

}
