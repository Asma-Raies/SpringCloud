package com.asma.MakeUp.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.asma.MakeUp.entities.makeUp;
import com.asma.MakeUp.service.MakeUpService;

@RestController

@RequestMapping("/api")
@CrossOrigin
public class MakeUpRESTcontroller {
 
	 @Autowired
	MakeUpService makeUpService ;

	  @RequestMapping(method = RequestMethod.GET)
	 List<makeUp> getAllMakUp(){
		 return makeUpService.getAllMakeUp();
		 }
	 @RequestMapping(value="/{id}", method = RequestMethod.GET )
	 public makeUp getMakeUpById(@PathVariable("id") Long id) {
		 return makeUpService.getMakeUp(id);
	 }
	 
	 @RequestMapping(method = RequestMethod.POST)
		 public makeUp createMakeUp(@RequestBody makeUp m) {
			 return makeUpService.saveMakeUp(m);
		 }
	 @RequestMapping(method = RequestMethod.PUT)
	    public makeUp updateMakeUp(@RequestBody makeUp make) {
		 return makeUpService.updateMakeUp(make);
	 }
	 @RequestMapping(value="/{id}", method = RequestMethod.DELETE )
	 public void  deleteMakeUp(@PathVariable("id") Long id) {
		  makeUpService.deleteMakeUpById(id);
	 }
	 @RequestMapping(value="/prodsMarq/{idMarq}", method = RequestMethod.GET )
	 public List<makeUp> getMakeUpByMarqId(@PathVariable("idMarq") Long idMarq) {
		 return makeUpService.findByMarqueById(idMarq);
	 }
	 @RequestMapping(value="/prodsByName/{nomMarq}",method = RequestMethod.GET)
	 public List<makeUp> findByNomContains(@PathVariable("nomMarq") String nomMarq) {
	 return makeUpService.findByNomContains(nomMarq);
	 }
}
