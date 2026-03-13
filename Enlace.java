public class Enlace {
    private Usuario usuarioOrigen;
    private Usuario usuarioDestino;
    private int coste;

    private static int sumaCostesEnlace = 0;

    public Enlace(Usuario usuarioOrigen, Usuario usuarioDestino, int coste){
        this.usuarioOrigen = usuarioOrigen;
        this.usuarioDestino = usuarioDestino;
        if(coste <= 0){
            this.coste = 1;
        }else{
            this.coste = coste;
        }
        sumaCostesEnlace += this.coste;
    }

    public Enlace(Usuario usuarioOrigen, Usuario usuarioDestino){
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

    public void cambiarDestino(Usuario nuevoUsuario, int nuevoCoste){
        this.usuarioDestino = nuevoUsuario;
        if(nuevoCoste <= 0){
            this.coste = 1;
        }else{
            this.coste = nuevoCoste;
        }
    }

    public int costeEspecial(){
        return 0;
    }

    public int costeReal(){
        return coste + costeEspecial();
    }

    public static int getCosteTotalEnlaces(){
        return sumaCostesEnlace;
    }

    @Override
    public String toString(){
        return "(@" + usuarioOrigen.getNombre() + "--" + coste + "-->" + "@" + usuarioDestino.getNombre() + ")";
    }
}
