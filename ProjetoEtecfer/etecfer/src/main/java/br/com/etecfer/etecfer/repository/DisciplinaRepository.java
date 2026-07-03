package br.com.etecfer.etecfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etecfer.etecfer.entity.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina , Integer>{
    
}
