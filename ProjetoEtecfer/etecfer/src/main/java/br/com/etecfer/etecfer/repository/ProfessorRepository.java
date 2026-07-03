package br.com.etecfer.etecfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etecfer.etecfer.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor , Integer> {
    
}
