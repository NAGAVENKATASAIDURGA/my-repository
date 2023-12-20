package com.platform.git.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.json.simple.JSONObject;

@Entity
@Table(name="gitlab")
public class entity {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
@Type(type = "jsonb")
@Column(columnDefinition = "jsonb")
private JSONObject jsonField;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public JSONObject getJsonField() {
	return jsonField;
}
public void setJsonField(JSONObject jsonObj) {
	this.jsonField = jsonObj;
}

}
