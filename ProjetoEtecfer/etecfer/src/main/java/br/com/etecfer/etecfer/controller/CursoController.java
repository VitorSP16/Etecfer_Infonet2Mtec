package br.com.etecfer.etecfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.etecfer.etecfer.entity.Curso;
import br.com.etecfer.etecfer.service.CursoService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.GetMapping;




@Controller
@RequestMapping("/cursos")


public class CursoController {

    //Injeção de depenedentes da service para a classe Curso
    @Autowired
    private CursoService cursoService;

    // Metodo para salvar um Curso 
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Curso curso ) {
        cursoService.save(curso);
        return "redirect:/cursos/listar" ;
    }
    
     // Metodo para criar um formulario com um novo objeto Curso
    @GetMapping("/listar")
    public String listar (Model model) {
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "curso/listarcursos";
    }
      // Metodo para criar um formulario com um novo objeto curso
      @GetMapping("/criar")
      public String criarForm(Model model) {
        model.addAttribute("curso", new Curso());
          return "curso/formularioCurso";
      }
      
       // Metodo para Excluir um cursos
     @GetMapping("/excluir/{id}")
     public String  excluir(@PathVariable("id")  Integer id) {
          cursoService.deleteById(id);
          return "redirect:/cursos/listar";
     }
     
       // Metodo para abrir o formulario de edição de cursos
        @GetMapping("/editar/{id}")
        public String editarForm(@PathVariable("id") Integer id, Model model) {
         Curso curso = cursoService.findById(id);
         model.addAttribute("curso", curso);
            return "curso/formularioCurso";
        }
        
}
