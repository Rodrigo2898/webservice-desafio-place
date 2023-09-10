package webservicespring.example.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import webservicespring.example.desafio.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{
    
}
