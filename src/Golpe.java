import java.util.ArrayList;

public class Golpe {
    private String nombre;
    private int cupo;
    private ArrayList<Integrante> equipo;

    public Golpe(String nombre, int cupo) {
        this.nombre = nombre;
        this.cupo = cupo;
        this.equipo = new ArrayList<>();
    }

    public boolean reclutar(Integrante i) {
        if (equipo.size() < cupo) {
            equipo.add(i);
            return true;
        }
        return false;
    }

    public void mostrarEquipo() {
        System.out.println("Golpe " + nombre + " (" + equipo.size() + "/" + cupo + ")");
        for (Integrante i : equipo) {
            i.presentarse();
        }
    }

    public int pagoTotal() {
        int total = 0;
        for (Integrante i : equipo) {
            total = total + i.getPago();
        }
        return total;
    }

    public void comparar(Golpe otro) {
        System.out.println(nombre + " (" + equipo.size() + " integrantes) vs "
                + otro.nombre + " (" + otro.equipo.size() + " integrantes)");
    }
}