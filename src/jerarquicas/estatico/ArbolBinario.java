/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas.estatico;
import jerarquicas.CeldaBinaria;
/**
 *
 * @author franco
 */
public class ArbolBinario {
    public static final int TAMANIO = 20;
    private CeldaBinaria[] arbol;
    private int raiz;
    
    public ArbolBinario(){
        this.arbol = new CeldaBinaria[TAMANIO];
        for(int i = 0; i < TAMANIO; i++){
            this.arbol[i] = new CeldaBinaria();
        }
        this.raiz = -1;
    }
    
    
}
