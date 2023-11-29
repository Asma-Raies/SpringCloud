package com.asma.MakeUp.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Marque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idMarq ;
private String nomMarq ;
@OneToMany (mappedBy = "marque")
@JsonIgnore
private List<makeUp> makeUp ;



public Long getIdMarq() {
	return idMarq;
}
public void setIdMarq(Long idMarq) {
	this.idMarq = idMarq;
}
public String getNomMarq() {
	return nomMarq;
}
public void setNomMarq(String nomMarq) {
	this.nomMarq = nomMarq;
}

public List<makeUp> getMakeUp() {
	return makeUp;
}
public void setMakeUp(List<makeUp> makeUp) {
	this.makeUp = makeUp;
}

}
