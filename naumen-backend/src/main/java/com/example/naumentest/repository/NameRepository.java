package com.example.naumentest.repository;

import com.example.naumentest.model.Name;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameRepository extends CrudRepository<Name, Long> {

    Name findByName(String name);

    Name findFirstByAgeGreaterThan(Integer age);

    boolean existsByAgeGreaterThan(Integer age);

    boolean existsByName(String name);

}
