package com.asma.MakeUp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.asma.MakeUp.entities.Marque;
import com.asma.MakeUp.entities.makeUp;

@RepositoryRestResource(path = "rest")
public interface makeUpRepository extends JpaRepository <makeUp ,Long> {

	 List<makeUp> findByNomMakeUp(String nomMakeUp);
//	 List<makeUp> findByNomMakeUpLike(String nomMakeUp);
//	 
	 List <makeUp> findByNomMakeUpContains(String nom);
	 List<makeUp>findByMarqueIdMarq(Long id);
	 
	 @Query ("select m from makeUp m where m.nomMakeUp like %:nom and m.prixMakeUp > :prix")
	 List<makeUp> findByNomPrix (@Param("nom")String nom ,@Param("prix") double prix);
	
	 @Query ("select m from makeUp  m where m.marque = ?1")
	 List<makeUp> findByMarque ( Marque marque);
	 
	 List<makeUp>findByOrderByNomMakeUpAsc();
	 
	
}
