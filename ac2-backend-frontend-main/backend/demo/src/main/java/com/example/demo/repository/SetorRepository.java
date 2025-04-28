package com.example.demo.repository;

import com.example.demo.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer> {

    Optional<Setor> findByNome(String nome);

    List<Setor> findByNomeContainingIgnoreCase(String nome);
}
