package webservicespring.example.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import webservicespring.example.desafio.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
