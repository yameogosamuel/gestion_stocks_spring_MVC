package org.sid.dao;





import org.sid.entities.Usages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsagesRepository extends JpaRepository<Usages, Long>{
	
	@Query(value="select * from Usages usa where usa.nom like :x",nativeQuery = true)
	public Page<Usages> chercherUs(@Param("x") String mc, Pageable pageable);
	

}
