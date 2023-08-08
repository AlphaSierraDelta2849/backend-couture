package com.mbi.couture.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.mbi.couture.entity.Client;
import com.mbi.couture.repository.ClientRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {
    
    @Autowired
    private ClientRepository ClientRepository;
    
    @GetMapping("persons")
    public ResponseEntity<List<Client>> getAllClient(){
        return ResponseEntity.ok(ClientRepository.findAll());
    }
    @GetMapping("/person/{id}")
    public Client getClient(@PathVariable Long id){
        return this.getClientById(id);
    }
    @PostMapping("/add-person")
    public Client createPerson(@RequestBody Client person) {
        // try {
        return ClientRepository.save(person);
        // return ResponseEntity.ok("Person saved successfully");
    // } catch (Exception e) {
    //     // Handle the exception and return an appropriate response
    //     // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save person: " + e.getMessage());
    // }
    }
    public Client getClientById(Long id) {
        return ClientRepository.findById(id).orElseThrow(null);
    }
    @PutMapping("edit/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client Client) {
        Client updateClient = getClientById(id);
        updateClient.setFirstName(Client.getFirstName());
        updateClient.setLastName(Client.getLastName());
        updateClient.setPhone(Client.getPhone());
        updateClient.setBirthday(Client.getBirthday());
        updateClient.setAddress(Client.getAddress());
        return ClientRepository.save(Client);
    }
    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        ClientRepository.deleteById(id);
    }

    

}
