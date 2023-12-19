package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entity.entity;

@Repository
public interface repository extends JpaRepository<entity,Integer>{

}
