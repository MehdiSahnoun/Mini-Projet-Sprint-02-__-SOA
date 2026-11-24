package com.mehdi.musees.service;

import java.util.List;

import com.mehdi.musees.entities.Musee;

public interface MuseeService {

	Musee saveMusee(Musee m);
	Musee updateMusee(Musee m);
	void deleteMusee(Musee m);
	void deleteMuseeById(Long id);
	Musee getMusee(Long id);
	List<Musee> getAllMusees();

	List<Musee> findByNomMuseeJPQL(String nom);
	List<Musee> findByMuseeJPQL(Musee musee);
	List<Musee> findByIdMuseeJPQL(Long id);
	List<Musee> findByNomMuseeOrderByIdMuseeAsc(String nom);
	List<Musee> findByNomMuseeOrderByIdMuseeDesc(String nom);

}
