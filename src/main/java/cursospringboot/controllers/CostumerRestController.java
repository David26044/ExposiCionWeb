package cursospringboot.controllers;

import cursospringboot.domain.Costumer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Controlador REST para la gestión de clientes.
 * Proporciona endpoints para operaciones CRUD (Crear, Leer, Actualizar y Eliminar)
 * relacionadas con la información de los clientes.
 */
@RestController
@RequestMapping("/clientes")
public class CostumerRestController {

    /**
     * Lista de clientes inicializada con datos predefinidos.
     * Almacena una colección de objetos Costumer, donde cada uno representa
     * un cliente específico con atributos como ID, nombre, nombre de usuario y contraseña.
     */
    private List<Costumer> costumers = new ArrayList<>(Arrays.asList(
            new Costumer(123, "Gerardo Lopez", "gerardol", "contraseña123"),
            new Costumer(456, "ALejandra Garcia", "alegarcia", "clave456"),
            new Costumer(789, "Laura Sanchez", "lauras", "secreto789"),
            new Costumer(234, "Carlos Martinez", "carlosm", "password234")
    ));

    /**
     * Obtiene la lista completa de todos los clientes.
     * @return ResponseEntity con la lista de clientes y estado HTTP 200 (OK)
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Costumer>> getCostumers() {
        return ResponseEntity.ok(costumers);
    }

    /**
     * Busca y retorna un cliente específico por su nombre de usuario.
     * @param username El nombre de usuario del cliente a buscar
     * @return ResponseEntity con el cliente encontrado o un mensaje de error si no existe
     */
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseEntity<?> getCostumer(@PathVariable String username) {
        for (Costumer costumer : costumers) {
            if (costumer.getUsername().equals(username)) {
                return ResponseEntity.ok(costumer);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con username: " + username);
    }

    /**
     * Crea un nuevo cliente en el sistema.
     * @param costumer El objeto cliente a crear
     * @return ResponseEntity con la URI de acceso al nuevo recurso y el cliente creado
     */
    @PostMapping
    public ResponseEntity<?> postCostumer(@RequestBody Costumer costumer) {
        costumers.add(costumer);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(costumer.getUsername())
                .toUri();
        return ResponseEntity.created(location).body(costumer);
    }

    /**
     * Actualiza completamente la información de un cliente existente.
     * @param costumer El objeto cliente con la información actualizada
     * @return ResponseEntity con estado 204 (No Content) si se actualizó correctamente,
     *         o 404 (Not Found) si no se encontró el cliente
     */
    @PutMapping
    public ResponseEntity<?> putCostumer(@RequestBody Costumer costumer) {
        for(Costumer c : costumers) {
            if(c.getID() == costumer.getID()) {
                c.setUsername(costumer.getName());
                c.setUsername(costumer.getUsername());
                c.setPassword(costumer.getPassword());
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Elimina un cliente del sistema por su ID.
     * @param ID El identificador del cliente a eliminar
     * @return ResponseEntity con estado 204 (No Content) si se eliminó correctamente,
     *         o 404 (Not Found) si no se encontró el cliente
     */
    @DeleteMapping("/{ID}")
    public ResponseEntity<?> deleteCostumer(@PathVariable int ID) {
        for(Costumer c : costumers) {
            if(c.getID() == ID) {
                costumers.remove(c);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Actualiza parcialmente la información de un cliente existente.
     * Solo actualiza los campos que no son nulos en el objeto recibido.
     * @param costumer El objeto cliente con los campos a actualizar
     * @return ResponseEntity con mensaje de éxito y estado 200 (OK) si se actualizó correctamente,
     *         o estado 404 (Not Found) si no se encontró el cliente
     */
    @PatchMapping
    public ResponseEntity<?> patchCostumer(@RequestBody Costumer costumer) {
        for(Costumer c : costumers) {
            if(c.getID() == costumer.getID()) {
                if(costumer.getName() != null) {
                    c.setName(costumer.getName());
                }
                if(costumer.getUsername() != null) {
                    c.setUsername(costumer.getUsername());
                }
                if(costumer.getPassword() != null) {
                    c.setPassword(costumer.getPassword());
                }
                return ResponseEntity.ok("Cliente modificado satisfactoriamente: " + costumer.getID());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con el ID: " + costumer.getID());
    }
}