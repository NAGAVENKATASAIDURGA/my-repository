package com.platformenv.ProjEnv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.platformenv.ProjEnv.Entity.sonarentity;

@Repository
public interface sonarrepository extends JpaRepository<sonarentity, Integer>{
	 @Query("SELECT r.projname FROM sonarentity r WHERE r.username = ?1")
	  
	    String findByusername( String username);
}
