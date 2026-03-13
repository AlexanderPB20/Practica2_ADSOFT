public class Mensaje {

    private final String texto;
    private int alcance;
    private Usuario usuarioActual;

    public Mensaje(String texto, int alcanceInicial, Usuario usuarioInicial){
        this.texto = texto;
        this.alcance = alcanceInicial;
        this.usuarioActual = usuarioInicial;
    }

    public int getAlcance(){
        return alcance;
    }

    public Usuario getUsuarioActual(){ 
        return usuarioActual; 
    }

    @Override
    public String toString(){
        return "Mensaje(" + texto + ":" + alcance + ") en @" + usuarioActual.getNombre();
    }

    public boolean aceptadoPor(Usuario u){
        return true; 
    }

    public boolean puedeDifundirPor(Enlace e){
        return alcance >= e.costeReal();
    }

    public boolean difunde(Enlace e){
        if(e.getUsuarioOrigen() == usuarioActual && puedeDifundirPor(e) && aceptadoPor(e.getUsuarioDestino())){
            usuarioActual = e.getUsuarioDestino();
            alcance -= e.costeReal();
            alcance += usuarioActual.getCapacidadAmplificacion();
            return true;
        }
        return false;
    }

    public boolean difunde(Usuario... usuarios){
        boolean exitoTotal = true;

        for(Usuario siguiente : usuarios){
            Enlace e = this.usuarioActual.getEnlace(siguiente);

            if(e != null && this.difunde(e)){
            }else{
                exitoTotal = false;
            }
        }
        return exitoTotal;
    }
}
