package webservicespring.example.desafio.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import webservicespring.example.desafio.entities.Curso;
import webservicespring.example.desafio.services.CursoService;

@RestController
@RequestMapping(value = "/cursos")
public class CursoController {

    private final CursoService cursoService;

    CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    
    @GetMapping("/teste")
    public String teste() {
        return "SALVE";
    }

    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        List<Curso> list = cursoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
	public ResponseEntity<Curso> findById(@PathVariable Long id) {
		Curso obj = cursoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

    @PostMapping
	public ResponseEntity<Curso> insert(@RequestBody Curso obj) {
		obj = cursoService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCurso()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

    @DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		cursoService.delete(id);
		return ResponseEntity.noContent().build();
	}

    @PutMapping(value = "/{id}")
	public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso obj) {
		obj = cursoService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
