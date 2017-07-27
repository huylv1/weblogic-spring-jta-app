package com.baoviet.mhol.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by levietcongitsol on 7/25/2017.
 */
@Controller
public class PersonController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @PostMapping("/person")
    @ResponseBody
    public String create(@ModelAttribute Person person) {
        log.info("Submitted person {}", person);
        return person.toString();
    }
}
