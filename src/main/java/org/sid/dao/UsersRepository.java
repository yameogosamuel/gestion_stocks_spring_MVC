package org.sid.dao;


import java.util.List;

import org.sid.entities.Login;
import org.sid.entities.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends JpaRepository<Users, Long>{
	
	@Query(value="select * from Users u where u.nom like :x",nativeQuery = true)
	public Page<Users> chercherU(@Param("x") String mc, Pageable pageable);
	
	@Query(value="select distinct u.login from Users",nativeQuery = true)
	public List<Login> getLogins();
	

}
