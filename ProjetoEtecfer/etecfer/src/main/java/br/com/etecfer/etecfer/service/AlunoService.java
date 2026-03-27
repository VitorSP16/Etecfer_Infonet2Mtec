package br.com.etecfer.etecfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etecfer.etecfer.entity.Aluno;
import br.com.etecfer.etecfer.repository.AlunoRepository;

@Service
public class AlunoService {
    // Injeção de dependencias do repositorio  para a classe aluno 
    @Autowired
   private AlunoRepository alunoRepository;

     //  Metodo para salvar um aluno
   public Aluno save(Aluno aluno){
      return alunoRepository.save(aluno);
    }
    // Metodo para listar todos os alunos
     public List<Aluno>findAll(){
        return alunoRepository.findAll();
     }
}
