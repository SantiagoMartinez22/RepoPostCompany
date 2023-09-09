package com.workshop.postal.controller;


import com.workshop.postal.models.Cliente;
import com.workshop.postal.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
    @RequestMapping("/clientes")
    public class ClienteController {

        private final ClienteService clienteService;

        @Autowired
        public ClienteController(ClienteService clienteService) {
            this.clienteService = clienteService;
        }

        @GetMapping
        public List<Cliente> getAllClientes() {
            return clienteService.findAll();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Cliente> getClienteById(@PathVariable UUID id) {
            Optional<Cliente> cliente = clienteService.findById(id);
            if (cliente.isPresent()) {
                return ResponseEntity.ok(cliente.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @PostMapping
        public Cliente createCliente(@RequestBody Cliente cliente) {
            return clienteService.save(cliente);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Cliente> updateCliente(@PathVariable UUID id, @RequestBody Cliente cliente) {
            if (!clienteService.findById(id).isPresent()) {
                return ResponseEntity.notFound().build();
            }
            cliente.setId(id); // Asegura que el ID sea el correcto
            return ResponseEntity.ok(clienteService.save(cliente));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCliente(@PathVariable UUID id) {
            if (!clienteService.findById(id).isPresent()) {
                return ResponseEntity.notFound().build();
            }
            clienteService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }


