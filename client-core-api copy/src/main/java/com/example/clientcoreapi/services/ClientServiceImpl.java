package com.example.clientcoreapi.services;

import com.example.clientcoreapi.models.ClientModel;
import com.example.clientcoreapi.repository.ClientEntity;
import com.example.clientcoreapi.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    private static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public void createClient(ClientModel clientModel) {
        ClientEntity clientEntity = modelMapper.map(clientModel, ClientEntity.class);
        clientRepository.save(clientEntity);
    }

    @Override
    public List<ClientModel> getAllClient() {
        return clientRepository.getClientEntitiesBy().stream()
                .map(client -> modelMapper.map(client, ClientModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClientModel getClientById(Long id) {
       ClientEntity clientEntity = clientRepository.getClientEntityById(id);
       return modelMapper.map(clientEntity, ClientModel.class);
    }

    @Override
    public void updateClientById(Long id, ClientModel clientModel) {

        ClientEntity clientEntity = modelMapper.map(clientModel, ClientEntity.class);
        clientEntity.setId(id);

        clientRepository.save(clientEntity);
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }
}
