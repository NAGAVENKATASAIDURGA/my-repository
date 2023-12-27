package com.platformenv.ProjEnv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.platformenv.ProjEnv.Entity.entity;

@Repository

public interface gitrepository extends JpaRepository<entity,Integer>{
	  @Query("SELECT r.repourl FROM entity r WHERE r.username = ?1")
	  
	    String findByusername( String username);
}
