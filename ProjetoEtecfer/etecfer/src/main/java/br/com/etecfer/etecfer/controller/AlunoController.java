package br.com.etecfer.etecfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.etecfer.etecfer.entity.Aluno;
import br.com.etecfer.etecfer.service.AlunoService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;








@Controller
@RequestMapping("/alunos")
public class AlunoController {
    
    // Injeção de depenedentes da service para a classe aluno
    @Autowired
    private AlunoService alunoService;

    // Metodo para salvar um aluno 
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Aluno aluno) {
        alunoService.save(aluno);
        return "redirect:/alunos/listar";
    }
     
    @GetMapping("/listar")
    public String listar(Model  model) {
        List<Aluno> alunos = alunoService.findAll();
        model.addAttribute("alunos", alunos);
        return "aluno/listarAlunos";
    }

    // Metodo para criar um formulario com um novo objeto aluno
    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "aluno/formularioAluno";
    }
    // Metodo para Excluir um Aluno
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id) {
        alunoService.deleteById(id);
        return "redirect:/alunos/listar";
    }
    // Metodo para abrir o formulario de edição de alunos 
    @GetMapping("/editar/{id}")
    public String  editarForm(@PathVariable("id")  Integer id, Model model) 
    {Aluno aluno = alunoService.findById(id);
        model.addAttribute("aluno", aluno);
        return "aluno/formularioAluno";
    }
    
    
}
