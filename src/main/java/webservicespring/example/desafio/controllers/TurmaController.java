package webservicespring.example.desafio.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import webservicespring.example.desafio.entities.Turma;
import webservicespring.example.desafio.services.TurmaService;

@RestController
@RequestMapping(value = "/turmas")
@Tag(name = "turmas")
public class TurmaController {
    
    private final TurmaService turmaService;

    TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }
	
	@Operation(summary = "Realiza a busca de todos as turmas", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
        @ApiResponse(responseCode = "422", description = "Dados de requisição inválidos"),
        @ApiResponse(responseCode = "400", description = "Parametros Inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro ao realizar busca"),
    })
    @GetMapping
	public ResponseEntity<List<Turma>> findAll() {
		List<Turma> list = turmaService.findAll();
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
	public ResponseEntity<Turma> findById(@PathVariable Long id) {
		Turma obj = turmaService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
