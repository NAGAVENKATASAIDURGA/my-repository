package com.platform.git.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.platform.git.Entity.entity;



@Repository
public interface repository extends JpaRepository<entity,Integer>{
	/*
	 * @Transactional
	 * 
	 * @Modifying
	 * 
	 * @Query(value =
	 * "DELETE FROM gitlab e WHERE e.jsonbColumn ->> 'name' = :paramValue") void
	 * deleteByJsonbParameter(@Param("paramValue") String paramValue);
	 */
	//@Transactional
    //@Modifying
	
	  @Query("SELECT r.repourl FROM entity r WHERE r.reponame = ?1")
	  
	    String findByreponame( String reponame);
	 
}
