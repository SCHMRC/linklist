package model;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Link extends RecursiveTreeObject<Link>{
	public StringProperty name;
	public StringProperty link;
	public StringProperty lenguage;
	/**
	 * @param name
	 * @param link
	 * @param lenguage
	 */
	public Link(String name, String link, String lenguage) {
		super();
		this.name = new SimpleStringProperty(name);
		this.link = new SimpleStringProperty(link);;
		this.lenguage = new SimpleStringProperty(lenguage);;
	}


}
