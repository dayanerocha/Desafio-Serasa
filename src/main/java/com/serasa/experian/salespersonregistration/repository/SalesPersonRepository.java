package com.serasa.experian.salespersonregistration.repository;

import com.serasa.experian.salespersonregistration.entities.SalesPersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesPersonRepository extends JpaRepository<SalesPersonEntity, Long> {

}