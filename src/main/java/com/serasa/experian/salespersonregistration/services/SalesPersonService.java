package com.serasa.experian.salespersonregistration.services;

import com.serasa.experian.salespersonregistration.dtos.SalesPersonDTO;
import com.serasa.experian.salespersonregistration.dtos.SalesTerritoryDTO;
import com.serasa.experian.salespersonregistration.entities.SalesPersonEntity;
import com.serasa.experian.salespersonregistration.mappers.SalesPersonMapper;
import com.serasa.experian.salespersonregistration.repository.SalesPersonRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.logging.Logger;


@Service
public class SalesPersonService {

    private final SalesPersonRepository salesPersonRepository;
    private final SalesPersonMapper salesPersonMapper;

    private static final Logger logger = Logger.getLogger(SalesPersonService.class.getName());


    public SalesPersonService(SalesPersonRepository salesPersonRepository, SalesPersonMapper salesPersonMapper) {
        this.salesPersonRepository = salesPersonRepository;
        this.salesPersonMapper = salesPersonMapper;
    }

    public SalesPersonEntity createSalesPerson(SalesPersonDTO salesPersonDTO) {
        logger.info("- - - > Creating sales person: ");
        SalesPersonEntity salesPersonEntity = salesPersonMapper.toEntity(salesPersonDTO);

        return salesPersonRepository.save(salesPersonEntity);

    }

    public SalesPersonEntity updateSalesTerritory(SalesTerritoryDTO salesTerritoryDTO) {
        logger.info("- - - > Updating sales territory: " + salesTerritoryDTO.getId());

        SalesPersonEntity salesPersonEntity = salesPersonRepository.findById(salesTerritoryDTO.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
        ;
        salesPersonEntity.setEstados(salesTerritoryDTO.getEstados());
        salesPersonEntity.setRegiao(salesTerritoryDTO.getRegiao());

        return salesPersonRepository.save(salesPersonEntity);

    }

    public SalesPersonEntity listSalesPersonsById(Long id) {
        logger.info("- - - > Listing sales persons by ID: " + id);

        return salesPersonRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
    }

    public List<SalesPersonEntity> listAllSalesPersons() {
        logger.info("- - - > Listing all sales persons");

        List<SalesPersonEntity> salesPersonEntities = salesPersonRepository.findAll();

        if (salesPersonEntities.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        return salesPersonEntities;
    }

}