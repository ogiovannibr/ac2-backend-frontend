package com.example.demo.service;

import com.example.demo.model.Setor;
import com.example.demo.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorService {

    @Autowired
    private SetorRepository setorRepository;

    public List<Setor> listarTodos() {
        return setorRepository.findAll();
    }

    public Setor salvar(Setor setor) {
        return setorRepository.save(setor);
    }

    public Setor buscarPorId(Integer id) {
        return setorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Setor não encontrado"));
    }
}
