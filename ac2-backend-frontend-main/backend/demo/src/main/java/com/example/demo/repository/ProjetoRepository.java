package com.example.demo.repository;

import com.example.demo.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

    List<Projeto> findByDescricaoContaining(String palavra);
}
