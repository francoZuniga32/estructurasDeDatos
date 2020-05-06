/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntitas.estaticas;

/**
 *
 * @author franco
 */
public class ArbolHeapMaximo {
    private Comparable[] heap;
    private int ultimo = 0;

    public ArbolHeapMaximo(){
        this.heap = new Comparable[11];
    }

    public boolean insertar(Object elemento){
         boolean retorno = false;
         //insertamos en el lugar mas a la izquierda libre
         if(this.heap.length > this.ultimo + 1){
             this.heap[this.ultimo + 1] = (Comparable) elemento;
             this.ultimo++;
             ordenarHaciaArriva();
             retorno = true;
         }
         return retorno;
    }
    
    public boolean eliminar(){
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
                    if(this.heap[posicionHI + 1].compareTo(this.heap[posicionHI]) > 0){
                        //el HD es menor al HI y nos movemos al menor
                        posicionHI++;
                    }
                }
                
                //vamos a compara el Hijo mas pequeño con el padre
                if(this.heap[posicionHI].compareTo(compara) > 0){
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
            if(this.heap[i].compareTo(this.heap[padre]) > 0){
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
   
    public Object obtenerCima(){
        Object cima = null;
        
        if(this.ultimo > 0){
            cima = (Object) this.heap[1];
        }
        
        return cima;
    }

    public String toString(){
        String retorno = "[";
        
        if(this.heap.length > this.ultimo){
            int i = 1;
            while(i <= this.ultimo){
                retorno += this.heap[i];
                if(i != this.ultimo){
                    retorno += ",";
                }
                i++;
            }
        }
        
        retorno += "]";
        return retorno;
    }
}
