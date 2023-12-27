package com.platformenv.ProjEnv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platformenv.ProjEnv.Entity.sonarusers;

@Repository
public interface sonaruserrepository extends JpaRepository<sonarusers, Integer>{

}
