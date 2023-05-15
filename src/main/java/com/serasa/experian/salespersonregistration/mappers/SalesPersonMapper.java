package com.serasa.experian.salespersonregistration.mappers;

import com.serasa.experian.salespersonregistration.dtos.SalesPersonDTO;
import com.serasa.experian.salespersonregistration.entities.SalesPersonEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SalesPersonMapper {

    private final ModelMapper modelMapper;

    public SalesPersonMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public SalesPersonEntity toEntity(SalesPersonDTO salesPersonDTO) {
        return modelMapper.map(salesPersonDTO, SalesPersonEntity.class);
    }
}
