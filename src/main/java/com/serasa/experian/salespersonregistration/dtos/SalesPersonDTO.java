package com.serasa.experian.salespersonregistration.dtos;

import com.serasa.experian.salespersonregistration.enums.Region;
import com.serasa.experian.salespersonregistration.enums.State;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO (Data Transfer Object) representing a sales person")
public class SalesPersonDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID of the salesperson")
    private Long id;

    @Schema(description = "Inclusion date of the salesperson")
    private LocalDate dataInclusao;

    @NotNull
    @Schema(description = "Name of the salesperson")
    private String nome;

    @NotNull
    @Schema(description = "Phone number of the salesperson")
    private String telefone;

    @NotNull
    @Schema(description = "Age of the salesperson")
    private Integer idade;

    @NotNull
    @Schema(description = "City of the salesperson")
    private String cidade;

    @NotNull
    @Schema(description = "State of the salesperson")
    private String estado;


    @Schema(description = "State of the salesperson operates")
    private List<State> estados = null;


    @Schema(description = "Region of the salesperson")
    private Region regiao = null;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInclusao() {
        return LocalDate.now();
    }

    public void setDataInclusao(LocalDate dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<State> getEstados() {
        return estados;
    }

    public void setEstados(List<State> estados) {
        this.estados = estados;
    }

    public Region getRegiao() {
        return regiao;
    }

    public void setRegiao(Region regiao) {
        this.regiao = regiao;
    }
}