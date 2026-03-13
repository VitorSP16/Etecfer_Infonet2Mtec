package br.com.etecfer.etecfer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Aluno {
    //Definição dos atributos da classe Aluno 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAluno;

    @Column(nullable = false,length = 40)
    private String nomeAluno;

    @Column(length = 40)
    private String emailAluno;

    @Column(nullable = false,length = 11)  
    private String telefoneAluno;

    @Column(nullable = false)
    private Integer raAluno;

    @Column(nullable = false,length = 11)
    private String cpfAluno;

    
}
