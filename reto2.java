import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class reto2 {
    public static void main(String[] args) throws Exception {
        int n;
        int cont = 0;
        float menor = 10000;
        DecimalFormatSymbols separador = new DecimalFormatSymbols();
        separador.setDecimalSeparator('.');
        DecimalFormat formato = new DecimalFormat("0.00", separador);
        Scanner lector = new Scanner(System.in);
        // lee la cantidad de cuerpos de agua y la valida
        n = Integer.parseInt(lector.nextLine().strip());
                

           
        
        // ingresa los valores de los cuerpos de agua.
        CuerpoDeAgua[] cuerpos = new CuerpoDeAgua[n];
        for (int i = 0; i < n; i++) {

            String[] data = lector.nextLine().strip().split(" ");
            // [0] --> cuer;podeagua : String
            // [1] --> id : int
            // [2] --> municipio : string
            // [3] --> clasificacion : float
            CuerpoDeAgua c01 = new CuerpoDeAgua();
            c01.setNombre(data[0]);
            c01.setId(Integer.parseInt(data[1]));
            c01.setMunicipio(data[2]);
            c01.setClasificacion(Float.parseFloat(data[3]));

            cuerpos[i] = c01;
        }
        lector.close();
        for (int i = 0; i < n; i++) {
            System.out.println(cuerpos[i].nivel() + " " + formato.format(cuerpos[i].getId()));
        }
        // indica cuales son los cuerpos de agua que necesitan intervencion de la
        // alcaldia o la gobernacion
        String[] cmedios = new String[cuerpos.length];
        for (int i = 0; i < cuerpos.length; i++) {
            if (cuerpos[i].getClasificacion() > 35) {
                cont++;
            }
            if (cuerpos[i].getClasificacion() > 14 && cuerpos[i].getClasificacion() < 35) {
                cmedios[0] = cuerpos[i].getNombre();
            }
        }

        System.out.println(formato.format(cont));

        for (int i = 0; i < cuerpos.length; i++) {
            if (cuerpos[i].getClasificacion() > 14 && cuerpos[i].getClasificacion() <= 35) {
                System.out.println(formato.format(cuerpos[i].getClasificacion()));
            }

        }
        if (cmedios[0] == null) {
            System.out.println("NA");
        }
        for (int i = 0; i < cuerpos.length; i++) {
            if (cuerpos[i].getClasificacion() < menor) {
                menor = cuerpos[i].getClasificacion();
            }
        }
        System.out.println(formato.format(menor));
    }
}
