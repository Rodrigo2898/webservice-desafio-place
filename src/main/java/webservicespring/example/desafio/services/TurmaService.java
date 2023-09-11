package webservicespring.example.desafio.services;

import java.util.List;
import java.util.Optional;

import webservicespring.example.desafio.entities.Turma;
import webservicespring.example.desafio.repositories.TurmaRepository;

public class TurmaService {
    private final TurmaRepository turmaRepository;

    TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    
    public List<Turma> findAll() {
		return turmaRepository.findAll();
	}
	
	public Turma findById(Long id) {
		Optional<Turma>obj = turmaRepository.findById(id);
		return obj.get();
	}
}
