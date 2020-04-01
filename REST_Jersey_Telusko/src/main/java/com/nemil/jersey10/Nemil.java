package com.nemil.jersey10;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Nemil 
{
	private String name;
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Nemil [name=" + name + ", id=" + id + "]";
	}
	
}
