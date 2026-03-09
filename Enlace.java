
public class Enlace {
    private Usuario usuarioOrigen;
    private Usuario usuarioDestino;
    private int coste;

    private static int sumaCostesEnlace = 0;

    public Enlace(Usuario usuarioOrigen, Usuario usuarioDestino, int coste) {
        this.usuarioOrigen = usuarioOrigen;
        this.usuarioDestino = usuarioDestino;

        if(coste <= 0){
            this.coste = 1;
        }else{
            this.coste = coste;
        }
        
    }

    public Enlace(Usuario usuarioOrigen, Usuario usuarioDestino) {
        this(usuarioOrigen, usuarioDestino, 1);
    }

    public Usuario getUsuarioOrigen(){
        return usuarioOrigen;
    }

    public Usuario getUsuarioDestino(){
        return usuarioDestino;
    } 

    public int getCoste(){
        return coste;
    }
    /* Hacemos que el metodo devuelva un booleano si los datos no valen, nuevoUsuario = NULL, nuevoCoste <= 0 */

    public void cambiarDestino(Usuario nuevoUsuario, int nuevoCoste){
        if(coste <= 0 ){
            this.coste = 1;
            this.usuarioDestino = nuevoUsuario;
        }
        this.usuarioDestino = nuevoUsuario;
        this.coste = nuevoCoste;   
    }

    @Override
    public String toString(){
        return "@" + this.usuarioOrigen + "--" + this.coste + "-->" + "@" + this.usuarioDestino;
    }

    public int getCosteTotalEnlaces(){
        return sumaCostesEnlace;
    }

    /* a prevision de apartado 6  */
    public int costeEspecial(){
        return 0;
    }
    
    public int costeReal(){
        return this.coste + costeEspecial();
    }

    
}