package ejercicio1;

public class LibroRegular extends Libro{

    public static final int MONTO_BASE = 2;
    public static final int DIAS_MINIMO_REGULARES = 2;
    public static final double COEFICIENTE_MONTO_REGULARES = 1.5;

    public LibroRegular(String nombre, int priceCode) {
        super(nombre, priceCode);
    }

    @Override
    double calcularMonto(int diasAlquilados, double monto) {
        monto += MONTO_BASE;
        if (diasAlquilados > DIAS_MINIMO_REGULARES)
            monto += (diasAlquilados - DIAS_MINIMO_REGULARES) * COEFICIENTE_MONTO_REGULARES;
        return monto;
    }

    @Override
    int sumarPuntosFrecuente(int diasAlquilados) {
        return 0;
    }
}
