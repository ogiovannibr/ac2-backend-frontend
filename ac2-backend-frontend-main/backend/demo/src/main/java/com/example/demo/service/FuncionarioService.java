package com.example.demo.service;

import com.example.demo.dto.FuncionarioDTO;
import com.example.demo.exception.RecursoNaoEncontradoException;
import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioDTO> listarTodos() {
        return funcionarioRepository.findAll()
                .stream()
                .map(funcionario -> new FuncionarioDTO(funcionario.getId(), funcionario.getNome(), null, null))
                .collect(Collectors.toList());
    }

    public FuncionarioDTO buscarPorId(Integer id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Funcionário não encontrado"));
        return new FuncionarioDTO(funcionario.getId(), funcionario.getNome(), null, null);
    }

    public FuncionarioDTO salvar(FuncionarioDTO dto) {
        Funcionario novoFuncionario = new Funcionario(null, dto.getNome(), null);
        funcionarioRepository.save(novoFuncionario);
        return new FuncionarioDTO(novoFuncionario.getId(), novoFuncionario.getNome(), null, null);
    }

    public void excluir(Integer id) {
        funcionarioRepository.deleteById(id);
    }
}
