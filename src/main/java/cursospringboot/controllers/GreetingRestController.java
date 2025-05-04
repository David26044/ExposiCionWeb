package cursospringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
* Para mostrar un saludo personalizado.
* */
@RestController
public class GreetingRestController {

    @GetMapping("/saludo/{name}")
    public String greeting(@PathVariable String name) {
        return "Hola " + name;
    }

}
