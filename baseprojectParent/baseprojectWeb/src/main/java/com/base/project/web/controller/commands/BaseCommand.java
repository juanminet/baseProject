package com.base.project.web.controller.commands;

import java.io.Serializable;

public class BaseCommand  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3035794499489104901L;
	Long idBase;
	String value;
	String description;
	public Long getIdBase() {
		return idBase;
	}
	public void setIdBase(Long idBase) {
		this.idBase = idBase;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
