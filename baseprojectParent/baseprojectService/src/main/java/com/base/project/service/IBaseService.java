package com.base.project.service;

import com.base.project.model.Base;

public interface IBaseService {
	public void setBase(Base base);
	public Base getBaseById(Long id);
	public void deleteBase(Base base);
	public void deleteBase(Long id);
}
