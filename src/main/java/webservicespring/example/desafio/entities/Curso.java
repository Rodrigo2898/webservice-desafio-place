package webservicespring.example.desafio.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CURSO")
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Integer quantidadeAlunos;
    @Column(nullable = false)
    private String nivelCurso;

    @JsonIgnore
    @OneToMany(mappedBy = "curso")
    private List<Turma> turmas = new ArrayList<>();


    public Curso() {
    }

    public Curso(Long id, String nome, Integer quantidadeAlunos, String nivelCurso) {
        super();
        this.id = id;
        this.nome = nome;
        this.quantidadeAlunos = quantidadeAlunos;
        this.nivelCurso = nivelCurso;
    }

    public Long getIdCurso() {
        return id;
    }

    public void setIdCurso(Long id) {
        this.id = id;
    }

    public String getNomeCurso() {
        return nome;
    }

    public void setNomeCurso(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidadeAlunos() {
        return quantidadeAlunos;
    }

    public void setQuantidadeAlunos(Integer quantidadeAlunos) {
        this.quantidadeAlunos = quantidadeAlunos;
    }

    public String getNivelCurso() {
        return nivelCurso;
    }

    public void setNivelCurso(String nivelCurso) {
        this.nivelCurso = nivelCurso;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

}
