package com.platformengneering.nexus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platformengneering.nexus.entity.entity;

@Repository
public interface repository extends JpaRepository<entity, Integer>{

}
