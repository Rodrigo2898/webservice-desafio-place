package webservicespring.example.desafio.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webservicespring.example.desafio.entities.Turma;
import webservicespring.example.desafio.services.TurmaService;



@RestController
@RequestMapping(value = "/turmas")
public class TurmaController {
    
    private final TurmaService turmaService;

    TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    
    @GetMapping
	public ResponseEntity<List<Turma>> findAll() {
		List<Turma> list = turmaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Turma> findById(@PathVariable Long id) {
		Turma obj = turmaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
