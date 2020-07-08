package com.project.oglasnik.sales.domain.repository;

import com.project.oglasnik.sales.domain.model.Company;
import com.project.oglasnik.sales.domain.model.CompanyId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<Company, CompanyId> {
    List<Company> findAll();
    Company findByCompanyId(CompanyId id);
}