package com.example.demo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjetoDTO {
    private Integer id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
