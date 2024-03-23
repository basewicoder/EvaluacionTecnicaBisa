package com.wqa.exam.application.controllers;

import com.wqa.exam.configuration.exception.EdadMinimaClienteException;
import com.wqa.exam.configuration.exception.NotFoundException;
import com.wqa.exam.configuration.exception.ValidacionReferenciaException;
import com.wqa.exam.configuration.util.RestReturn;
import com.wqa.exam.configuration.util.RestReturnEntity;
import com.wqa.exam.domain.data.ClienteDTO;
import com.wqa.exam.domain.data.ReferenciaDTO;
import com.wqa.exam.domain.ports.api.ClienteService;
import com.wqa.exam.domain.ports.api.ReferenciaService;
import com.wqa.exam.infrastructure.entity.EstadoCliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class ClienteController {

    private final ClienteService clienteService;
    private final ReferenciaService referenciaService;

    public ClienteController(ClienteService clienteService, ReferenciaService referenciaService) {
        this.clienteService = clienteService;
        this.referenciaService = referenciaService;
    }

    @PostMapping("/clientes")
    //Registrar a un cliente
    public ResponseEntity<RestReturnEntity<ClienteDTO>> crearCliente(@RequestBody ClienteDTO cliente) {
        try {
            return RestReturn.ok(clienteService.insertClientePersona(cliente));
        } catch (EdadMinimaClienteException e) {
            return RestReturn.fail(e.getMessage());
        }
    }

    @PostMapping("/clientes/{clienteId}/referencias")
    public ResponseEntity<RestReturnEntity<ClienteDTO>> añadirReferenciaPersonal(@PathVariable Long clienteId,
                                                                                 @RequestBody ReferenciaDTO referenciaPersonal) {
        try {
            ClienteDTO cliente = clienteService.getById(clienteId);
            log.info("cliente, {}", cliente);
            if (cliente == null) {
                throw new NotFoundException("Cliente no encontrado");
            } else {
                referenciaPersonal.setClienteID(Math.toIntExact(cliente.getId()));
                ReferenciaDTO insertedReferencia = referenciaService.insert(referenciaPersonal);
                if (insertedReferencia == null) {
                    throw new ValidacionReferenciaException("No se puedo registrar la referencia");
                }
                cliente.getReferencias().add(insertedReferencia);
                if (cliente.getReferencias().size() >= 1) {
                    cliente.setEstado(EstadoCliente.ACTIVO);
                }
            }
            // return null;//
            return RestReturn.ok(clienteService.actualizar(cliente));
        } catch (NotFoundException e) {
            return RestReturn.fail(e.getMessage());
        }
    }

    @DeleteMapping("/clientes/{clienteId}/referencias/{referenciaId}")
    public ResponseEntity<RestReturnEntity<ClienteDTO>> eliminarReferenciaPersonal(@PathVariable Long clienteId,
                                                                                   @PathVariable Long referenciaId,
                                                                                   @RequestParam String motivo) {
        try {
            ClienteDTO cliente = clienteService.getById(clienteId);
            if (cliente == null) {
                throw new NotFoundException("Cliente no encontrado");
            } else {
                cliente.getReferencias().removeIf(referencia -> referencia.getId().equals(referenciaId));
                referenciaService.modificar(referenciaService.getById(referenciaId), motivo);
                if (cliente.getReferencias().size() == 0) {
                    cliente.setEstado(EstadoCliente.BLOQUEADO);
                }
            }
            return RestReturn.ok(clienteService.actualizar(cliente));
        } catch (NotFoundException e) {
            return RestReturn.fail(e.getMessage());
        }
    }

    @GetMapping("/clientes/accesibilidad")
    public List<ClienteDTO> accesibilidadCliente() {
        return clienteService.accesibilidadCliente();
    }
}
