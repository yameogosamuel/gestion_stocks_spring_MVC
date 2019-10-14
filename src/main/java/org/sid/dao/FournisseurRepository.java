package org.sid.dao;


import org.sid.entities.Fournisseur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long>{
	
	@Query(value="select * from Fournisseur fo where fo.nom like :x",nativeQuery = true)
	public Page<Fournisseur> chercherFo(@Param("x") String mc, Pageable pageable);
	

}
