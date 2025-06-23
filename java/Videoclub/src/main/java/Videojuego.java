public class Videojuego extends Producto {
    private String estilo;
    private String plataforma;

    public Videojuego(String nombre, double costoRenta, int dias, boolean rentado, String estilo, String plataforma) {
        super(nombre, costoRenta, dias, rentado);
        this.estilo = estilo;
        this.plataforma = plataforma;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        return super.toString() + ", Estilo: " + estilo + ", Plataforma: " + plataforma;
    }
}