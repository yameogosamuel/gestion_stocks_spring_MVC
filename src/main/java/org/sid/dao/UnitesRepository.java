package org.sid.dao;





import org.sid.entities.Unites;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UnitesRepository extends JpaRepository<Unites, Long>{
	
	@Query(value="select * from Unites uni where uni.nom like :x",nativeQuery = true)
	public Page<Unites> chercherUn(@Param("x") String mc, Pageable pageable);
	

}
