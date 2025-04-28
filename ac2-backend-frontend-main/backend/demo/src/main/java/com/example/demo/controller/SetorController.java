package com.example.demo.controller;

import com.example.demo.model.Setor;
import com.example.demo.service.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setores")
@CrossOrigin(origins = "http://localhost:8081")
public class SetorController {

    @Autowired
    private SetorService setorService;

    @GetMapping
    public List<Setor> getSetores() {
        return setorService.listarTodos();
    }

    @PostMapping
    public Setor adicionarSetor(@RequestBody Setor setor) {
        return setorService.salvar(setor);
    }

    @GetMapping("/{id}")
    public Setor getSetorPorId(@PathVariable Integer id) {
        return setorService.buscarPorId(id);
    }
}
