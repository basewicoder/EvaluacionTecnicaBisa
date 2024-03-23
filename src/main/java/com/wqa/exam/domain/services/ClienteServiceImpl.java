package com.wqa.exam.domain.services;

import com.wqa.exam.domain.data.ClienteDTO;
import com.wqa.exam.domain.data.PersonaDTO;
import com.wqa.exam.domain.data.ReferenciaDTO;
import com.wqa.exam.domain.ports.api.ClienteService;
import com.wqa.exam.domain.ports.api.PersonaService;
import com.wqa.exam.domain.ports.api.ReferenciaService;
import com.wqa.exam.domain.ports.persistence.ClientePersistencePort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClientePersistencePort persistencePort;
    private final ReferenciaService referenciaService;
    private final PersonaService personaService;

    public ClienteServiceImpl(ClientePersistencePort persistencePort, ReferenciaService referenciaService, PersonaService personaService) {
        this.persistencePort = persistencePort;
        this.referenciaService = referenciaService;
        this.personaService = personaService;
    }

    @Override
    @Transactional
    public ClienteDTO actualizar(ClienteDTO cliente) {
        return persistencePort.insert(cliente);
    }

    @Override
    public ClienteDTO getById(Long id) {
        return persistencePort.getById(id);
    }

    @Override
    public List<ClienteDTO> findAll() {
        return persistencePort.findAll();
    }
    @Override
    public List<ClienteDTO> accesibilidadCliente() {

        List<ClienteDTO> clientes = persistencePort.findAll();
        List<ClienteDTO> clientesFiltrados = new ArrayList<>();

        for (ClienteDTO cliente : clientes) {
            String accesibilidad = obtenerTextoAccesibilidad(cliente);
            cliente.setAccesibilidad(accesibilidad);
            clientesFiltrados.add(cliente);
        }
        return clientesFiltrados;
    }

    private String obtenerTextoAccesibilidad(ClienteDTO cliente) {
        int totalReferencias = cliente.getReferencias().size();
        int referenciasTipoCliente = contarReferenciasTipoCliente(cliente);

        if (totalReferencias >= 2) {
            if (referenciasTipoCliente >= 2) {
                return "Buena";
            } else if (referenciasTipoCliente >= 1) {
                return "Buena";
            }
        } else if (totalReferencias == 1) {
            if (referenciasTipoCliente == 1) {
                return "Regular";
            }
        } else if (totalReferencias == 0) {
            if (referenciasTipoCliente == 0) {
                return "Nula";
            }
        }
        return "Desconocida";
    }
    private int contarReferenciasTipoCliente(ClienteDTO cliente) {
        int count = 0;
        for (ReferenciaDTO referencia : cliente.getReferencias()) {
            if (referencia.getEstado().equals("00")) {
                count++;
            }
        }
        return count;
    }

    @Override
    public ClienteDTO insert(ClienteDTO clienteDTO) {
        return persistencePort.insert(clienteDTO);
    }

    @Override
    @Transactional
    public ClienteDTO insertClientePersona(ClienteDTO clienteDTO) {
        PersonaDTO personaDTO = personaService.insert(clienteDTO.getPersona());
        clienteDTO.getPersona().setId(personaDTO.getId());
        return persistencePort.insert(clienteDTO);
    }
}
