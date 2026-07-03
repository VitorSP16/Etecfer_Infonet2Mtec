package br.com.etecfer.etecfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etecfer.etecfer.entity.Disciplina;
import br.com.etecfer.etecfer.repository.DisciplinaRepository;

@Service
 public class  DisciplinaService{

    // Injeção de dependencias do repositorio  para a classe Disciplina 
    @Autowired
    private DisciplinaRepository disciplinaRepository;

     //  Metodo para salvar um Curso
     public Disciplina save(Disciplina disciplina){
        return disciplinaRepository.save(disciplina);
    }
     // Metodo para listar todos as Disciplinas
    public List<Disciplina>findAll(){
        return disciplinaRepository.findAll();
    }

    //  Metodo para excluir cursos  pelo id
    public void deleteById(Integer id){
        disciplinaRepository.deleteById(id);
     }

     //  Metodo para buscar o cursos pelo Id
     public Disciplina findById(Integer id){
        return disciplinaRepository.findById(id).orElse(null);
     }

 }