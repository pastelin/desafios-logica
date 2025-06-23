public class Producto {
    private String nombre;
    private double costoRenta;
    private int dias;
    private boolean rentado;

    public Producto(String nombre, double costoRenta, int dias, boolean rentado) {
        this.nombre = nombre;
        this.costoRenta = costoRenta;
        this.dias = dias;
        this.rentado = rentado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCostoRenta() {
        return costoRenta;
    }

    public void setCostoRenta(double costoRenta) {
        this.costoRenta = costoRenta;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public boolean isRentado() {
        return rentado;
    }

    public void setRentado(boolean rentado) {
        this.rentado = rentado;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Costo Renta: " + costoRenta + ", Días: " + dias + ", Rentado: " + (rentado ? "Sí" : "No");
    }
}