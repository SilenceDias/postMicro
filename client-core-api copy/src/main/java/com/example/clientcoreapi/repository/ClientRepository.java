package com.example.clientcoreapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
    List<ClientEntity> getClientEntitiesBy();

    ClientEntity getClientEntityById(Long id);



}
