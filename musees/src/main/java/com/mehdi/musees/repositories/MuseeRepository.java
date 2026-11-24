package com.mehdi.musees.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mehdi.musees.entities.Musee;

public interface MuseeRepository extends JpaRepository<Musee, Long> {
	
	List <Musee> findByNomMusee (String nom);
	List <Musee> findByNomMuseeContains (String nom);

	@Query("SELECT m FROM Musee m WHERE m.nomMusee = :nom")
	List<Musee> findByNomMuseeJPQL(@Param("nom") String nom);

	@Query("SELECT m FROM Musee m WHERE m = :musee")
	List<Musee> findByMuseeJPQL(@Param("musee") Musee musee);

	@Query("SELECT m FROM Musee m WHERE m.idMusee = :id")
	List<Musee> findByIdMuseeJPQL(@Param("id") Long id);

	List<Musee> findByNomMuseeOrderByIdMuseeAsc(String nom);
	List<Musee> findByNomMuseeOrderByIdMuseeDesc(String nom);

}