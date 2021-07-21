import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class reto1 {
    public static void main(String[] args) throws Exception {
        String[] clasificacion;
        float[] numero;
        float promedio;
        int n;
        int i, j;
        String[] tmp;
        int suma = 0;
        String datos;
        float c_alta;
        float c_baja;
        float mayor = 0, menor = 10000;
        DecimalFormatSymbols separador = new DecimalFormatSymbols();
        separador.setDecimalSeparator('.');
        DecimalFormat formato = new DecimalFormat("#.00", separador);
        Scanner reader = new Scanner(System.in);
        do {
            try {

                n = reader.nextInt();
                if (n <= 0)
                    System.out.println("Por favor introduzca un entero > 0");
            } catch (Exception e) {

                n = -10;
                // Prevenir un error que el scanner no vuelve a leer datos
                if (reader.hasNextLine())
                    reader.nextLine();
            }
        } while (n < 0);
        reader.nextLine();
        numero = new float[n];
        do {
            datos = reader.nextLine();
            tmp = datos.split(" ");
        } while (n != tmp.length);

        for (i = 0; i < tmp.length; i++) {
            numero[i] = Integer.parseInt(String.valueOf(tmp[i]));
            suma += numero[i];
        }
        promedio = suma / n;

        if (promedio >= 0 && promedio < 5) {
            System.out.println("SIN RIESGO");
        } else if (promedio >= 5 && promedio < 14) {
            System.out.println("BAJO");

        } else if (promedio >= 14 && promedio < 35) {
            System.out.println("MEDIO");

        } else if (promedio >= 35 && promedio < 80) {
            System.out.println("ALTO");

        } else if (promedio >= 80 && promedio < 100) {
            System.out.println("INVIABLE SANITARIAMENTE");

        }
        for (j = 0; j < numero.length; j++) {
            if (numero[j] > mayor) {
                if (numero[j] >= 14 && numero[j] < 35) {
                    mayor = numero[j];
                } else if (numero[j] < 14 && numero[j] >= 35) {
                    System.out.println("NA");
                }

            }
            if (numero[j] < menor) {
                if (numero[j] > 14 && numero[j] < 35) {
                    menor = numero[j];
                } else if (numero[j] < 14 && numero[j] >= 35) {
                    System.out.println("NA");
                }
            }
        }
        System.out.println(formato.format(menor));
        System.out.println(formato.format(mayor));
        reader.close();

    }

}
