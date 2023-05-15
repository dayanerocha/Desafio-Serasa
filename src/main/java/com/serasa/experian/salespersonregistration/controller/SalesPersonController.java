package com.serasa.experian.salespersonregistration.controller;

import com.serasa.experian.salespersonregistration.dtos.SalesPersonDTO;
import com.serasa.experian.salespersonregistration.dtos.SalesTerritoryDTO;
import com.serasa.experian.salespersonregistration.entities.SalesPersonEntity;
import com.serasa.experian.salespersonregistration.services.SalesPersonService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/salesPerson")
public class SalesPersonController {
    private final SalesPersonService salesPersonService;

    public SalesPersonController(SalesPersonService salesPersonService) {
        this.salesPersonService = salesPersonService;
    }

    @GetMapping("/vendedor")
    public ResponseEntity<List<SalesPersonEntity>> listAllSalesPersons() {

        List<SalesPersonEntity> result = salesPersonService.listAllSalesPersons();

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/vendedor/{id}")
    public ResponseEntity<SalesPersonEntity> listSalesPersonsById(@PathVariable Long id) {

        SalesPersonEntity result = salesPersonService.listSalesPersonsById(id);

        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/vendedor")
    public ResponseEntity<SalesPersonEntity> createSalesPerson(@Valid @RequestBody SalesPersonDTO salesPersonDTO) {

        SalesPersonEntity result = salesPersonService.createSalesPerson(salesPersonDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/atuacao")
    public ResponseEntity<SalesPersonEntity> updateSalesTerritory(@Valid @RequestBody SalesTerritoryDTO salesTerritoryDTO) {

        SalesPersonEntity result = salesPersonService.updateSalesTerritory(salesTerritoryDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
