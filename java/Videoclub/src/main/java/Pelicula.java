public class Pelicula extends Producto {
    private String genero;
    private int anio;

    public Pelicula(String nombre, double costoRenta, int dias, boolean rentado, String genero, int anio) {
        super(nombre, costoRenta, dias, rentado);
        this.genero = genero;
        this.anio = anio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return super.toString() + ", Género: " + genero + ", Año: " + anio;
    }
}