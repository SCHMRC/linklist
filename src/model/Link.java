package model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

public class Link extends RecursiveTreeObject<Link>{
	private String name;
	private String link;
	private String lenguage;
	/**
	 * @param name
	 * @param link
	 * @param lenguage
	 */
	public Link(String name, String link, String lenguage) {
		super();
		this.name = name;
		this.link = link;
		this.lenguage = lenguage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getLenguage() {
		return lenguage;
	}
	public void setLenguage(String lenguage) {
		this.lenguage = lenguage;
	}

}
