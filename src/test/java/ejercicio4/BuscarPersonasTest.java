package ejercicio4;

import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BuscarPersonasTest {
    public void agregarPersona(String personas1, List<Persona> personas){
        for (Persona persona : personas)
        personas1 += persona.nombre() + " " + persona.apellido()+ System.lineSeparator();
    }
    @Test
    void buscarPorNombre(){
    //setup
    Jdbi jdbi = Jdbi.create("jdbc:hsqldb:mem;create=true");
    new SetUpDatabase(jdbi).setUp();
    var repo = new PersonaRepository(jdbi);
    //ejercitación
    var personas = repo.buscarPorNombre("Vla");

    //verify
    assertEquals("Vladimir Varkov", personas);
}
}
