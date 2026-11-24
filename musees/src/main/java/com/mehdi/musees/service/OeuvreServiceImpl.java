package com.mehdi.musees.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mehdi.musees.entities.Oeuvre;
import com.mehdi.musees.repositories.OeuvreRepository;

@Service
public class OeuvreServiceImpl implements OeuvreService {

	private final OeuvreRepository oeuvreRepository;

	public OeuvreServiceImpl(OeuvreRepository oeuvreRepository) {
		super();
		this.oeuvreRepository = oeuvreRepository;
	}

	@Override
	public Oeuvre saveOeuvre(Oeuvre o) {
		return oeuvreRepository.save(o);
	}

	@Override
	public Oeuvre updateOeuvre(Oeuvre o) {
		return oeuvreRepository.save(o);
	}

	@Override
	public void deleteOeuvre(Oeuvre o) {
		oeuvreRepository.delete(o);
	}

	@Override
	public void deleteOeuvreById(Long id) {
		oeuvreRepository.deleteById(id);
	}

	@Override
	public Oeuvre getOeuvre(Long id) {
		return oeuvreRepository.findById(id).get();
	}

	@Override
	public List<Oeuvre> getAllOeuvres() {
		return oeuvreRepository.findAll();
	}

	@Override
	public List<Oeuvre> findByOeuvreJPQL(Oeuvre oeuvre) {
		return oeuvreRepository.findByOeuvreJPQL(oeuvre);
	}

	@Override
	public List<Oeuvre> findByMuseeIdMuseeJPQL(Long idMusee) {
		return oeuvreRepository.findByMuseeIdMuseeJPQL(idMusee);
	}

	@Override
	public List<Oeuvre> findByTitreOeuvreOrderByIdOeuvreAsc(String titre) {
		return oeuvreRepository.findByTitreOeuvreOrderByIdOeuvreAsc(titre);
	}

	@Override
	public List<Oeuvre> findByTitreOeuvreOrderByIdOeuvreDesc(String titre) {
		return oeuvreRepository.findByTitreOeuvreOrderByIdOeuvreDesc(titre);
	}

}