package cursospringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* Con esta clase lo que hago es entrar al puerto 80 de localhost
* con la ruta del GetMapping y me muestra el mensaje de retorno. Por ejemplo,
* localhost:8080/hello y así con cualquier valor de GetMapping
* */

@RestController
public class HelloWorldRestController {
    @GetMapping({"/hello", "/hw", "/hola"})
    public String helloWorld() {
        System.out.println("Solicitud ejecutada");
        return "Hello World!";
    }

}
