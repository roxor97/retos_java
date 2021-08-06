
import java.text.DecimalFormat;


public class CuerpoDeAgua {
    private String nombre;
    private int id;
    private String municipio;
    private float clasificacion;
    
    DecimalFormat formato = new DecimalFormat("0.00");


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public float getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(float clasificacion) {
        this.clasificacion = clasificacion;
    }

    public CuerpoDeAgua(String nombre, int id, String municipio, float clasificacion) {
        this.nombre = nombre;
        this.id = id;
        this.municipio = municipio;
        this.clasificacion = clasificacion;
    }

    public CuerpoDeAgua() {
    }

    @Override
    public String toString() {
        return "CuerpoDeAgua [clasificacion=" + clasificacion + ", id=" + id + ", municipio=" + municipio + ", nombre="
                + nombre + "]";
    }
    
    public String nivel(){
        String nivelderiesgo;
        if (clasificacion >= 0 && clasificacion <= 5) {
            nivelderiesgo="SIN RIESGO";
            return nivelderiesgo;
            
        } else if (clasificacion > 5 && clasificacion <= 14) {
            nivelderiesgo="BAJO";
            return nivelderiesgo;
            

        } else if (clasificacion > 14 && clasificacion <= 35) {
            nivelderiesgo="MEDIO";
            return nivelderiesgo;
           

        } else if (clasificacion > 35 && clasificacion <= 80) {
            nivelderiesgo="ALTO";
            return nivelderiesgo;
            

        } else if (clasificacion > 80 && clasificacion <= 100) {
            nivelderiesgo="INVIABLE SANITARIAMENTE";
            return nivelderiesgo;
        }
        return("");
    }
    
}
