package entregaLista.lineales.dinamicas;

//@author franco
public class Nodo {
    private Object elemeto;
    private Nodo enlace;
    
    //constructor
    public Nodo(Object elemento, Nodo enlace){
        this.elemeto = elemento;
        this.enlace = enlace;
    }
    
    //modificadores
    public void setElemento(Object elemento){
        this.elemeto = elemento;
    }
    
    public void setEnlace(Nodo enlace){
        this.enlace = enlace;
    }
    
    //observadores
    public Object getElemento(){
        return this.elemeto;
    }
    
    public Nodo getEnlace(){
        return this.enlace;
    }
    
    public boolean equals(Nodo comparar){
        return this.toString().equals(comparar.toString());
    }
    
    public String toString(){
        return this.elemeto.toString();
    }
}
