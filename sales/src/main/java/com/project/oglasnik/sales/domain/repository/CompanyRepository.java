package com.project.oglasnik.sales.domain.repository;

import com.project.oglasnik.sales.domain.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {
    List<Company> findAll();
    Company findByCompanyId(Integer id);
}