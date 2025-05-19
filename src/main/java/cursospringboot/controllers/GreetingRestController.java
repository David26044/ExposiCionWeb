
package cursospringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST que gestiona los saludos personalizados.
 * Esta clase proporciona endpoints para generar mensajes de saludo
 * personalizados basados en el nombre proporcionado.
 */
@RestController
public class GreetingRestController {

    /**
     * Genera un saludo personalizado con el nombre proporcionado.
     *
     * @param name El nombre de la persona a quien se desea saludar
     * @return String Un mensaje de saludo personalizado que incluye el nombre proporcionado
     *
     * Ejemplo de uso: GET /saludo/Juan retornará "Hola Juan"
     */
    @GetMapping("/saludo/{name}")
    public String greeting(@PathVariable String name) {
        return "Hola " + name;
    }
}