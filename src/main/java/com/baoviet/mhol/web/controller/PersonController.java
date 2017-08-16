package com.baoviet.mhol.web.controller;

import com.baoviet.mhol.persistence.dao.IPersonDAO;
import com.baoviet.mhol.persistence.dao.PersonSpecs;
import com.baoviet.mhol.persistence.model.Person;
import com.baoviet.mhol.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by levietcongitsol on 7/25/2017.
 */
@RestController
@RequestMapping("/api")
public class PersonController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private IPersonDAO personDAO;

    @RequestMapping(value = "/person")
    public Page<Person> firstNameStartWith(@RequestParam("firstNameStartWith") String s, Pageable p) {
        return personDAO.findAll(PersonSpecs.isFirstNameStartWith(s), p);
    }

}
