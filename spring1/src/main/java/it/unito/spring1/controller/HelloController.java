package it.unito.spring1.controller;

import it.unito.spring1.model.Persona;
import it.unito.spring1.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    PersonaRepository personaRepository;

    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

    @GetMapping("/getPersona")
    public Persona getPersona(){
        return new Persona("a","b");
    }

    @GetMapping("/hellonome/{nome}/{nome2}")
    public String hellonome(@PathVariable String nome,
                            @PathVariable String nome2) {
        return "Hello "+nome+ " and "+nome2+"!";
    }
/*/hellonome2 ?nome=valore & chiave2 = valore2*/
    @GetMapping("/hellonome2")
    public String hellonome2(@RequestParam String nome){
        return "Hello "+nome+"!";
    }

    @GetMapping("/getPersone")
    public List<Persona> getPersone(){
        return personaRepository.getPersone();
    }

    @GetMapping("/findPersona/{nome}")
    public ResponseEntity<Persona> findPersona(@PathVariable String nome){
        Persona persona = personaRepository
                .getPersone()
                .stream()
                .filter(p->p.nome().equals(nome))
                .findFirst().orElse(null);


        if (persona == null) {
            return ResponseEntity.notFound().build();
        }else
            return ResponseEntity.ok().body(persona);
        ResponseEntity.
    }

}
