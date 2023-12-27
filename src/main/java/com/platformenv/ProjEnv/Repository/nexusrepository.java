package com.platformenv.ProjEnv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.platformenv.ProjEnv.Entity.nexusentity;
@Repository
public interface nexusrepository extends JpaRepository<nexusentity, Integer>{
	  @Query("SELECT r.reponame FROM nexusentity r WHERE r.username = ?1")
	  
	    String findByusername( String username);
}
