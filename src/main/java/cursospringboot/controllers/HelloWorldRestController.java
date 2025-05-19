package cursospringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST que muestra un mensaje "Hello World" a través de diferentes rutas.
 * Escucha en el puerto 8080 y responde a las rutas: /hello, /hw y /hola.
 */
@RestController
public class HelloWorldRestController {

    /**
     * Maneja solicitudes GET y retorna un saludo simple.
     *
     * Ejemplo: http://localhost:8080/hello -> retorna "Hello World!"
     *
     * @return String mensaje "Hello World!"
     */
    @GetMapping({"/hello", "/hw", "/hola"})
    public String helloWorld() {
        System.out.println("Solicitud ejecutada");
        return "Hello World!";
    }
}