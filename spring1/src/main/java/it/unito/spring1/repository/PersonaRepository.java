package it.unito.spring1.repository;

import it.unito.spring1.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaRepository {
    private List<Persona> persone;
    public PersonaRepository(){
        persone = List.of(new Persona("Julio", "Julio"),
                new Persona("Adrian", "A"),
                new Persona("Bob", "B"));
    }
    public List<Persona> getPersone(){
        return persone;
    }
}
