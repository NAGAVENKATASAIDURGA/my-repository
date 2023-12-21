package com.sonar.sonarqube.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.json.simple.JSONObject;
import org.springframework.util.MultiValueMap;

@Entity
@Table(name="sonar")
public class entity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
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
public void setJsonField(MultiValueMap<String, String> formData) {
	this.jsonField = (JSONObject) formData;
}

}
