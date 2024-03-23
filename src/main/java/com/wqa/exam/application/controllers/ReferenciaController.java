package com.wqa.exam.application.controllers;

import com.wqa.exam.configuration.exception.EdadMinimaClienteException;
import com.wqa.exam.configuration.exception.NotFoundException;
import com.wqa.exam.configuration.util.RestReturn;
import com.wqa.exam.configuration.util.RestReturnEntity;
import com.wqa.exam.domain.data.ClienteDTO;
import com.wqa.exam.domain.data.PersonaDTO;
import com.wqa.exam.domain.data.ReferenciaDTO;
import com.wqa.exam.domain.ports.api.ClienteService;
import com.wqa.exam.domain.ports.api.PersonaService;
import com.wqa.exam.domain.ports.api.ReferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", maxAge = 20000)
public class ReferenciaController {

    @Autowired
    private ReferenciaService referenciaService;
    @Autowired
    private ClienteService clienteService;

    @PostMapping("referencia")
    public ResponseEntity<RestReturnEntity<ReferenciaDTO>> crearPersona(@RequestBody ReferenciaDTO referenciaDTO) {
        try {

            ReferenciaDTO referenciaPersonal = referenciaService.getById(referenciaDTO.getId());
            if (referenciaPersonal != null) {
                throw new NotFoundException("Referencia personal no encontrada");
            }
            return RestReturn.ok(referenciaService.insert(referenciaDTO));
        } catch (EdadMinimaClienteException e) {
            return RestReturn.fail(e.getMessage());
        } catch (NotFoundException e) {
            return RestReturn.fail(e.getMessage());
        }
    }


}