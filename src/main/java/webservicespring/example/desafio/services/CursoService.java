package webservicespring.example.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import webservicespring.example.desafio.entities.Curso;
import webservicespring.example.desafio.repositories.CursoRepository;
import webservicespring.example.desafio.services.exceptions.DatabaseException;
import webservicespring.example.desafio.services.exceptions.ResourceNotFoundException;

public class CursoService {
    private final CursoRepository cursoRepository;

    CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Curso findById(Long id) {
        Optional<Curso> obj = cursoRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public Curso save(Curso obj) {
        return cursoRepository.save(obj);
    }

    @Transactional
    public void delete(Long id) {
        try {
            cursoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Transactional
    public Curso update(Long id, Curso obj) {
        try {
            Curso entity = cursoRepository.getReferenceById(id);
            updateData(entity, obj);
            return cursoRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Curso entity, Curso obj) {
        entity.setNome(obj.getNome());
        entity.setQuantidadeAlunos(obj.getQuantidadeAlunos());
        entity.setNivelCurso(obj.getNivelCurso());
    }
}
