package com.serasa.experian.salespersonregistration.dtos;

import com.serasa.experian.salespersonregistration.enums.Region;
import com.serasa.experian.salespersonregistration.enums.State;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Schema(description = "DTO (Data Transfer Object) representing a sales territory")
public class SalesTerritoryDTO {

    @Id
    @Schema(description = "ID of the salesperson")
    private Long id;
    @NotNull
    private Region regiao;
    @NotNull
    private List<State> estados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Region getRegiao() {
        return regiao;
    }

    public void setRegiao(Region regiao) {
        this.regiao = regiao;
    }

    public List<State> getEstados() {
        return estados;
    }

    public void setEstados(List<State> estado) {
        this.estados = estado;
    }
}
