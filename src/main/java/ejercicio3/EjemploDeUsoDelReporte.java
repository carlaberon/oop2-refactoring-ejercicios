package ejercicio3;

import java.util.List;

public class EjemploDeUsoDelReporte {
    public static void main(String[] args) {
        var reporte = new ReporteDeGastos(List.of(new Desayuno(1000)));
        String reporteImpreso = reporte.generarReporte();
        System.out.println(reporteImpreso);
    }
}