package com.project.app.provider;

import com.project.app.entity.Client;
import com.project.app.kafka.KafkaService;
import com.project.app.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientProvider {

    private final ClientRepository clientRepository;
    private final KafkaService kafkaService;

    public void add(Client client){
        client.setEnrollmentDate(LocalDate.now());
        clientRepository.save(client);
        kafkaService.sendMessage("user.created");
    }

    public void addAll(List<Client> clients){
        clientRepository.saveAll(clients);
    }

}
