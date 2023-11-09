package com.javaespring.estudanteapi.controller;

import com.javaespring.estudanteapi.model.Estudante;
import com.javaespring.estudanteapi.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @PostMapping("/estudantes")
    @ResponseStatus(HttpStatus.CREATED)
    public Estudante criarEstudante(@RequestBody Estudante estudante) {
        return estudanteService.criarEstudante(estudante);
    }

    @GetMapping("/estudantes")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> listarEstudantes() {
        return estudanteService.listarEstudantes();
    }

    @GetMapping("/estudantes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Estudante> listarEstudantes(@PathVariable(value = "id") Long id) {
        return estudanteService.buscarEstudantePeloId(id);
    }

    @PutMapping("/estudantes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Estudante> atualizarEstudantePeloId(@PathVariable(value = "id") Long id, @RequestBody Estudante
            estudante) {
        return estudanteService.atualizarEstudantePeloId(estudante, id);
    }

    @DeleteMapping("/estudantes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> excluirEstudantePeloId(@PathVariable(value = "id") Long id) {
        return estudanteService.excluirEstudantePeloId(id);
    }

}
