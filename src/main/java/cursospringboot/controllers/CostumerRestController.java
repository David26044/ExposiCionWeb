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

@RestController
@RequestMapping("/clientes")
public class CostumerRestController {

    private List<Costumer> costumers = new ArrayList<>(Arrays.asList(
            new Costumer(123, "Gerardo Lopez", "gerardol", "contraseña123"),
            new Costumer(456, "ALejandra Garcia", "alegarcia", "clave456"),
            new Costumer(789, "Laura Sanchez", "lauras", "secreto789"),
            new Costumer(234, "Carlos Martinez", "carlosm", "password234")
    ));

    @RequestMapping(method = RequestMethod.GET)
    //@GetMapping
    public ResponseEntity<List<Costumer>> getCostumers() {
        //return costumers;
        return ResponseEntity.ok(costumers);
    }
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    //@GetMapping("/{username}")
    public ResponseEntity<?> getCostumer(@PathVariable String username) {
        for (Costumer costumer : costumers) {
            if (costumer.getUsername().equals(username)) {
                //return costumer;
                return ResponseEntity.ok(costumer);
            }
        }
        //return null;
        return ResponseEntity.status(HttpStatus.NOT_FOUND). body("CLiente no encontrado con username: " + username);
    }

    /*
    * Recibe solicitudes post
    * recibe un JSON y lo transforma para agregarlo a la lista
    * */
    @PostMapping
    public ResponseEntity<?> postCostumer(@RequestBody Costumer costumer) {
        costumers.add(costumer);
        //return costumer;
        //return ResponseEntity.status(HttpStatus.CREATED).body("CLiente con username: " + costumer.getUsername());

        //La URL para consultarlo con el GET, se consulta en GET con su nombre de usuario
        URI location = ServletUriComponentsBuilder
                //Toma la infromacion de la URI de la solicitud actual, toma la URL de la solicitud que se está procesando
                .fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(costumer.getUsername())
                .toUri();

        //No devuelve nada
        //return ResponseEntity.created(location).build();
        //devuelve el recurso creado
        return ResponseEntity.created(location).body(costumer);
    }

    @PutMapping
    public ResponseEntity<?> putCostumer(@RequestBody Costumer costumer){
        for(Costumer c : costumers){
           if(c.getID() == costumer.getID()){
               c.setUsername(costumer.getName());
               c.setUsername(costumer.getUsername());
               c.setPassword(costumer.getPassword());
               //return c;
               return ResponseEntity.noContent().build();
           }
        }
        //return null;
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{ID}")
    public ResponseEntity<?> deleteCostumer(@PathVariable int ID) {
        for(Costumer c : costumers){
            if(c.getID() == ID){
                costumers.remove(c);
                //return c;
                return ResponseEntity.noContent().build();
            }
        }
        //return null;
        return ResponseEntity.notFound().build();
    }

    @PatchMapping
    public ResponseEntity<?> patchCostumer(@RequestBody Costumer costumer) {
        for(Costumer c : costumers){
            if(c.getID() == costumer.getID()){

                if(costumer.getName() != null){
                    c.setName(costumer.getName());
                }
                if(costumer.getUsername() != null){
                    c.setUsername(costumer.getUsername());
                }
                if(costumer.getPassword() != null){
                    c.setPassword(costumer.getPassword());
                }
                //return c;
                return ResponseEntity.ok("Cliente modificado satisfactoriamente: " + costumer.getID());
            }
        }
        //return null;
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CLiente no encontrado con el ID: " + costumer.getID());
    }

}
