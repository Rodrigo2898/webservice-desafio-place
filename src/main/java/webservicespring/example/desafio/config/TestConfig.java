package webservicespring.example.desafio.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import webservicespring.example.desafio.entities.Curso;
import webservicespring.example.desafio.entities.Turma;
import webservicespring.example.desafio.repositories.CursoRepository;
import webservicespring.example.desafio.repositories.TurmaRepository;

// Iniciando o Banco de Dados com valores
@Configuration
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public void run(String... args) throws Exception {
        Curso c1 = new Curso(null, "Programação Orientada a Objetos", 30, "Avançado");
        Curso c2 = new Curso(null, "Algoritmos e Programação de Computadores", 90, "Básico");
        Curso c3 = new Curso(null, "Estrutura de Dados", 55, "Intermediário");
        Curso c4 = new Curso(null, "Teoria dos Grafos", 43, "Avançado");

        Turma t1 = new Turma(null, "T01ESD2023", "Estrutura de Dados-t01", c3);
        Turma t2 = new Turma(null, "T01POO2023", "POO-t01", c1);
        Turma t3 = new Turma(null, "T01APC2023", "APC-t01", c2);
        Turma t4 = new Turma(null, "T02APC2023", "APC-t02", c2);
        Turma t5 = new Turma(null, "T01TDG2023", "Teoria dos Grafos-t01", c4);

        cursoRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
        turmaRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5));
    }
    
}
