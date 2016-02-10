package com.base.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
	@NamedQuery(name="findAllBases",
				query="SELECT b FROM Base b")
})
public class Base implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8677266390971873511L;

	@Id
	@GeneratedValue
	private Long id;	
	
	private String value;	
	
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
