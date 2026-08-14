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

import br.com.etecfer.etecfer.entity.Curso;
import br.com.etecfer.etecfer.entity.Disciplina;
import br.com.etecfer.etecfer.entity.Professor;
import br.com.etecfer.etecfer.service.CursoService;
import br.com.etecfer.etecfer.service.DisciplinaService;
import br.com.etecfer.etecfer.service.ProfessorService;


@Controller
@RequestMapping("/disciplinas" )


public class DisciplinaController {
     //Injeção de depenedentes da service para a classe Disciplina
     @Autowired
     private DisciplinaService disciplinaService;

     @Autowired
     private CursoService cursoService;

     @Autowired
     private ProfessorService professorService;

     // Metodo para salvar um Disciplina
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Disciplina disciplina ) {
        disciplinaService.save(disciplina);
        return "redirect:/disciplinas/listar" ;
    }

    // Metodo para criar um formulario com um novo objeto Disciplina
    @GetMapping("/listar")
    public String listar (Model model) {
        List<Disciplina> disciplinas = disciplinaService.findAll();
        model.addAttribute("disciplinas", disciplinas);
        return "disciplina/listardisciplinas";
    }

     // Metodo para criar um formulario com um novo objeto Disciplina 
     @GetMapping("/criar")
     public String criarForm(Model model) {
       model.addAttribute("disciplina", new Disciplina());
       List<Curso> cursos = cursoService.findAll();
       model.addAttribute("cursos", cursos);
       List<Professor> professores = professorService.findAll();
       model.addAttribute("professores", professores);
         return "disciplina/formularioDisciplina";
     }
   
      // Metodo para Excluir uma  Disciplina 
      @GetMapping("/excluir/{id}")
      public String  excluir(@PathVariable("id")  Integer id) {
           disciplinaService.deleteById(id);
           return "redirect:/disciplinas/listar";
      }
      // Metodo para Editar uma Disciplina
    @GetMapping("/editar/{id}")
      public String editarForm(@PathVariable("id") Integer id, Model model) {
      Disciplina disciplina = disciplinaService.findById(id);
      model.addAttribute("disciplina", disciplina);
      List<Curso> cursos = cursoService.findAll();
       model.addAttribute("cursos", cursos);
      List<Professor> professores = professorService.findAll();
       model.addAttribute("professores", professores);
      return "disciplina/formularioDisciplina";
      }
    }