package org.sid.dao;




import org.sid.entities.Famille;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FamilleRepository extends JpaRepository<Famille, Long>{
	
	@Query(value="select * from Famille fa where fa.nom like :x",nativeQuery = true)
	public Page<Famille> chercherF(@Param("x") String mc, Pageable pageable);
	

}
