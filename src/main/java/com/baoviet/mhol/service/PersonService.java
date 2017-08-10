package com.baoviet.mhol.service;

import com.baoviet.mhol.persistence.dao.IPersonDAO;
import com.baoviet.mhol.persistence.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Service
@Transactional
public class PersonService {

    @Autowired
    private IPersonDAO personDAO;

    @PersistenceContext
    private EntityManager entityManager;

    public void savePerson(Person person) {
        personDAO.save(person);
//        entityManager.persist(person);
    }
}
