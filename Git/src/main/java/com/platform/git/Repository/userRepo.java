package com.platform.git.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.platform.git.Entity.users;
@Repository
public interface userRepo extends JpaRepository<users, Integer>{

}
