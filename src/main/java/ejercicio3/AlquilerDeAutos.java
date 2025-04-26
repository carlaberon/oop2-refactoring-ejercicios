package ejercicio3;

public class AlquilerDeAutos implements Gasto {
    int monto;
    String nombre = "Alquiler de Autos";
    public AlquilerDeAutos(int monto){
        this.monto = monto;
    }
    @Override
    public int sumarMontoComida() {
        return 0;
    }

    @Override
    public int monto() {
        return this.monto;
    }

    @Override
    public String nombreGasto() {
        return this.nombre;
    }

    @Override
    public String marcaExcesoComidas() {
        return "";
    }

}
