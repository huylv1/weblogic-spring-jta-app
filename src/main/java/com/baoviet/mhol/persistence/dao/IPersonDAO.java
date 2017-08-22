package com.baoviet.mhol.persistence.dao;

import com.baoviet.mhol.persistence.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.QueryHint;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface IPersonDAO extends PagingAndSortingRepository<Person, Long>, JpaSpecificationExecutor<Person> {

    @RestResource(path = "names", rel = "names")
    @QueryHints(value = {
            @QueryHint(name = "org.hibernate.cacheable", value = "true"),
            @QueryHint(name = "org.hibernate.cacheMode", value = "NORMAL"),
            @QueryHint(name = "org.hibernate.cacheRegion", value = "personCache")
    })
    Page<Person> findByFirstName(@Param("firstName") @RequestParam("firstName") String firstName, Pageable p);

    @QueryHints(value = {
            @QueryHint(name = "org.hibernate.cacheable", value = "true"),
            @QueryHint(name = "org.hibernate.cacheMode", value = "NORMAL"),
            @QueryHint(name = "org.hibernate.cacheRegion", value = "personCache")
    })
    Page<Person> findAll(Pageable var1);

    @QueryHints(value = {
            @QueryHint(name = "org.hibernate.cacheable", value = "true"),
            @QueryHint(name = "org.hibernate.cacheMode", value = "NORMAL"),
            @QueryHint(name = "org.hibernate.cacheRegion", value = "personCache")
    })
    Page<Person> findAll(Specification<Person> var1, Pageable var2);
}
