package it.unito.spring1.controller;

import it.unito.spring1.model.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

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
        return List.of(new Persona("a","b"),
                new Persona("c","d"));
    }
}
