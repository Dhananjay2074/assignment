package com.mc.demo.thirdService.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "USERS")
public class UserDesignationEntity implements Serializable {
	private static final long serialVersionUID = 4865903039190150223L;
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable = false)
	private String parentId;
	@Column(length = 50, nullable = false)
	private String name;
	@Column(length = 50, nullable = false)
	private String color;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	

}
