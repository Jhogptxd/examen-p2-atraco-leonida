import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("===== ATRACO EN LEONIDA: PLAN DEL GOLPE =====");

        int[] botines = {4500, 1200, 8000, 3000, 6500};
        String[] etapas = {"Reconocimiento", "Ingreso", "Caja fuerte", "Escape", "Lavado"};
        System.out.println("Etapas del golpe: " + botines.length);

        int total = 0;
        int mayor = botines[0];
        int posMayor = 0;
        for (int i = 0; i < botines.length; i++) {
            total = total + botines[i];
            if (botines[i] > mayor) {
                mayor = botines[i];
                posMayor = i;
            }
        }
        double promedio = total / (double) botines.length;
        System.out.println("Total del botin: $" + total);
        System.out.println("Promedio por etapa: $" + promedio);
        System.out.println("Etapa mas rentable: " + etapas[posMayor] + " ($" + mayor + ")");

        Scanner sc = new Scanner(System.in);
        int indice = -1;
        boolean valido = false;
        while (!valido) {
            System.out.print("Numero de etapa (0 a " + (botines.length - 1) + "): ");
            if (sc.hasNextInt()) {
                indice = sc.nextInt();
                if (indice >= 0 && indice < botines.length) {
                    valido = true;
                } else {
                    System.out.println("Error: indice fuera de rango: " + indice);
                }
            } else {
                System.out.println("Error: debes escribir un numero, no " + sc.next());
            }
        }
        System.out.println(etapas[indice] + " deja $" + botines[indice]);

        String[] zonas = {"Ambrosia", "Grassrivers", "Port Gellhorn"};
        String[] turnos = {"Madrugada", "Manana", "Tarde", "Noche"};
        int[][] policias = {
                {2, 5, 3, 1},
                {4, 4, 6, 2},
                {2, 2, 3, 3}
        };
        System.out.println("Matriz de " + policias.length + " zonas x " + policias[0].length + " turnos");

        int[] totalZonas = new int[policias.length];
        int minimo = policias[0][0];
        int filaMin = 0;
        int colMin = 0;
        for (int f = 0; f < policias.length; f++) {
            int sumaZona = 0;
            for (int c = 0; c < policias[f].length; c++) {
                sumaZona = sumaZona + policias[f][c];
                if (policias[f][c] < minimo) {
                    minimo = policias[f][c];
                    filaMin = f;
                    colMin = c;
                }
            }
            totalZonas[f] = sumaZona;
            System.out.println(zonas[f] + ": " + sumaZona + " policias");
        }

        int menor = totalZonas[0];
        int posMenor = 0;
        for (int i = 0; i < totalZonas.length; i++) {
            if (totalZonas[i] < menor) {
                menor = totalZonas[i];
                posMenor = i;
            }
        }
        System.out.println("Zona menos vigilada: " + zonas[posMenor] + " (" + menor + ")");
        System.out.println("Mejor ventana: " + zonas[filaMin] + " en turno " + turnos[colMin] + " (valor minimo: " + minimo + ")");

        ArrayList<String> mochila = new ArrayList<>();
        mochila.add("Mascara");
        mochila.add("Taladro");
        mochila.add("Radio");
        mochila.add("Explosivo");
        System.out.println("Items: " + mochila.size());
        System.out.println("Segundo item: " + mochila.get(1));
        mochila.remove(1);
        System.out.println("Tras remove(1): " + mochila.size() + " items, segundo: " + mochila.get(1));

        System.out.println("Mochila final:");
        for (String item : mochila) {
            System.out.println(" - " + item);
        }

        Conductor lucia = new Conductor("Lucia", 8, 3000, "Pegassi Zorrusso");
        Conductor jason = new Conductor("Jason", 6, 2500, "Karin Sultan");
        Integrante cuervo = new Conductor("Cuervo", 9, 4000, "Coil Brawler");
        lucia.presentarse();
        jason.presentarse();
        lucia.entrenar(1);
        jason.entrenar(5);
        System.out.println("Nivel de Lucia tras entrenar 1: " + lucia.getNivel());
        System.out.println("Nivel de Jason tras entrenar 5: " + jason.getNivel());

        cuervo.presentarse();

        lucia.ficha();
        jason.ficha();
        cuervo.ficha();

        Golpe banco = new Golpe("Banco de Leonida", 2);
        Golpe joyeria = new Golpe("Joyeria Vice", 4);
        System.out.println("Reclutar a Lucia en Banco de Leonida: " + banco.reclutar(lucia));
        System.out.println("Reclutar a Jason en Banco de Leonida: " + banco.reclutar(jason));
        System.out.println("Reclutar a Cuervo en Banco de Leonida: " + banco.reclutar(cuervo));
        banco.mostrarEquipo();

        System.out.println("Reclutar a Cuervo en Joyeria Vice: " + joyeria.reclutar(cuervo));
        System.out.println("Pago total Banco de Leonida: $" + banco.pagoTotal());
        System.out.println("Pago total Joyeria Vice: $" + joyeria.pagoTotal());
        banco.comparar(joyeria);

        sc.close();
    }
}