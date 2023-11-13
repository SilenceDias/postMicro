package com.example.clientcoreapi.controllers;

import com.example.clientcoreapi.models.ClientModel;
import com.example.clientcoreapi.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @Autowired
    Environment environment;

    @GetMapping("/check")
    public String check(){
        return "client-core-api is working on port: " + environment.getProperty("local.server.port");
    }

    @PostMapping()
    public ResponseEntity<String> createClient( @RequestBody ClientModel clientModel){
        clientService.createClient(clientModel);
        return new ResponseEntity<String>("New client added", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<ClientModel> getAllClients(){
        return clientService.getAllClient();
    }

    @GetMapping("{clientId}")
    public ClientModel getClientById(@PathVariable Long clientId){
        return clientService.getClientById(clientId);
    }

    @PutMapping("{clientId}")
    public ResponseEntity<String> updatePostById(@PathVariable Long clientId, @RequestBody ClientModel clientModel){
        clientService.updateClientById(clientId, clientModel);
        return new ResponseEntity<String>("Client with id: "+clientId+ " updated", HttpStatus.OK);
    }

    @DeleteMapping("{clientId}")
    public ResponseEntity<String> deleteClientById(@PathVariable Long clientId){
        clientService.deleteClientById(clientId);
        return new ResponseEntity<String>("Post with id: "+clientId+ " deleted", HttpStatus.OK);

    }
}
