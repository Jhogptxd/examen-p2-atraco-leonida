public abstract class Integrante {
    private String nombre;
    protected int nivel;
    protected int pago;

    public Integrante(String nombre, int nivel, int pago) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.pago = pago;
    }

    public String getNombre() { return nombre; }
    public int getNivel() { return nivel; }
    public int getPago() { return pago; }

    public void presentarse() {
        System.out.println(nombre + " (nivel " + nivel + ") cobra $" + pago);
    }

    public abstract String rol();

    public void ficha() {
        System.out.println("[" + rol() + "] " + nombre);
    }
}
