package com.baoviet.mhol.web.controller;

import com.baoviet.mhol.persistence.model.Person;
import com.baoviet.mhol.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by levietcongitsol on 7/25/2017.
 */
@Controller
public class PersonController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PersonService personService;

    @PostMapping("/person")
    @ResponseBody
    public String create(@ModelAttribute Person person) {
//        log.info("Submitted person {}", person);
        personService.savePerson(person);
        return person.toString();
    }

//
//    public static void main(String[] args) {
//        ExpressionParser parser = new SpelExpressionParser();
//        Expression exp = parser.parseExpression("'Hello World'");
//        String message = (String) exp.getValue();
//        System.out.println(message);
//
//
//        Person p1 = new Person();
//        p1.setId(1);
//        p1.setName("Person 1");
//
//        Person p2 = new Person();
//        p2.setId(1);
//        p2.setName("Person 2");
//
//        StandardEvaluationContext context = new StandardEvaluationContext();
//        context.setVariable("p1", p1);
//        context.setVariable("p2", p2);
//        System.out.println(parser.parseExpression("#p1.name + ' ' + #p2.name").getValue(context));
//    }
}
