# Estructura de Datos

## indice:

[TOC]



## Pila

Una pila es una estructura de estilo LIFO(Last in, Fist out),  lo que quiere decir que el primero en entrar es el  primero en salir. La comparacion mas mundana es como una pila de platos, donde los apilamos uno encima de otro, y el ultimo apilado es el primero en salir. 

Podemos identificar que el dato que vamos a operar (apilar, desapilar) es el *tope* de la pila. Es el unico elemento visible en la estructura, ya que es el unico que se apilo, y desapilo.

![](img/tope.png)



Podemos identifica dos operaciones primordiales en la estructura, apilar: donde metemos un cosa en el tope de la pila, y desapilar: donde sacamos el tope de la pila.

¿que pasa si saco el ultimo plato de una pila de platos?¿cual es el tope ahora?

![](img/pila-1.png)las pilas funcionan para una variedad de problemas donde tenemos que "volver a una operacion anterior" (volver atras en una pagina web, el amado Ctrl-z en cual no desace cambios efectudos en cualquier editor de texto). utilizaremos la pila cuando necesitamos obtener el orden inverso al que fueron agregados por ejemplo invertir un numero, o una cadena de texto.

## Interfaz de una pila

operaciones:

- constructor vacío
  // Crea y devuelve la pila vacía.
  
- apilar (nuevoElem):boolean
  // Pone el elemento nuevoElem en el tope de la pila. Devuelve verdadero
  si el elemento se pudo apilar y falso en caso contrario.
  
- desapilar():boolean
  // Saca el elemento del tope de la pila. Devuelve falso si la pila esta vacia
  
- obtenerTope() : elem
  // Devuelve el elemento en el tope de la pila.
  
- esVacia() : boolean
  // Devuelve verdadero en caso de que la pila este vacia
  
- vaciar():void

  //vacia la pila

- clone():Pila

  //Devuelve una copia exacta de los datos en la estructura original, y respetando el orden de los mismos, en otra estructura del mismo tipo

- toString():String

  //Devuelve una cadena de caracteres enlistando los elmenetos en el orden en el que fuerno apilados



## Implementacion Estatica de pila

En esta implementacion vamos a definir un espacio de memoria fijo con el cual vamos a trabajar. en el caso de java definimos esta longitud fija con un arreglo. por el principio de encapsulacion podemos definir que estos arreglos y variables para conocer el estado de la pila(vacia y llana) no pudan ser acceddidos.

```java
public class Pila{
	private Object[] arreglo;
	private int tope;
	private int TAMANIO;
	
	public Pila(){
		this.arreglo = new Object[this.TAMANIO];
		this.tope = -1;
	}
}
```

de esta forma declaramos el 



