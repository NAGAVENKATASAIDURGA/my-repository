package com.platformenv.ProjEnv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platformenv.ProjEnv.Entity.nexususers;
@Repository
public interface nexususerrepository extends JpaRepository<nexususers, Integer>{

}
