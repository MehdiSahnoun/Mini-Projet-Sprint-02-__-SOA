package com.mehdi.musees.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mehdi.musees.entities.Oeuvre;
import com.mehdi.musees.service.OeuvreService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class OeuvreController {

	private final OeuvreService oeuvreService;
	private final ModelMapper modelMapper;

	public OeuvreController(OeuvreService oeuvreService, ModelMapper modelMapper) {
		this.oeuvreService = oeuvreService;
		this.modelMapper = modelMapper;
	}

	@RequestMapping(path = {"all", "/oeuvres"}, method = RequestMethod.GET)
	public List<Oeuvre> getAllOeuvres() {
		return oeuvreService.getAllOeuvres();
	}

	@RequestMapping(value = {"/getbyid/{id}", "/oeuvres/{id}"}, method = RequestMethod.GET)
	public Oeuvre getOeuvreById(@PathVariable("id") Long id) {
		return oeuvreService.getOeuvre(id);
	}

	@RequestMapping(path = {"/addoeuv", "/addprod", "/oeuvres"}, method = RequestMethod.POST)
	public Oeuvre createOeuvre(@RequestBody Oeuvre oeuvre) {
		return oeuvreService.saveOeuvre(oeuvre);
	}

	@RequestMapping(path = {"/updateoeuv", "/updateprod", "/oeuvres"}, method = RequestMethod.PUT)
	public Oeuvre updateOeuvre(@RequestBody Oeuvre oeuvre) {
		return oeuvreService.updateOeuvre(oeuvre);
	}

	@RequestMapping(value = "/oeuvres/{id}", method = RequestMethod.PUT)
	public Oeuvre updateOeuvreWithId(@PathVariable("id") Long id, @RequestBody Oeuvre oeuvre) {
		oeuvre.setIdOeuvre(id);
		return oeuvreService.updateOeuvre(oeuvre);
	}

	@RequestMapping(value = {"/deloeuv/{id}", "/delprod/{id}", "/oeuvres/{id}"}, method = RequestMethod.DELETE)
	public void deleteOeuvre(@PathVariable("id") Long id) {
		oeuvreService.deleteOeuvreById(id);
	}

	@RequestMapping(value = {"/prodscat/{idCat}", "/oeuvsmusee/{idCat}", "/musee/{idCat}"}, method = RequestMethod.GET)
	public List<Oeuvre> getOeuvresByCatId(@PathVariable("idCat") Long idCat) {
		return oeuvreService.findByMuseeIdMuseeJPQL(idCat);
	}

}