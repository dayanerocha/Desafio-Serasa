package com.serasa.experian.salespersonregistration.service;

import com.serasa.experian.salespersonregistration.dtos.SalesPersonDTO;
import com.serasa.experian.salespersonregistration.dtos.SalesTerritoryDTO;
import com.serasa.experian.salespersonregistration.entities.SalesPersonEntity;
import com.serasa.experian.salespersonregistration.enums.Region;
import com.serasa.experian.salespersonregistration.enums.State;
import com.serasa.experian.salespersonregistration.mappers.SalesPersonMapper;
import com.serasa.experian.salespersonregistration.repository.SalesPersonRepository;
import com.serasa.experian.salespersonregistration.services.SalesPersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SalesPersonServiceTest {
    private SalesPersonService salesPersonService;

    @Mock
    private SalesPersonRepository salesPersonRepository;

    @Mock
    private SalesPersonMapper salesPersonMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        salesPersonService = new SalesPersonService(salesPersonRepository, salesPersonMapper);
    }

    @Test
    void testCreateSalesPerson() {

        SalesPersonDTO salesPersonDTO = new SalesPersonDTO();
        SalesPersonEntity salesPersonEntity = new SalesPersonEntity();
        when(salesPersonMapper.toEntity(salesPersonDTO)).thenReturn(salesPersonEntity);
        when(salesPersonRepository.save(salesPersonEntity)).thenReturn(salesPersonEntity);

        SalesPersonEntity result = salesPersonService.createSalesPerson(salesPersonDTO);

        verify(salesPersonMapper).toEntity(salesPersonDTO);
        verify(salesPersonRepository).save(salesPersonEntity);
        assertSame(salesPersonEntity, result);
    }

    @Test
    void testCreateSalesTerritory() {

        SalesTerritoryDTO salesTerritoryDTO = new SalesTerritoryDTO();
        salesTerritoryDTO.setId(1L);
        salesTerritoryDTO.setEstados(Collections.singletonList(State.PB));
        salesTerritoryDTO.setRegiao((Region.NORDESTE));

        SalesPersonEntity salesPersonEntity = new SalesPersonEntity();
        when(salesPersonRepository.findById(1L)).thenReturn(Optional.of(salesPersonEntity));
        when(salesPersonRepository.save(salesPersonEntity)).thenReturn(salesPersonEntity);

        SalesPersonEntity result = salesPersonService.updateSalesTerritory(salesTerritoryDTO);

        verify(salesPersonRepository).findById(1L);
        verify(salesPersonRepository).save(salesPersonEntity);
        assertEquals(Collections.singletonList(State.PB), salesPersonEntity.getEstados());
        assertEquals((Region.NORDESTE), salesPersonEntity.getRegiao());
        assertSame(salesPersonEntity, result);
    }


    @Test
    void testListSalesPersonsById() {
        Long id = 1L;
        SalesPersonEntity salesPersonEntity = new SalesPersonEntity();
        when(salesPersonRepository.findById(id)).thenReturn(Optional.of(salesPersonEntity));

        SalesPersonEntity result = salesPersonService.listSalesPersonsById(id);

        verify(salesPersonRepository).findById(id);
        assertSame(salesPersonEntity, result);
    }

    @Test
    void testListAllSalesPersons() {
        SalesPersonEntity salesPersonEntity = new SalesPersonEntity();
        when(salesPersonRepository.findAll()).thenReturn(Collections.singletonList(salesPersonEntity));

        List<SalesPersonEntity> result = salesPersonService.listAllSalesPersons();

        verify(salesPersonRepository).findAll();
        assertEquals(1, result.size());
        assertSame(salesPersonEntity, result.get(0));
    }
}
