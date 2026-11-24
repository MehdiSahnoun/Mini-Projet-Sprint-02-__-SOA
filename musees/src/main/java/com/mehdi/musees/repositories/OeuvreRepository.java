package com.mehdi.musees.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mehdi.musees.entities.Oeuvre;

public interface OeuvreRepository extends JpaRepository<Oeuvre, Long> {

	@Query("SELECT o FROM Oeuvre o WHERE o = :oeuvre")
	List<Oeuvre> findByOeuvreJPQL(@Param("oeuvre") Oeuvre oeuvre);

	@Query("SELECT o FROM Oeuvre o WHERE o.musee.idMusee = :idMusee")
	List<Oeuvre> findByMuseeIdMuseeJPQL(@Param("idMusee") Long idMusee);

	List<Oeuvre> findByTitreOeuvreOrderByIdOeuvreAsc(String titre);
	List<Oeuvre> findByTitreOeuvreOrderByIdOeuvreDesc(String titre);

}
