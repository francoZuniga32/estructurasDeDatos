# Estructura de Datos

## indice:

[TOC]



## Pila

Una pila es una estructura de estilo LIFO(Last in, Fist out),  lo que quiere decir que el primero en entrar es el  primero en salir. La comparacion mas mundana es como una pila de platos, donde los apilamos uno encima de otro, y el ultimo apilado es el primero en salir. 

Podemos identificar que el dato que vamos a operar (apilar, desapilar) es el *tope* de la pila. Es el unico elemento visible en la estructura, ya que es el unico que se apilo, y desapilo.

![](/home/franco/NetBeansProjects/estructurasDeDatos/img/tope.png)



Podemos identifica dos operaciones primordiales en la estructura, apilar: donde metemos un cosa en el tope de la pila, y desapilar: donde sacamos el tope de la pila.

¿que pasa si saco el ultimo plato de una pila de platos?¿cual es el tope ahora?

![](/home/franco/NetBeansProjects/estructurasDeDatos/img/pila-1.png)las pilas funcionan para una variedad de problemas donde tenemos que "volver a una operacion anterior" (volver atras en una pagina web, el amado Ctrl-z en cual no desace cambios efectudos en cualquier editor de texto). utilizaremos la pila cuando necesitamos obtener el orden inverso al que fueron agregados por ejemplo invertir un numero, o una cadena de texto.

## Interfaz de una pila

operaciones:

- constructor vacío
  // Crea y devuelve la pila vacía.
- apilar (nuevoElem):boolean
  // Pone el elemento nuevoElem en el tope de la pila. Devuelve verdadero
  si el elemento se pudo apilar y falso en caso contrario.
- desapilar():boolean
  // Saca el elemento del tope de la pila. Devuelve
- desapilar (es decir que se pudo desapilar) y
  falso
- obtenerTope() : elem
  // Devuelve el elemento en el tope de la pila.
- esVacia() : boolean
  // Devuelve verdadero verdadero
  verdadero
  si el elemento se pudo apilar y
  si la pila no estaba vacía al momento de
  en caso contrario.
  Precondición : la pila no está vacía.
  si la pila no tiene elementos y
  falso
  en caso contrario.
  vaciar() : void
  // Saca todos los elementos de la pila.
  clone() : Pila
  // Devuelve una copia exacta de los datos en la estructura original, y respetando el orden de los mismos,
  en otra estructura del mismo tipo
  toString() : String
  // Devuelve una cadena de caracteres formada por todos los elementos de la pila para poder mostrarla
  por pantalla.
  código.