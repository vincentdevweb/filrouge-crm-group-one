package com.crm.filrouge.controller.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.filrouge.controller.client.dto.ClientDTO;
import com.crm.filrouge.controller.client.dto.ClientMapper;
import com.crm.filrouge.controller.client.dto.ClientPostDTO;
import com.crm.filrouge.dao.Client.Client;
import com.crm.filrouge.service.CommandFlowService;

@RestController
@RequestMapping("/api")
// @CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    @Autowired
    private CommandFlowService commandFlowService;

    @GetMapping("clients")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<Client> entities = commandFlowService.getAllClients();
        List<ClientDTO> dtos = new ArrayList<>();
        for (Client entity : entities)
            dtos.add(ClientMapper.convertFromEntityToDto(entity));

        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping("clients")
    public ResponseEntity<String> createClient(@RequestBody ClientPostDTO clientPostDTO) {
        Client client = ClientMapper.convertFromDtoToEntity(clientPostDTO);
        try {
            commandFlowService.saveClient(client);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("{\"message\": \"Client created successfully\"}");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("{\"message\": \"Error: JSON\"}");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\": \"Error: " + e.getMessage() + "\"}");
        }
    }

    @GetMapping("clients/{id}")
    public ResponseEntity<?> getClientById(@PathVariable("id") Integer id) {
        Client entity = commandFlowService.getClientById(id);
        if (entity == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"message\": \"Client not found\"}");
        }
        ClientDTO dto = ClientMapper.convertFromEntityToDto(entity);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("clients/{id}")
    public ResponseEntity<String> updateClient(@PathVariable("id") Integer id,
            @RequestBody ClientPostDTO ClientPatchDTO) {
        Client Client = ClientMapper.convertFromDtoToEntity(ClientPatchDTO);
        Client existingClient = commandFlowService.updateClient(Client, id);
        if (existingClient != null) {
            try {
                commandFlowService.saveClient(existingClient);
                return ResponseEntity
                        .ok("{\"message\": \"Client Put successfully\"}");
            } catch (DataIntegrityViolationException e) {
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body("{\"message\": \"Error: JSON\"}");
            } catch (Exception e) {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("{\"message\": \"Error: " + e.getMessage() + "\"}");
            }
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("{\"message\": \"Client Not Found\"}");
    }

    @PatchMapping("clients/{id}")
    public ResponseEntity<String> patchClient(@PathVariable("id") Integer id,
            @RequestBody ClientPostDTO clientPatchDTO) {
        Client client = ClientMapper.convertFromDtoToEntity(clientPatchDTO);
        Client existingClient = commandFlowService.patchClient(client, id);
        if (existingClient == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"message\": \"Client Not Found\"}");
        }
        try {
            commandFlowService.saveClient(existingClient);
            return ResponseEntity
                    .ok("{\"message\": \"Client Patch successfully\"}");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"message\": \"Error: " + e.getMessage() + "\"}");
        }
    }

    @DeleteMapping("clients/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") Integer id) {
        if (commandFlowService.deleteClient(id)) {
            return ResponseEntity
                    .ok("{\"message\": \"Client deleted successfully\"}");
        } else
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{\"message\": \"Client Not Found\"}");
    }
}
