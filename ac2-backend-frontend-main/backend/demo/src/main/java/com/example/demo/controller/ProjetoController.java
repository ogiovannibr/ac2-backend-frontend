package com.example.demo.controller;

import com.example.demo.dto.ProjetoDTO;
import com.example.demo.model.Projeto;
import com.example.demo.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
@CrossOrigin(origins = "http://localhost:8081")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;
   
    @GetMapping
    public List<ProjetoDTO> getProjetos() {
        return projetoService.listarTodos();
    }
    
    @PostMapping
    public ProjetoDTO adicionarProjeto(@RequestBody ProjetoDTO projetoDTO) {
     
        Projeto projeto = new Projeto();
        projeto.setDescricao(projetoDTO.getDescricao());
        projeto.setDataInicio(projetoDTO.getDataInicio());
        projeto.setDataFim(projetoDTO.getDataFim());

       
        Projeto projetoSalvo = projetoService.salvar(projeto);

  
        ProjetoDTO dto = new ProjetoDTO();
        dto.setId(projetoSalvo.getId());
        dto.setDescricao(projetoSalvo.getDescricao());
        dto.setDataInicio(projetoSalvo.getDataInicio());
        dto.setDataFim(projetoSalvo.getDataFim());

        return dto;
    }

    @GetMapping("/{id}")
    public ProjetoDTO buscarProjetoPorId(@PathVariable Integer id) {
        return projetoService.buscarProjetoPorId(id);
    }

    @GetMapping("/buscar")
    public List<ProjetoDTO> buscarProjetosPorDescricao(@RequestParam String descricao) {
        return projetoService.buscarPorDescricao(descricao);
    }
}
