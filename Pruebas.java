public class Pruebas {
    public static void main(String[] args){
        System.out.println("########### PRUEBAS ENLACE ###########\n");
        pruebasEnlace();
        System.out.println("\n########### PRUEBAS USUARIO ###########\n");
        pruebasUsuario();
        System.out.println("\n########### PRUEBAS MENSAJE ###########\n");
        pruebasMensaje();
    }

    static void pruebasEnlace(){
        Usuario a = new Usuario("a", 1);
        Usuario b = new Usuario("b", 2);

        Enlace e1 = new Enlace(a, b, 10);
        System.out.println("Enlace: " + e1);
        System.out.println("Origen: " + e1.getUsuarioOrigen().getNombre());
        System.out.println("Destino: " + e1.getUsuarioDestino().getNombre());
        System.out.println("Coste: " + e1.getCoste());
        System.out.println("Coste real: " + e1.costeReal());
        System.out.println("Coste especial: " + e1.costeEspecial());

        Enlace e2 = new Enlace(a, b);
        System.out.println("Enlace sin coste: " + e2 + " coste=" + e2.getCoste());

        Enlace e3 = new Enlace(b, a, 0);
        System.out.println("Enlace coste 0: " + e3 + " coste=" + e3.getCoste());

        e1.cambiarDestino(a, 5);
        System.out.println("Tras cambiarDestino: " + e1 + " coste=" + e1.getCoste());

        System.out.println("Total costes acumulados: " + Enlace.getCosteTotalEnlaces());
    }

    static void pruebasUsuario(){
        Usuario ana = new Usuario("ana", 3);
        Usuario pepe = new Usuario("pepe");
        Usuario luis = new Usuario("luis", 5);

        System.out.println("Usuario solo nombre: " + pepe + " capacidad=" + pepe.getCapacidadAmplificacion());

        Enlace e1 = new Enlace(ana, pepe, 10);
        boolean ok1 = ana.addEnlace(e1);
        System.out.println("addEnlace(Enlace) origen correcto: " + ok1 + " " + ana);

        boolean ok2 = ana.addEnlace(luis, 7);
        System.out.println("addEnlace(destino, coste): " + ok2 + " " + ana);

        boolean ok3 = ana.addEnlace(pepe, 1);
        System.out.println("addEnlace mismo destino (duplicado): " + ok3);

        boolean ok4 = pepe.addEnlace(e1);
        System.out.println("addEnlace origen distinto: " + ok4);

        boolean ok5 = ana.addEnlace(ana, 1);
        System.out.println("addEnlace destino=origen (autorref): " + ok5);

        System.out.println("getEnlace(0): " + ana.getEnlace(0));
        System.out.println("getEnlace(pepe): " + ana.getEnlace(pepe));
        System.out.println("getEnlace(luis): " + ana.getEnlace(luis));
        System.out.println("getEnlace(null): " + ana.getEnlace(null));
        System.out.println("getNumEnlaces: " + ana.getNumEnlaces());
    }

    static void pruebasMensaje(){
        Usuario a = new Usuario("a", 2);
        Usuario b = new Usuario("b", 5);
        Usuario c = new Usuario("c", 1);

        a.addEnlace(b, 3);
        a.addEnlace(c, 10);
        b.addEnlace(c, 4);

        Mensaje m1 = new Mensaje("m", 20, a);
        System.out.println("Mensaje: " + m1);

        Mensaje m2 = new Mensaje("Test", 15, a);
        System.out.println("Mensaje con texto: " + m2);

        System.out.println("puedeDifundirPor enlace a b (coste 3): " + m2.puedeDifundirPor(a.getEnlace(b)));
        System.out.println("puedeDifundirPor enlace a c (coste 10): " + m2.puedeDifundirPor(a.getEnlace(c)));

        boolean d1 = m2.difunde(a.getEnlace(b));
        System.out.println("difunde(Enlace a b): " + d1 + " -> " + m2);

        boolean d2 = m2.difunde(b.getEnlace(c));
        System.out.println("difunde(Enlace b a c): " + d2 + " -> " + m2);

        Mensaje m3 = new Mensaje("Multi", 100, a);
        boolean d3 = m3.difunde(b, c);
        System.out.println("difunde(b, c) multi: " + d3 + " -> " + m3);

        Usuario d = new Usuario("d", 1);
        Mensaje m4 = new Mensaje("Salto", 50, a);
        boolean d4 = m4.difunde(b, d, c);
        System.out.println("difunde(b, d, c) con d sin enlace: " + d4 + " -> " + m4);
    }
}
