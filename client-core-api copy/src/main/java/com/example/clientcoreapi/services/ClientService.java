package com.example.clientcoreapi.services;

import com.example.clientcoreapi.models.ClientModel;

import java.util.List;

public interface ClientService {
    void createClient(ClientModel clientModel);
    List<ClientModel> getAllClient();
    ClientModel getClientById(Long id);
    void updateClientById(Long id, ClientModel clientModel);
    void deleteClientById(Long id);
}
