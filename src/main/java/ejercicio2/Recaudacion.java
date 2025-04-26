package ejercicio2;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recaudacion {

    public static final String COMPANY_NAME = "company_name";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String ROUND = "round";
    public static final int INDICE_COMPANYNAME = 1;
    public static final int INDICE_CITY = 4;
    public static final int INDICE_STATE = 5;
    public static final int INDICE_ROUND = 9;
    public static final String PERMALINK = "permalink";
    public static final String NUMBER_EMPLOYEES = "number_employees";
    public static final String CATEGORY = "category";
    public static final String FUNDED_DATE = "funded_date";
    public static final String RAISED_AMOUNT = "raised_amount";
    public static final String RAISED_CURRENCY = "raised_currency";
    private List<String[]> csvData;
    private Map<String, String> filtrosDeBusqueda;
    private Map<String, Integer> mapaNombreIndice;

    public Recaudacion(FuenteDeDatos lectorCVS) {
        this.csvData = lectorCVS.toList();
        this.mapaNombreIndice = Map.of(COMPANY_NAME, INDICE_COMPANYNAME, CITY,INDICE_CITY, STATE, INDICE_STATE, ROUND, INDICE_ROUND);
        this.filtrosDeBusqueda = new HashMap<String, String>();
    }

    public List<Map<String, String>> where()
            throws IOException {

        for (String nombreColumna: this.filtrosDeBusqueda.keySet()){
            List<String[]> results = new ArrayList<>();
            for (String[] csvDatum : csvData) {
                if (csvDatum[this.mapaNombreIndice.get(nombreColumna)].equals(filtrosDeBusqueda.get(nombreColumna))) {
                    results.add(csvDatum);
                }
            }

            csvData = results;
        }

        return crearResultado();
    }

    private List<Map<String, String>> crearResultado() {
        List<Map<String, String>> output = new ArrayList<Map<String, String>>();

        for (int i = 0; i < csvData.size(); i++) {
            Map<String, String> mapped = new HashMap<String, String>();
            mapped.put(PERMALINK, csvData.get(i)[0]);
            mapped.put(COMPANY_NAME, csvData.get(i)[INDICE_COMPANYNAME]);
            mapped.put(NUMBER_EMPLOYEES, csvData.get(i)[2]);
            mapped.put(CATEGORY, csvData.get(i)[3]);
            mapped.put(CITY, csvData.get(i)[INDICE_CITY]);
            mapped.put(STATE, csvData.get(i)[INDICE_STATE]);
            mapped.put(FUNDED_DATE, csvData.get(i)[6]);
            mapped.put(RAISED_AMOUNT, csvData.get(i)[7]);
            mapped.put(RAISED_CURRENCY, csvData.get(i)[8]);
            mapped.put(ROUND, csvData.get(i)[INDICE_ROUND]);
            output.add(mapped);
        }
        return output;
    }

    public Recaudacion filtrarPor(String columnaNombre, String valor) {
        this.filtrosDeBusqueda.put(columnaNombre,valor);
        return this;
    }
}