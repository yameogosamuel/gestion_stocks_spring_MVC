package org.sid.dao;



import org.sid.entities.Sorties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SortiesRepository extends JpaRepository<Sorties, Long>{
	
	@Query(value="select * from Sorties s where s.desi like :x",nativeQuery = true)
	public Page<Sorties> chercherS(@Param("x") String mc, Pageable pageable);
	

}
