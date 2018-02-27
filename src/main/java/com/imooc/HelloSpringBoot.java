package com.imooc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloSpringBoot {

    @Autowired
    private SomeBean someBean;

    @RequestMapping(value="/hi", method = RequestMethod.GET)
    public String helloSpringBoot(@RequestParam("name") String name) {
        return "  name= " +name;
    }
}
