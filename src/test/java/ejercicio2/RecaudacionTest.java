package ejercicio2;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RecaudacionTest {

    @Test
    public void testWhereGivenCompany() throws IOException {
        var r1 = new Recaudacion(new LectorCVS("src/main/resources/data.csv"));
        var resultado = r1.filtrarPor("company_name", "Facebook").where();
        assertEquals(resultado.size(), 7);
    }

    @Test
    public void testWhereGivenCity() throws IOException {
        var r1 = new Recaudacion(new LectorCVS("src/main/resources/data.csv"));
        var resultado = r1.filtrarPor("city", "Tempe").where();
        assertEquals(resultado.size(), 3);
    }

    @Test
    public void testWhereGivenState() throws IOException {
        var r1 = new Recaudacion(new LectorCVS("src/main/resources/data.csv"));
        var resultado = r1.filtrarPor("state", "CA").where();
        assertEquals(resultado.size(), 873);
    }

    @Test
    public void testWhereGivenRound() throws IOException {
        var r1 = new Recaudacion(new LectorCVS("src/main/resources/data.csv"));
        var resultado = r1.filtrarPor("round", "a").where();
        assertEquals(resultado.size(), 582);
    }

    @Test
    public void testMultipleOptions() throws IOException {
        var r1 = new Recaudacion(new LectorCVS("src/main/resources/data.csv"));
        //Interfaces fluidas, Fluent API
      List<Map<String, String>> resultado =  r1.filtrarPor("round", "a")
                .filtrarPor("company_name", "Facebook")
                .where();
        assertEquals(resultado.size(), 1);
    }

    @Test
    public void testWhereNotExists() throws IOException {
        var r1 = new Recaudacion(new LectorCVS("src/main/resources/data.csv"));
        var resultado = r1.filtrarPor("company_name", "NotFacebook").where();
        assertEquals(resultado.size(), 0);
    }

    @Test
    public void testWhereCorrectKeys() throws IOException {
        Map<String, String> options = new HashMap<String, String>();
        options.put("company_name", "Facebook");
        var r1 = new Recaudacion(new LectorCVS("src/main/resources/data.csv"));
        Map<String, String> row = r1.filtrarPor("company_name", "Facebook").where().get(0);
        assertEquals(row.get("permalink"), "facebook");
        assertEquals(row.get("company_name"), "Facebook");
        assertEquals(row.get("number_employees"), "450");
        assertEquals(row.get("category"), "web");
        assertEquals(row.get("city"), "Palo Alto");
        assertEquals(row.get("state"), "CA");
        assertEquals(row.get("funded_date"), "1-Sep-04");
        assertEquals(row.get("raised_amount"), "500000");
        assertEquals(row.get("round"), "angel");

    }
}