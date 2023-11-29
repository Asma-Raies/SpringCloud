package com.asma.MakeUp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.asma.MakeUp.entities.Marque;
import com.asma.MakeUp.entities.makeUp;
import com.asma.MakeUp.repos.makeUpRepository;
import java.util.List;
@SpringBootTest
class MakeUpApplicationTests {
   @Autowired 
   private makeUpRepository makeUpRepository ;
	@Test
	public void testCreateMakeUp () {
		makeUp make = new makeUp(148,"mascara", 15.500 , 35);
		makeUpRepository.save(make);
		}
	@Test
   public void testFindMakeUp() {
	   makeUp m = makeUpRepository.findById(1L).get();
	    System.out.println(m);
   }
	@Test
	   public void testUpdateMakeUp() {
		   makeUp m = makeUpRepository.findById(6L).get();
		   m.setPrixMakeUp(150.0);
		   makeUpRepository.save(m);
		    System.out.println(m);
	   }
	@Test
	   public void testDeleteMakeUp() {
		makeUpRepository.deleteById(1L);
	   }
	@Test
	   public void testFindAllMakeUp() {
		List<makeUp> make = makeUpRepository.findAll();
		 for (makeUp m:make)
			 System.out.println(m);
	   }

	@Test
	   public void testFindMakeUpByNom() {
		   List<makeUp> make = makeUpRepository.findByNomMakeUp("rouge à levres");
		   for (makeUp m:make)
		    System.out.println(m);
	   }
	@Test
	   public void testFindMakeUpByNomContains() {
		   List<makeUp> make = makeUpRepository.findByNomMakeUpContains("r");
		   for (makeUp m:make)
		    System.out.println(m);
	   }
		@Test
	   public void testFindNomPrix() {
		   List<makeUp> make = makeUpRepository.findByNomPrix("crayon",25.5);
		   for (makeUp m:make) {
			   System.out.println(m);
	  
		   }}
		
		   @Test
		   public void testFindByMarque() {
			  Marque marq = new Marque();
		     marq.setIdMarq(1L);
		     List<makeUp> make = makeUpRepository.findByMarque(marq);
		     for (makeUp m :make) {
		    	 System.out.println(m);
		     }
		   }
		   @Test
		   public void testFindByMarqueIdMarq() {
			
		     List<makeUp> make = makeUpRepository.findByMarqueIdMarq(1L);
		     for (makeUp m :make) {
		    	 System.out.println(m);
		     }
		   }
		   @Test
		   public void testFindByOrderByNomMakeUpAsc() {
			
		     List<makeUp> make = makeUpRepository.findByOrderByNomMakeUpAsc();
		     for (makeUp m :make) {
		    	 System.out.println(m);
		     }
		   }
		   
}
	

