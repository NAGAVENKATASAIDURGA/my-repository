package com.platformenv.ProjEnv.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nexususers")
public class nexususers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
private String uid;
private String email;
private String password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}



public String getUid() {
	return uid;
}
public void setUid(String uid) {
	this.uid = uid;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
