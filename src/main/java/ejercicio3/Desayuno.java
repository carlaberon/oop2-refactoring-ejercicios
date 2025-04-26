package ejercicio3;

public class Desayuno implements Gasto{
    int monto;
    String nombre = "Desayuno";
    public Desayuno(int monto){
        this.monto = monto;
    }
    @Override
    public int sumarMontoComida() {
        return this.monto;
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
        if (monto > 1000){
            return "X";
        }
        return " ";
    }

}
