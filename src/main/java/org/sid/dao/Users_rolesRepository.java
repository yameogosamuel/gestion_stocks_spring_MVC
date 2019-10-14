package org.sid.dao;

import org.sid.entities.Users_roles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Users_rolesRepository extends JpaRepository<Users_roles, Long>{
	
	@Query(value="select * from Users_roles ur where ur.login like :x",nativeQuery = true)
	public Page<Users_roles> chercherUr(@Param("x") String mc, Pageable pageable);
	

}
