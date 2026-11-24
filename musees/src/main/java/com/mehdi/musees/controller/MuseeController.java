package com.mehdi.musees.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehdi.musees.entities.Musee;
import com.mehdi.musees.service.MuseeService;

@RestController
@RequestMapping("/api/musees")
@CrossOrigin(origins = "*")
public class MuseeController {

	private final MuseeService museeService;
	private final ModelMapper modelMapper;

	public MuseeController(MuseeService museeService, ModelMapper modelMapper) {
		this.museeService = museeService;
		this.modelMapper = modelMapper;
	}

	@GetMapping
	public List<Musee> getAllMusees() {
		return museeService.getAllMusees();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Musee> getMuseeById(@PathVariable Long id) {
		Musee musee = museeService.getMusee(id);
		return ResponseEntity.ok(musee);
	}

	@PostMapping
	public ResponseEntity<Musee> createMusee(@RequestBody Musee musee) {
		Musee saved = museeService.saveMusee(musee);
		return ResponseEntity.ok(saved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Musee> updateMusee(@PathVariable Long id, @RequestBody Musee musee) {
		musee.setIdMusee(id);
		Musee updated = museeService.updateMusee(musee);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMusee(@PathVariable Long id) {
		museeService.deleteMuseeById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/nom/{nom}")
	public List<Musee> findByNomMusee(@PathVariable String nom) {
		return museeService.findByNomMuseeJPQL(nom);
	}

}