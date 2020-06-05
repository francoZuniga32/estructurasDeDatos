package conjuntitas.estaticas;
/**
 * @author franco
 */
public class Heap {
    private Comparable[] heap;
    private int ultimo = 0;

    public Heap(){
        this.heap = new Comparable[11];
    }

    public boolean insertar(Object elemento){
         boolean retorno = false;
         //insertamos en el lugar mas a la izquierda libre
         if(this.ultimo + 1 < this.heap.length){
             this.heap[this.ultimo + 1] = (Comparable) elemento;
             this.ultimo++;
             ordenarHaciaArriva();
             retorno = true;
         }
         return retorno;
    }
    
    public boolean eliminarCima(){
        boolean retorno = false;
        
        if(this.ultimo > 0){
            //intermabiamos la cima por la ultima hoja
            //eliminamos la cima y 
            Comparable tmp = this.heap[this.ultimo];
            this.heap[1] = tmp;
            this.heap[this.ultimo] = null;
            this.ultimo --;
            //ordenamos el arbol
            ordenarHaciaAbajo(1);
            retorno = true;
        }
        return retorno;
    }
    
    private void ordenarHaciaAbajo(int posicionPadre){
        //vamos a evaluar que tengamos hijos
        Comparable compara = this.heap[posicionPadre];
        boolean salir = false;
        int posicionHI;
        while(!salir){
            posicionHI = posicionPadre * 2;
            //evaluamos que la pocicion del HI este dentro del arreglo
            if(posicionHI <= this.ultimo){
                //evaluamos si tenemos HD
                if(posicionHI < this.ultimo){
                    //elegimos el menor de los dos hermanos
                    if(this.heap[posicionHI + 1].compareTo(this.heap[posicionHI]) < 0){
                        //el HD es menor al HI y nos movemos al menor
                        posicionHI++;
                    }
                }
                
                //vamos a compara el Hijo mas pequeño con el padre
                if(this.heap[posicionHI].compareTo(compara) < 0){
                    //en caso de que el padre sea mayor que el menor de los hijos lo intercambiamos
                    this.heap[posicionPadre] = this.heap[posicionHI];
                    this.heap[posicionHI] = compara;
                    posicionPadre = posicionHI;
                }else{
                    //en caso de que el padre sea menor que los hijos esta bien posicionado
                    //cortamos la iteracion
                    salir = true;
                }
            }else{
                salir = true;
            }
        }
        
    }
    
    private void ordenarHaciaArriva(){
        //tomamos el ultimo nodo insetado y lo comparamos con su padre
        
        int i = this.ultimo;
        int padre = this.ultimo/2;
        boolean control = true;
        while(padre >= 1 && control){
            //compramos el nodo final con su padre u guradamos su pocicion
            if(this.heap[i].compareTo(this.heap[padre]) < 0){
                //los intercambiamos
                int tmp1 = (int) this.heap[i];
                this.heap[i] = this.heap[padre];
                this.heap[padre] = tmp1;
                //obtenemos los nuevos padre del elemento
                i = padre;
                padre = i / 2;
            }else{
                control = false;
            }
        }
    }
   
    public boolean esVacio(){
        return this.ultimo == 0;
    }
    
    public Object recuperarCima(){
        Object cima = null;
        
        if(this.ultimo > 0){
            cima = (Object) this.heap[1];
        }
        
        return cima;
    }
    
    public Heap clone(){
        Heap clon = new Heap();
        //clonamos toda la estrcutura del arreglo
        for (int i = 1; i <= this.ultimo; i++) {
            clon.heap[i] = this.heap[i]; 
        }
        //clonamos la referencia a la ultima pocision insertada
        clon.ultimo = this.ultimo;
        //retornamos el arbol clonado
        return clon;
    }

    public String toString1(){
        String retorno = "";
        if(this.ultimo > 0){
            int i = 1;
            retorno = "[";
            while(i <= this.ultimo){
                retorno += this.heap[i];
                if(i != this.ultimo){
                    retorno += ",";
                }
                i++;
            }
            retorno += ']';
        }
        return retorno;
    }
    
    public String toString(){
        String retorno = "Arbol vacio";
        int i = 1;
        //en caso de que el arbol no este vacio
        if(this.ultimo > 0){
            retorno = "";
            while(i <= this.ultimo){
                retorno += this.heap[i]+"-> HI: ";
                if(i * 2  <= this.ultimo){
                    retorno += this.heap[i*2];
                }else{
                    retorno+= "-";
                }
                retorno += " HD: ";
                if(i*2 + 1 <= this.ultimo){
                    retorno += this.heap[i*2 +1];
                }else{
                    retorno += "-";
                }
                retorno += "\n";
                i++;
            }
        }
        return retorno;
    }
}
