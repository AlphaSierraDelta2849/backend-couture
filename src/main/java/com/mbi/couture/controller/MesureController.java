package com.mbi.couture.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbi.couture.entity.Client;
import com.mbi.couture.entity.Mesure;
import com.mbi.couture.repository.ClientRepository;
import com.mbi.couture.repository.MesureRepository;


@RestController
@RequestMapping("/api/mesure")
@CrossOrigin(origins = "http://localhost:4200")
public class MesureController {
    @Autowired
    private MesureRepository mesureRepository;
    @Autowired
    private ClientRepository clientRepository;
    @PostMapping("/add-mesure")
    public Mesure saveMesure(@RequestBody Mesure mesure) {
        Long client_id=mesure.getClient().getId();
        Client client=clientRepository.findById(client_id).orElseThrow();
        mesure.setClient(client);
        return mesureRepository.save(mesure);
    }
    @PutMapping("/edit")
    public ResponseEntity<Mesure> updateClientMesure(@RequestBody Mesure updatedMesure) {
        Mesure existingMesure = mesureRepository.findById(updatedMesure.getId()).orElseThrow(null);
        if (existingMesure == null) {
            return ResponseEntity.notFound().build();
        }

        existingMesure.setAvantBras(updatedMesure.getAvantBras());
        existingMesure.setBiceps(updatedMesure.getBiceps());
        existingMesure.setCheville(updatedMesure.getCheville());
        existingMesure.setCoude(updatedMesure.getCoude());
        existingMesure.setCoup(updatedMesure.getCoup());
        existingMesure.setCoutureExt(updatedMesure.getCoutureExt());
        existingMesure.setCuisse(updatedMesure.getCuisse());
        existingMesure.setEntreJambe(updatedMesure.getEntreJambe());
        existingMesure.setEpaule(updatedMesure.getEpaule());
        existingMesure.setGenou(updatedMesure.getGenou());
        existingMesure.setHToal(updatedMesure.getHToal());
        existingMesure.setHanches(updatedMesure.getHanches());
        existingMesure.setLBras(updatedMesure.getLBras());
        existingMesure.setLCorps(updatedMesure.getLCorps());
        existingMesure.setMollet(updatedMesure.getMollet());
        existingMesure.setPoignetCoude(updatedMesure.getPoignetCoude());
        existingMesure.setPoitrine(updatedMesure.getPoitrine());
        existingMesure.setTete(updatedMesure.getTete());
        // Mettez à jour d'autres attributs selon vos besoins
        
        return ResponseEntity.ok(mesureRepository.save(updatedMesure));
    }
    @GetMapping("/{clientId}")
    public ResponseEntity<Mesure> getMesure(@PathVariable Long clientId){
        Client client=clientRepository.findById(clientId).orElseThrow();

        Mesure mesure=mesureRepository.findByClient(client);
        return ResponseEntity.ok(mesure);
    }
} 
