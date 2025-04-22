package Banco_Mucha_Plata;

public class Titular {
    private String nombre, correo; 
    private int id; 
    public Titular(String nombre, String correo,int id) {
        super();
        this.correo = correo; 
        this.nombre = nombre; 
        this.id = id; 
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
