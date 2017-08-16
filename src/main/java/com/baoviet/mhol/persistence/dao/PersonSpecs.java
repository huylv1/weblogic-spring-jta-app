package com.baoviet.mhol.persistence.dao;

import com.baoviet.mhol.persistence.model.Person;
import com.baoviet.mhol.persistence.model.Person_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class PersonSpecs {
    public static Specification<Person> isFirstNameStartWith(String name) {
        return new Specification<Person>() {
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query,
                                         CriteriaBuilder builder) {

                return builder.like(root.get(Person_.firstName), name + "%");
            }
        };
    }
}
