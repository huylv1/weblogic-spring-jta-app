package com.baoviet.mhol.web.jaxws;

import javax.jws.WebService;

/**
 * Created by levietcongitsol on 7/12/2017.
 */
@WebService
public class Hello {
    public String sayHello(String param) {
          return "Hello " + param;
    }
}