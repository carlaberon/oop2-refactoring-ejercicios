package ejercicio4;

import org.jdbi.v3.core.Jdbi;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Jdbi jdbi = Jdbi.create("jdbc:hsqldb:mem;create=true");
        new SetUpDatabase(jdbi).setUp();
        var repo = new PersonaRepository(jdbi);
        var personas = repo.buscarPorNombre("Vla");

/*        if (personas != null) {
            for (Persona persona : personas) {
                System.out.println(persona.nombre() + " " + persona.apellido());
            }
        }*/
        personas.stream().forEach(persona ->  System.out.println(persona.nombre() + " " + persona.apellido() ));

        Optional<Persona> persona = repo.buscarId(1L);
        persona.ifPresent((persona1)->System.out.println(persona1.nombre() + " " + persona1.apellido()));

//        if (persona != null) {
//            System.out.println(persona.nombre() + " " + persona.apellido());
//        }
    }
}

