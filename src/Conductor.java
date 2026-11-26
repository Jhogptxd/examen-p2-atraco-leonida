public class Conductor extends Integrante {
    private String vehiculo;

    public Conductor(String nombre, int nivel, int pago, String vehiculo) {
        super(nombre, nivel, pago);
        this.vehiculo = vehiculo;
    }

    @Override
    public String rol() { return "conductor"; }

    @Override
    public void presentarse() {
        super.presentarse();
        System.out.println("   Escapa en: " + vehiculo);
    }

    public void entrenar(int puntos) {
        nivel = nivel + puntos;
        if (nivel > 10) {
            nivel = 10;
        }
    }
}