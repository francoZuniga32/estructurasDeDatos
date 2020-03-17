
package lineales;

public class testPilaDinamica {
    public static void main(String[] args) {
        PilaDinamica pila1 = new PilaDinamica();
        
        for (int i = 0; i < 15; i++) {
            pila1.apilar(i);
        }
        
        System.out.println(pila1.toString());
        
        PilaDinamica pila2 = pila1.clone();
        
        System.out.println("pila1: "+pila1.toString()+" pila2: "+pila2.toString());
        pila1.desapilar();
        PilaDinamica pila3 = pila2.clone();
        pila3.vaciar();
        System.out.println("pila1 desapilada 1 vez: "+pila1.toString());
        System.out.println("pila3 vacia: "+pila3.toString());
    }
}
