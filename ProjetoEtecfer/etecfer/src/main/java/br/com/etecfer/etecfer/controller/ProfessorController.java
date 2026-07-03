package br.com.etecfer.etecfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import br.com.etecfer.etecfer.entity.Professor;
import br.com.etecfer.etecfer.service.ProfessorService;


@Controller
@RequestMapping("/professores")


public class ProfessorController {
   
    //Injeção de depenedentes da service para a classe Curso
    @Autowired
    private ProfessorService professorService;

    // Metodo para salvar um Curso 
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Professor professor ) {
        professor.save(professor);
        return "redirect:/professores/listar" ;
    }

     // Metodo para criar um formulario com um novo objeto Curso
     @GetMapping("/listar")
     public String listar (Model model) {
         List<Professor> professores = professorService.findAll();
         model.addAttribute("professores", professores);
         return "professores/listarprofessores";
     }

      // Metodo para criar um formulario com um novo objeto curso
      @GetMapping("/criar")
      public String criarForm(Model model) {
        model.addAttribute("curso", new Professor());
          return "professor/formularioProfessor";
      }
      // Metodo para Excluir um cursos
      @GetMapping("/excluir/{id}")
      public String  excluir(@PathVariable("id")  Integer id) {
           professorService.deleteById(id);
           return "redirect:/professores/listar";
      }

      @GetMapping("/editar/{id}")
      public String editarForm(@PathVariable("id") Integer id, Model model) {
      Professor professor = professorService.findById(id);
      model.addAttribute("professor", professor);
      return "disciplina/formularioDisciplina";
      }

}
