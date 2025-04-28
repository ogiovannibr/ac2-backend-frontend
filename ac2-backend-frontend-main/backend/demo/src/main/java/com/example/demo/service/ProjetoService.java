package com.example.demo.service;

import com.example.demo.dto.ProjetoDTO;
import com.example.demo.exception.RecursoNaoEncontradoException;
import com.example.demo.model.Projeto;
import com.example.demo.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public Projeto salvar(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public List<ProjetoDTO> listarTodos() {
        return projetoRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public ProjetoDTO buscarProjetoPorId(Integer id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Projeto não encontrado"));
        return converterParaDTO(projeto);
    }

    public List<ProjetoDTO> buscarPorDescricao(String descricao) {
        List<Projeto> projetos = projetoRepository.findByDescricaoContaining(descricao);
        if (projetos.isEmpty()) {
            throw new RecursoNaoEncontradoException("Nenhum projeto encontrado com essa descrição");
        }
        return projetos.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    private ProjetoDTO converterParaDTO(Projeto projeto) {
        ProjetoDTO dto = new ProjetoDTO();
        dto.setId(projeto.getId());
        dto.setDescricao(projeto.getDescricao());
        dto.setDataInicio(projeto.getDataInicio());
        dto.setDataFim(projeto.getDataFim());
        return dto;
    }
}
