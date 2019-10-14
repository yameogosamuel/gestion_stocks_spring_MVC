package org.sid.dao;

import java.util.Date;

import org.sid.entities.Entrees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EntreesRepository extends JpaRepository<Entrees, Long>{
	
	@Query(value="select * from entrees e where e.desi like :x",nativeQuery = true)
	public Page<Entrees> chercherE(@Param("x") String mc, Pageable pageable);
	
	@Modifying
	@Query(value="update entrees e set e.ref=:ref, e.desi=:desi, e.prix=:prix, e.qte=:qte, e.date=:date, e.condi=:condi, e.nom_four=:nom_four where e.id=:id",nativeQuery = true)
	public void updateE(@Param("ref") String ref, @Param("desi") String desi,  @Param("prix") double prix, @Param("qte") int qte, @Param("date") Date date, @Param("condi") String condi, @Param("nom_four") String nomFour, @Param("id") Long id); 

}
