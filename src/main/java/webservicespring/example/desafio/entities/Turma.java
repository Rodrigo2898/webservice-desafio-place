package webservicespring.example.desafio.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_TURMA")
public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String codigo;
    @Column(nullable = false)
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "ID_CURSO")
    private Curso curso;

    public Turma() {
    }

    public Turma(Long id, String codigo, String nome, Curso curso) {
        super();
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.curso = curso;
    }

    public Long getIdTurma() {
        return id;
    }

    public void setIdTurma(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeTurma() {
        return nome;
    }

    public void setNomeTurma(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
