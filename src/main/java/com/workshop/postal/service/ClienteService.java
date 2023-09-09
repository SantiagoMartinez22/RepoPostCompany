package com.workshop.postal.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.workshop.postal.models.Cliente;
import com.workshop.postal.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
    public class ClienteService {

        private final ClienteRepository clienteRepository;

        @Autowired
        public ClienteService(ClienteRepository clienteRepository) {
            this.clienteRepository = clienteRepository;
        }

        public List<Cliente> findAll() {
            return clienteRepository.findAll();
        }

        public Optional<Cliente> findById(UUID id) {
            return clienteRepository.findById(id);
        }

        public Cliente save(Cliente cliente) {
            return clienteRepository.save(cliente);
        }

        public void deleteById(UUID id) {
            clienteRepository.deleteById(id);
        }
    }


