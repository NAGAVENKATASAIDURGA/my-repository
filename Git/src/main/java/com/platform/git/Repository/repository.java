package com.platform.git.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platform.git.Entity.entity;



@Repository
public interface repository extends JpaRepository<entity,Integer>{

}
