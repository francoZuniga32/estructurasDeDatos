package conjuntitas.dinamicas;
/**
 * @author franco
 */
public class ArbolHeapMaximo {
    private int[] raiz;
    private int TAMANIO = 0;

    public ArbolHeapMaximo(){
        this.raiz = new int[11];
    }

    public boolean insertar(int elemento){
         boolean retorno = false;
         //insertamos en el lugar mas a la izquierda libre
         if(this.raiz.length > this.TAMANIO + 1){
             this.raiz[this.TAMANIO + 1] = elemento;
             this.TAMANIO++;
             retorno = true;
         }
         return retorno;
    }
    
    private void ordenarHaciaAbajo(){
        
    }
    
    private void ordenarHaciaArriva(){
        //comparamos el padre i con sus hijos
        //hijo izquierdo 2*i
        //hijo derecho 2*i+1
        
        int i = 1;
        boolean control = true;
        while(i < this.raiz.length){
            //comparamos con los hijo derecho
            if(i*2 < this.TAMANIO && this.raiz[i] < this.raiz[i*2]){
                int tmp1 = this.raiz[i];
                this.raiz[i*2] = this.
            }
        }
    }
   
    public String toString(){
        String retorno = "[";
        
        if(this.raiz.length > this.TAMANIO + 1){
            int i = 1;
            while(i <= this.TAMANIO + 1){
                retorno += this.raiz[i];
                if(i != this.TAMANIO){
                    retorno += ",";
                }
                i++;
            }
        }
        
        retorno += "]";
        return retorno;
    }
}
