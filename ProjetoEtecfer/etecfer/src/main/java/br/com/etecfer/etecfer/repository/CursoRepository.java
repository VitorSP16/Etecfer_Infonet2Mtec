package br.com.etecfer.etecfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.etecfer.etecfer.entity.Curso;

public interface  CursoRepository extends JpaRepository<Curso, Integer>{
    
}
