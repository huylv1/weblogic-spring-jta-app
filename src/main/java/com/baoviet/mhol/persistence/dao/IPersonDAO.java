package com.baoviet.mhol.persistence.dao;

import com.baoviet.mhol.persistence.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface IPersonDAO extends PagingAndSortingRepository<Person, Long> {
    List<Person> findByFirstName(String name );
}
