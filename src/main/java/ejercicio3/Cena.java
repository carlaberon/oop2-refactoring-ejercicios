package ejercicio3;

public class Cena implements Gasto {
    int monto;
    String nombre = "Cena";
    public Cena(int monto){
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
        if (this.monto > 5000){
            return "X";
        }
        return " ";
    }

}
