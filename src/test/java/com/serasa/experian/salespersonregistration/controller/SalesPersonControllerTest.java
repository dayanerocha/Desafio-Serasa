package com.serasa.experian.salespersonregistration.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Collections;
import java.util.List;
import com.serasa.experian.salespersonregistration.dtos.SalesPersonDTO;
import com.serasa.experian.salespersonregistration.dtos.SalesTerritoryDTO;
import com.serasa.experian.salespersonregistration.entities.SalesPersonEntity;
import com.serasa.experian.salespersonregistration.services.SalesPersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

class SalesPersonControllerTest {

    @Mock
    private SalesPersonService salesPersonService;

    @InjectMocks
    private SalesPersonController salesPersonController;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListAllSalesPersons() {
        List<SalesPersonEntity> salesPersonEntities = Collections.singletonList(new SalesPersonEntity());
        when(salesPersonService.listAllSalesPersons()).thenReturn(salesPersonEntities);

        ResponseEntity<List<SalesPersonEntity>> result = salesPersonController.listAllSalesPersons();

        verify(salesPersonService).listAllSalesPersons();
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(salesPersonEntities, result.getBody());
    }

    @Test
    void testListSalesPersonsById() {
        Long id = 1L;
        SalesPersonEntity salesPersonEntity = new SalesPersonEntity();
        when(salesPersonService.listSalesPersonsById(id)).thenReturn(salesPersonEntity);

        ResponseEntity<SalesPersonEntity> result = salesPersonController.listSalesPersonsById(id);

        verify(salesPersonService).listSalesPersonsById(id);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(salesPersonEntity, result.getBody());
    }

    @Test
    void testCreateSalesPerson() {
        SalesPersonDTO salesPersonDTO = new SalesPersonDTO();
        SalesPersonEntity salesPersonEntity = new SalesPersonEntity();
        when(salesPersonService.createSalesPerson(salesPersonDTO)).thenReturn(salesPersonEntity);

        ResponseEntity<SalesPersonEntity> result = salesPersonController.createSalesPerson(salesPersonDTO);

        verify(salesPersonService).createSalesPerson(salesPersonDTO);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(salesPersonEntity, result.getBody());
    }

    @Test
    void testCreateSalesPerson_missingRequiredData() {
        SalesPersonDTO salesPersonDTO = new SalesPersonDTO();
        when(salesPersonService.createSalesPerson(salesPersonDTO)).thenThrow(new ResponseStatusException(HttpStatus.BAD_REQUEST));

        assertThrows(ResponseStatusException.class, () -> salesPersonController.createSalesPerson(salesPersonDTO));
    }

    @Test
    void testUpdateSalesTerritory() {
        SalesTerritoryDTO salesTerritoryDTO = new SalesTerritoryDTO();
        SalesPersonEntity salesPersonEntity = new SalesPersonEntity();
        when(salesPersonService.updateSalesTerritory(salesTerritoryDTO)).thenReturn(salesPersonEntity);

        ResponseEntity<SalesPersonEntity> result = salesPersonController.updateSalesTerritory(salesTerritoryDTO);

        verify(salesPersonService).updateSalesTerritory(salesTerritoryDTO);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(salesPersonEntity, result.getBody());
    }

}
