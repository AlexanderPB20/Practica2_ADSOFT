import java.util.ArrayList;
import java.util.List;


public class Usuario {
    private String nombre;
    private int capacidadAmplificacion;
    private List<Enlace> enlacesSalientes;


    public Usuario(String nombre, int capacidadAmplificacion){
        this.nombre = nombre;
        this.capacidadAmplificacion = capacidadAmplificacion;
        this.enlacesSalientes = new ArrayList<>();
    }

    public Usuario(String nombre){
        this(nombre, 2);
    }

    public boolean addEnlace(Enlace enlace){
        if(enlace.getUsuarioOrigen() != this){
            return false;
        }
        if(enlace.getUsuarioDestino() == this){
            return false;
        }
        if(getEnlace(enlace.getUsuarioDestino()) != null){
            return false;
        }
        enlacesSalientes.add(enlace);
        return true;
    }

    public boolean addEnlace(Usuario destino, int coste){
        if(destino == this){
            return false;
        }
        Enlace nuevoEnlace = new Enlace(this, destino, coste);
        return addEnlace(nuevoEnlace);
    }


    public String getNombre(){
        return nombre;
    }

    public int getCapacidadAmplificacion(){
        return capacidadAmplificacion;
    }
    
    public Enlace getEnlace(int i){
        return enlacesSalientes.get(i);
    }

    public int getNumEnlaces(){
        return enlacesSalientes.size();
    }

    public Enlace getEnlace(Usuario destino){
        if(destino == null){
            return null;
        }
        for(Enlace enlace : enlacesSalientes){
            if(enlace.getUsuarioDestino() == destino){
                return enlace;
            }
        }
        return null;
    }


    @Override
    public String toString(){
        String parteEnlaces;
        if(enlacesSalientes.isEmpty()){
            parteEnlaces = "";
        }else{
            parteEnlaces = " [ " + String.join(", ", enlacesSalientes.stream().map(e -> "(@" 
                    + e.getUsuarioOrigen().getNombre() + "--" + e.getCoste() + "-->" + "@" + e.getUsuarioDestino().getNombre() 
                    + ")").toList()) + " ]";
        }
        return "@" + nombre + "(" + capacidadAmplificacion + ")" + parteEnlaces;
    }

}
