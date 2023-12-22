package com.platform.git.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="gitlab")
public class entity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

	/*
	 * @Type(type = "jsonb")
	 * @Column(columnDefinition = "jsonb") private JSONObject jsonField;
	 */
private String reponame;
private String type;
private String repourl;
String username;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getReponame() {
	return reponame;
}
public void setReponame(String reponame) {
	this.reponame = reponame;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getRepourl() {
	return repourl;
}
public void setRepourl(String repourl) {
	this.repourl = repourl;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

 

}
