
public class Tester {
    public static void main(String[] args) {
        // Creamos tres usuarios 
        Usuario ana = new Usuario("ana", 5);
        Usuario pepe = new Usuario("pepe", 2);
        Usuario luis = new Usuario("luis", 10);
        
        System.out.println("--- Usuarios creados ---");
        System.out.println(ana);
        System.out.println(pepe);
        System.out.println(luis);
    }
}
//ana sigue a pepe con un coste de 10
		ana.addEnlace(pepe, 10);
// pepe sigue a luis con un coste de 5
		pepe.addEnlace(luis, 5);

		System.out.println("\n--- Red Social configurada ---");
		System.out.println(ana); 
		Mensaje m = new Mensaje(ana, 20, ana);
        System.out.println("\nEstado inicial: " + m);
        
        Mensaje m = new Mensaje(ana, 20, ana);
        System.out.println("\nEstado inicial: " + m);
        
        System.out.println("\nIntentando difundir de ana a pepe...");
        Enlace e1 = ana.getEnlace(pepe);
        if (m.difunde(e1)) {
            System.out.println("¡Éxito! " + m); 
        }
        
        System.out.println("\nIntentando difusión múltiple a través de luis...");
        
        boolean exito = m.difunde(luis); 
        
        if (exito) {
            System.out.println("Llegó a su destino final: " + m);
        } else {
            System.out.println("Falló algún salto.");
        }
