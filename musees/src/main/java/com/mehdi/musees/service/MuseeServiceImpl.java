package com.mehdi.musees.service;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mehdi.musees.entities.Musee;
import com.mehdi.musees.repositories.MuseeRepository;

@Service
public class MuseeServiceImpl implements MuseeService{
	
	//@Autowired
	private final MuseeRepository museeRepository;

	public MuseeServiceImpl(MuseeRepository museeRepository) {
		super();
		this.museeRepository = museeRepository;
	}

	@Override
	public Musee saveMusee(Musee m) {
		
		return museeRepository.save(m);
	}

	@Override
	public Musee updateMusee(Musee m) {
		return museeRepository.save(m);
	}

	@Override
	public void deleteMusee(Musee m) {
		museeRepository.delete(m);
		
	}

	@Override
	public void deleteMuseeById(Long id) {
		museeRepository.deleteById(id);
		
	}

	@Override
	public Musee getMusee(Long id) {
		return museeRepository.findById(id).get();
	}

	@Override
	public List<Musee> getAllMusees() {
		return museeRepository.findAll();
	}
	
	@Override
	public List<Musee> findByNomMuseeJPQL(String nom) {
		return museeRepository.findByNomMuseeJPQL(nom);
	}

	@Override
	public List<Musee> findByMuseeJPQL(Musee musee) {
		return museeRepository.findByMuseeJPQL(musee);
	}

	@Override
	public List<Musee> findByIdMuseeJPQL(Long id) {
		return museeRepository.findByIdMuseeJPQL(id);
	}

	@Override
	public List<Musee> findByNomMuseeOrderByIdMuseeAsc(String nom) {
		return museeRepository.findByNomMuseeOrderByIdMuseeAsc(nom);
	}

	@Override
	public List<Musee> findByNomMuseeOrderByIdMuseeDesc(String nom) {
		return museeRepository.findByNomMuseeOrderByIdMuseeDesc(nom);
	}

}
