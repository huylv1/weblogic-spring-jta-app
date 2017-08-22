package com.baoviet.mhol.web.controller;

import com.baoviet.mhol.persistence.dao.IPersonDAO;
import com.baoviet.mhol.persistence.dao.PersonSpecs;
import com.baoviet.mhol.persistence.model.Person;
import com.baoviet.mhol.service.PersonService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public HttpEntity<PagedResources<Resource<Person>>> firstNameStartWith(@RequestParam("firstNameStartWith") String s,
                                                                           Pageable pageable, PagedResourcesAssembler<Person> assembler) {

        Page<Person> resources = personDAO.findAll(PersonSpecs.isFirstNameStartWith(s), pageable);
        return new ResponseEntity<PagedResources<Resource<Person>>>(assembler.toResource(resources), HttpStatus.OK);
    }

}
