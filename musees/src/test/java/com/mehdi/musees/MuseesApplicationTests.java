package com.mehdi.musees;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mehdi.musees.entities.Musee;
import com.mehdi.musees.repositories.MuseeRepository;

@SpringBootTest
class MuseesApplicationTests {

    @Autowired
    private MuseeRepository museeRepository;

    @Test
    void contextLoads() {
        
    }

    @Test
    public void testCreateMusee() {
        Musee mus = new Musee();
        mus.setNomMusee("Bardou");
        mus.setSuperficieMusee(88888.0);
        mus.setDateInauguration(new Date());

        Musee saved = museeRepository.save(mus);
        System.out.println("Musée créé : " + saved.getIdMusee() + " - " + saved.getNomMusee());
    }
    
    @Test
    public void testFindMusee() {
        Musee m = museeRepository.findById(1L).get();
        
        System.out.println("Id          : " + m.getIdMusee());
        System.out.println("Nom         : " + m.getNomMusee());
        System.out.println("Superficie  : " + m.getSuperficieMusee());
        System.out.println("Inauguration: " + m.getDateInauguration());
    }
    
    @Test
    public void testUpdateMusee() {
        Musee m = museeRepository.findById(1L).get();
        m.setNomMusee("Bardou");
        museeRepository.save(m);
        
        System.out.println("Id          : " + m.getIdMusee());
        System.out.println("Nom         : " + m.getNomMusee());
        System.out.println("Superficie  : " + m.getSuperficieMusee());
        System.out.println("Inauguration: " + m.getDateInauguration());
    }
    
    @Test
    public void testDeleteMusee() {
        museeRepository.deleteById(1L);
       
    }
    
    @Test
    public void testFindAllMusee() {
        List <Musee> muses = museeRepository.findAll();
        
        for(Musee ms: muses) {
        	System.out.println("Id          : " + ms.getIdMusee());
            System.out.println("Nom         : " + ms.getNomMusee());
            System.out.println("Superficie  : " + ms.getSuperficieMusee());
            System.out.println("Inauguration: " + ms.getDateInauguration());
        }
    }
    
    @Test
    public void testFindMuseeByNom() {
        List <Musee> musees = museeRepository.findByNomMusee("Louvre");
        
        for(Musee m:musees) {
        
        System.out.println("Id          : " + m.getIdMusee());
        System.out.println("Nom         : " + m.getNomMusee());
        System.out.println("Superficie  : " + m.getSuperficieMusee());
        System.out.println("Inauguration: " + m.getDateInauguration()); }
    }
    
    @Test
    public void testFindMuseeByNomCountains() {
        List <Musee> musees = museeRepository.findByNomMuseeContains("o");
        
        for(Musee m:musees) {
        
        System.out.println("Id          : " + m.getIdMusee());
        System.out.println("Nom         : " + m.getNomMusee());
        System.out.println("Superficie  : " + m.getSuperficieMusee());
        System.out.println("Inauguration: " + m.getDateInauguration()); }
    }
}