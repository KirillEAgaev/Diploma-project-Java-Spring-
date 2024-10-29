package ru.agaev.springcourse.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.agaev.springcourse.models.Client;
import ru.agaev.springcourse.repositories.ClientsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ClientsService {

    private final ClientsRepository clientsRepository;

    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    public List<Client> findAll() {
        return clientsRepository.findAll();
    }

    public Client findOne(int id) {
        Optional<Client> foundClient = clientsRepository.findById(id);
        return foundClient.orElse(null);
    }

    @Transactional
    public void save(Client client) {
        clientsRepository.save(client);
    }

    @Transactional
    public void update(int id, Client updatedClient) {
        updatedClient.setId(id);
        clientsRepository.save(updatedClient);
    }

    @Transactional
    public void delete(int id) {
        clientsRepository.deleteById(id);
    }
}
