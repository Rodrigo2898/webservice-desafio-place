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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import webservicespring.example.desafio.entities.Curso;
import webservicespring.example.desafio.services.CursoService;

@RestController
@RequestMapping(value = "/cursos")
@Tag(name = "cursos")
public class CursoController {

    private final CursoService cursoService;

    CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @Operation(summary = "Realiza a busca de todos os cursos", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
        @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
        @ApiResponse(responseCode = "400", description = "Parametros Inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro ao realizar busca"),
    })
    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        List<Curso> list = cursoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "Realiza a busca por id", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
        @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
        @ApiResponse(responseCode = "400", description = "Parametros Inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro ao realizar busca"),
    })
    @GetMapping(value = "/{id}")
	public ResponseEntity<Curso> findById(@PathVariable Long id) {
		Curso obj = cursoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

    @Operation(summary = "Realiza upload dos cursos", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Novo curso criado com sucesso"),
        @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
        @ApiResponse(responseCode = "400", description = "Parametros Inválidos"),
        @ApiResponse(responseCode = "401", description = "Usuário não autenticado"),
        @ApiResponse(responseCode = "500", description = "Erro ao criar usuário"),
    })
    @PostMapping
	public ResponseEntity<Curso> insert(@RequestBody Curso obj) {
		obj = cursoService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCurso()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

    @Operation(summary = "Deleta um Curso", method = "DELETE")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Curso deletado com sucesso"),
        @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
        @ApiResponse(responseCode = "400", description = "Parametros Inválidos"),
        @ApiResponse(responseCode = "401", description = "Usuário não autenticado"),
        @ApiResponse(responseCode = "500", description = "Erro ao deletar o usuário"),
    })
    @DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		cursoService.delete(id);
		return ResponseEntity.noContent().build();
	}

    @Operation(summary = "Realiza upload dos cursos", method = "PUT")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Curso atualizado com sucesso"),
        @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
        @ApiResponse(responseCode = "400", description = "Parametros Inválidos"),
        @ApiResponse(responseCode = "401", description = "Usuário não autenticado"),
        @ApiResponse(responseCode = "500", description = "Erro ao atualizar o usuário"),
    })
    @PutMapping(value = "/{id}")
	public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso obj) {
		obj = cursoService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
