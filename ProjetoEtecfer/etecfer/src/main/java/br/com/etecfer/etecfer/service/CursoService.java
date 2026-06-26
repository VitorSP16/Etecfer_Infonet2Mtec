package br.com.etecfer.etecfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etecfer.etecfer.entity.Curso;

import br.com.etecfer.etecfer.repository.CursoRepository;

@Service
public class CursoService {
    
     // Injeção de dependencias do repositorio  para a classe Curso
     @Autowired
     private CursoRepository cursoRepository;

    //  Metodo para salvar um Curso
    public Curso save(Curso curso){
        return cursoRepository.save(curso);
    }

    // Metodo para listar todos os cursos
    public List<Curso>findAll(){
        return cursoRepository.findAll();
    }
    //  Metodo para excluir cursos  pelo id
     public void deleteById(Integer id){
        cursoRepository.deleteById(id);
     }
    //  Metodo para buscar o cursos pelo Id
     public Curso findById(Integer id){
        return cursoRepository.findById(id).orElse(null);
     }
}
