package br.com.etecfer.etecfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etecfer.etecfer.entity.Aluno;
public interface AlunoRepository extends JpaRepository<Aluno,Integer> {
    
}
