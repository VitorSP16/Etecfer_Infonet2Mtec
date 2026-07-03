package br.com.etecfer.etecfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etecfer.etecfer.entity.Professor;
import br.com.etecfer.etecfer.repository.ProfessorRepository;

@Service

 public class ProfessorService{

    // Injeção de dependencias do repositorio  para a classe Curso
    @Autowired
    private ProfessorRepository professorRepository;

    //  Metodo para salvar um Curso
    public Professor save(Professor professor){
        return professorRepository.save(professor);
    }

     // Metodo para listar todos as Disciplinas
     public List<Professor>findAll(){
        return professorRepository.findAll();
    }

    //  Metodo para excluir cursos  pelo id
    public void deleteById(Integer id){
        professorRepository.deleteById(id);
     }

      //  Metodo para buscar o cursos pelo Id
      public Professor findById(Integer id){
        return professorRepository.findById(id).orElse(null);
     }
 }