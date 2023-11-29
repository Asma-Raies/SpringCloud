package com.asma.MakeUp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asma.MakeUp.entities.Marque;
import com.asma.MakeUp.entities.makeUp;
import com.asma.MakeUp.repos.makeUpRepository;

@Service
public class MakeUpSeviceImpl implements MakeUpService{

	
	@Autowired
	makeUpRepository makeUpRepository ;
	
	@Override
	public makeUp saveMakeUp(makeUp m) {
		
		return makeUpRepository.save(m);
	}

	@Override
	public makeUp updateMakeUp(makeUp m) {
		
		return makeUpRepository.save(m);
	}

	@Override
	public void deleteMakeUp(makeUp m) {
		makeUpRepository.delete(m);	
	}

	@Override
	public void deleteMakeUpById(Long id) {
		makeUpRepository.deleteById(id);
		
	}

	@Override
	public makeUp getMakeUp(long id) {
	return	makeUpRepository.findById(id).get();
	}

	@Override
	public List<makeUp> getAllMakeUp() {
		
		//for(make => m)
		return makeUpRepository.findAll();
	}

	@Override
	public List<makeUp> findBynomMakeUp(String nom) {
		// TODO Auto-generated method stub
		return makeUpRepository.findByNomMakeUp(nom);
	}

	@Override
	public List<makeUp> findByNomContains(String nom) {
		// TODO Auto-generated method stub
		return makeUpRepository.findByNomMakeUpContains(nom);
	}

	@Override
	public List<makeUp> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return makeUpRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<makeUp> findByMarque(Marque marque) {
		// TODO Auto-generated method stub
		return makeUpRepository.findByMarque(marque);
	}

	@Override
	public List<makeUp> findByMarqueById(Long id) {
		// TODO Auto-generated method stub
		return makeUpRepository.findByMarqueIdMarq(id);
	}

	@Override
	public List<makeUp> findByOredrByNomMakeUp() {
		// TODO Auto-generated method stub
		return makeUpRepository.findByOrderByNomMakeUpAsc();
	}

	@Override
	public List<makeUp> TrierMakeUpNomsPrix() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
