package com.wqa.exam.application.controllers;

import com.wqa.exam.configuration.exception.EdadMinimaClienteException;
import com.wqa.exam.configuration.util.RestReturn;
import com.wqa.exam.configuration.util.RestReturnEntity;
import com.wqa.exam.domain.data.PersonaDTO;
import com.wqa.exam.domain.ports.api.PersonaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", maxAge = 20000)
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("persona")
    @Operation(summary = "Registrar a una persona ",  tags = { "Cliente" })
    public ResponseEntity<RestReturnEntity<PersonaDTO>> crearPersona(@RequestBody PersonaDTO personaDTO) {
        try {
            return RestReturn.ok(personaService.insert(personaDTO));
        } catch (EdadMinimaClienteException e) {
            return RestReturn.fail(e.getMessage());
        }
    }
    @GetMapping("persona/{id}")
    public ResponseEntity<?> crearPersona(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(personaService.getById(id));
    }
}