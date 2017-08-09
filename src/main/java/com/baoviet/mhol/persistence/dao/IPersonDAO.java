package com.baoviet.mhol.persistence.dao;

import com.baoviet.mhol.persistence.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPersonDAO extends CrudRepository<Person, Long> {
    Person findByFirstName( String name );
}
