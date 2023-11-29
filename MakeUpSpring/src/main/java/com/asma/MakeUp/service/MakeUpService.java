package com.asma.MakeUp.service;
import java.util.List;

import com.asma.MakeUp.entities.Marque;
import com.asma.MakeUp.entities.makeUp;

public interface MakeUpService {
	makeUp saveMakeUp(makeUp m);
	makeUp updateMakeUp(makeUp m);
	void deleteMakeUp(makeUp m);
    void deleteMakeUpById(Long id);
    makeUp getMakeUp (long id);
    List<makeUp> getAllMakeUp();
    List<makeUp>findBynomMakeUp(String nom);
    List<makeUp>findByNomContains(String nom);
    List<makeUp>findByNomPrix(String nom,Double prix);
    List<makeUp>findByMarque(Marque marque);
    List<makeUp>findByMarqueById(Long id);
    List<makeUp>findByOredrByNomMakeUp();
    List<makeUp>TrierMakeUpNomsPrix();
}

