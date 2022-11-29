package com.example.challenge_5.repositories.security;

import com.example.challenge_5.model.security.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {

    Client findOneByClientId(String clientId);

}
