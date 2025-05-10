package ejercicio1;

public class LibroNuevoLanzamiento extends Libro{

    public static final int COEFICIENTE_MONTO_NUEVO_LANZAMIENTO = 3;
    public static final int PUNTOS_FRECUENTE = 1;
    public static final int DIAS_MINIMO = 1;

    public LibroNuevoLanzamiento(String nombre, int priceCode) {
        super(nombre, priceCode);
    }

    @Override
    double calcularMonto(int diasAlquilados, double monto) {
        return monto += diasAlquilados * COEFICIENTE_MONTO_NUEVO_LANZAMIENTO;
    }

    @Override
    int sumarPuntosFrecuente(int diasAlquilados) {
        if (diasAlquilados > DIAS_MINIMO){
            return PUNTOS_FRECUENTE;
        }
        return 0;

    }
}
