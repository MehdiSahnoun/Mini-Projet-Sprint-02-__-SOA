package com.mehdi.musees.service;

import java.util.List;

import com.mehdi.musees.entities.Oeuvre;

public interface OeuvreService {

	Oeuvre saveOeuvre(Oeuvre o);
	Oeuvre updateOeuvre(Oeuvre o);
	void deleteOeuvre(Oeuvre o);
	void deleteOeuvreById(Long id);
	Oeuvre getOeuvre(Long id);
	List<Oeuvre> getAllOeuvres();

	List<Oeuvre> findByOeuvreJPQL(Oeuvre oeuvre);
	List<Oeuvre> findByMuseeIdMuseeJPQL(Long idMusee);
	List<Oeuvre> findByTitreOeuvreOrderByIdOeuvreAsc(String titre);
	List<Oeuvre> findByTitreOeuvreOrderByIdOeuvreDesc(String titre);

}