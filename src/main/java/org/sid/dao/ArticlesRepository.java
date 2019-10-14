package org.sid.dao;

import java.util.Date;

import org.sid.entities.Articles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticlesRepository extends JpaRepository<Articles, Long>{
	
	@Query("select a from Articles a where a.desi like :x")
	public Page<Articles> chercher(@Param("x") String mc, Pageable pageable);
	
	@Modifying
	@Query(value="update articles a set a.ref=:ref, a.desi=:desi, a.qte=:qte, a.stock_min=:stock_min, a.prix_u=:prix_u, a.prix_t=:prix_t, a.date=:date, a.art_fam=:art_fam, a.art_rang=:art_rang, a.art_four=:art_four, a.art_usa=:art_usa, a.art_uni=:art_uni where a.id=:id",nativeQuery = true)
	public void updateA(@Param("ref") String ref, @Param("desi") String desi, @Param("qte") int qte, @Param("stock_min") int stock_min, @Param("prix_u") double prix_u, @Param("prix_") double prix_t, @Param("date") Date date, @Param("art_fam") String art_fam, @Param("art_rang") String art_rang, @Param("art_four") String art_four, @Param("art_usa") String art_usa, @Param("art_uni") String art_uni, @Param("id") Long id); 
}

