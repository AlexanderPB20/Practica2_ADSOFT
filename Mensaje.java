public class Mensaje {
    
    private Usuario autor;
    private int alcance;
    private Usuario usuarioActual;
    
    public Mensaje(Usuario autor, int alcanceInicial, Usuario usuarioInicial) {
        this.autor = autor;
        this.alcance = alcanceInicial;
        this.usuarioActual = usuarioInicial; // Antes tenías usuario_actual (con guion)
    }

    public Usuario getAutor() { return autor; }
    public int getAlcance() { return alcance; }
    public Usuario getUsuarioActual() { return usuarioActual; }

    @Override
    public String toString() {
        return "Mensaje (m:" + this.alcance + ") en @" + this.usuarioActual.getNombre();
    }

    public boolean aceptadoPor(Usuario u) {
        return true; 
    }

    public boolean puedeDifundirPor(Enlace e) {
        // OJO: En tu Enlace.java el método se llama getCoste()
        // Lo cambiamos a getCoste() para que no te dé error ahora
        return this.alcance >= e.getCoste(); 
    }

    public boolean difunde(Enlace e) {
        // Ajustado a los nombres de métodos de tus archivos subidos:
        // getUsuarioOrigen() y getUsuarioDestino()
        if (e.getUsuarioOrigen().equals(this.usuarioActual) && 
            puedeDifundirPor(e) && 
            aceptadoPor(e.getUsuarioDestino())) {
            
            this.usuarioActual = e.getUsuarioDestino();
            this.alcance -= e.getCoste();
            this.alcance += this.usuarioActual.getCapacidadAmplificacion();
            
            return true;
        }
        return false;
    }

    public boolean difunde(Usuario... usuarios) {
        boolean exitoTotal = true;

        for (Usuario siguiente : usuarios) {
            // Usamos el método getEnlace que ya creaste en Usuario.java
            Enlace e = this.usuarioActual.getEnlace(siguiente); 

            if (e != null && this.difunde(e)) {
                // Éxito en este salto
            } else {
                exitoTotal = false;
            }
        }
        return exitoTotal;
    }
}
