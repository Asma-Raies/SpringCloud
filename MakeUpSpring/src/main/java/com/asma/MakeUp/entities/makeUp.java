package com.asma.MakeUp.entities;

//import org.springframework.data.annotation.Reference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Reference ;

@Entity 

public class makeUp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
  private Long referenceMakeUp ;
  private String nomMakeUp ;
  private double prixMakeUp ;
  private int quantite;
  @ManyToOne
  private Marque marque ;
  

public makeUp(long referenceMakeUp, String nomMakeUp, double prixMakeUp, int quantite) {
	super();
	this.referenceMakeUp = referenceMakeUp;
	this.nomMakeUp = nomMakeUp;
	this.prixMakeUp = prixMakeUp;
	this.quantite = quantite;
}
public makeUp() {
	super();
	// TODO Auto-generated constructor stub
}
public long getReferenceMakeUp() {
	return referenceMakeUp;
}
public void setReferenceMakeUp(long referenceMakeUp) {
	this.referenceMakeUp = referenceMakeUp;
}
public String getNomMakeUp() {
	return nomMakeUp;
}
public void setNomMakeUp(String nomMakeUp) {
	this.nomMakeUp = nomMakeUp;
}
public double getPrixMakeUp() {
	return prixMakeUp;
}
public void setPrixMakeUp(double prixMakeUp) {
	this.prixMakeUp = prixMakeUp;
}
public int getQuantite() {
	return quantite;
}
public void setQuantite(int quantite) {
	this.quantite = quantite;
}
public Marque getMarque() {
	return marque;
}
public void setMarque(Marque marque) {
	this.marque = marque;
}
@Override
public String toString() {
	return "makeUp [referenceMakeUp=" + referenceMakeUp + ", nomMakeUp=" + nomMakeUp + ", prixMakeUp=" + prixMakeUp
			+ ", quantite=" + quantite + "]";
}

  
}
