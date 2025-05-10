package ejercicio1;

public class LibroInfantil extends Libro {

    public static final double MONTO_BASE_INFANTIL = 1.5;
    public static final int DIAS_MINIMO_INFANTIL = 3;
    public static final double COEFICIENTE_MONTO_INFANTIL = 1.5;

    public LibroInfantil(String nombre, int priceCode) {
        super(nombre, priceCode);
    }

    @Override
    double calcularMonto(int diasAlquilados, double monto) {
        monto += MONTO_BASE_INFANTIL;
        if (diasAlquilados > DIAS_MINIMO_INFANTIL)
            monto += (diasAlquilados - DIAS_MINIMO_INFANTIL) * COEFICIENTE_MONTO_INFANTIL;

        return monto;
    }

    @Override
    int sumarPuntosFrecuente(int diasAlquilados) {
        return 0;
    }

}
