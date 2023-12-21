package com.sonar.sonarqube.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sonar.sonarqube.entity.entity;

@Repository
public interface repository extends JpaRepository<entity, Integer>{

}
