package com.asma.MakeUp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RestController;

import com.asma.MakeUp.entities.Marque;
//import com.asma.MakeUp.entities.makeUp;

@RepositoryRestResource(path = "marq")
@CrossOrigin("http://localhost:4200/")
public interface MarqueRepository extends JpaRepository<Marque, Long> {

	

	


}
