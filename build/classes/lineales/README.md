# hola soy el MD

# Estructura de Datos

## indice:

[TOC]

## Pila

Una pila es una estructura de estilo LIFO(Last in, Fist out),  lo que quiere decir que el primero en entrar es el  primero en salir. La comparacion mas mundana es como una pila de platos, donde los apilamos uno encima de otro, y el ultimo apilado es el primero en salir. 

Podemos identificar que el dato que vamos a operar (apilar, desapilar) es el *tope* de la pila. Es el unico elemento visible en la estructura, ya que es el unico que se apilo, y desapilo.

![](../../img/tope.png)



Podemos identifica dos operaciones primordiales en la estructura, apilar: donde metemos un cosa en el tope de la pila, y desapilar: donde sacamos el tope de la pila.

¿que pasa si saco el ultimo plato de una pila de platos?¿cual es el tope ahora?

![](../..//img/pila-1.png)las pilas funcionan para una variedad de problemas donde tenemos que "volver a una operacion anterior" (volver atras en una pagina web, el amado Ctrl-z en cual no desace cambios efectudos en cualquier editor de texto). utilizaremos la pila cuando necesitamos obtener el orden inverso al que fueron agregados por ejemplo invertir un numero, o una cadena de texto.

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

### el UML de la clase pila

---

PIla

---

-TAMANIO: int

-arreglo: array[0,...,TAMANIO-1] de tipoObjeto/Elemento

-tope:int = -1

---

+Pila()

+apilar(TipoElemento):boolean

+desapila():boolean

+obtenerTope():TipoElemento

+esVacia():boolean

+vaciar()

+clone():Pila

+toString():String

---

### Implementacion contructor

En esta implementacion vamos a definir un espacio de memoria fijo con el cual vamos a trabajar. en el caso de java definimos esta longitud fija con un arreglo. por el principio de encapsulacion podemos definir que estos arreglos y variables para conocer el estado de la pila(vacia y llana) no pudan ser acceddidos.

```java
public class Pila{
	private Object[] arreglo;
	private int tope;
	private static final int TAMANIO = 10;
	
	public Pila(){
		this.arreglo = new Object[this.TAMANIO];
		this.tope = -1;
	}
}
```

de esta forma declaramos la pila y la construimos, donde le definimos el tope de la pila, esto combiene para poder probar la pila, en una implementacion de pila estatica tenemos que definirla ocultando el tamaño de la pila. en caso de que la persona sobrepase la pila devolvemos el erro *stackOverflow* o desbordamiento de pila.

### Implementacion apilar

```java
public boolean apilar(Object elemento){
   	boolean retorno = false;
        
    if(this.tope + 1 < this.TAMANIO){
        this.tope ++;
        this.array[this.tope] = elemento;
        retorno = true;
    }
    return retorno;
}
```

En esta implementacion tenemos que apilar un elemento en el tope de la pila, por lo cual tenemos que evaluar si la pila no esta llena, *tope* guarda el lugar del arreglo donde esta el tope (donde se guardara el nuevo elemento) . La condion esta llena si: 
$$
tope = array.length()-1
$$
osea *tope* esta en la ultima pocicion. por esto miramos a la siguiente pocicion *(this.tope + 1 )* sea menor a la longitud del arreglo. En caso de que no este llena imcrementa el *tope* y guarda el valor del parametro en esa pocicion. Por ultimo retorna true.

### implementacion desapilar

```java
public boolean desapilar(){
	boolean retorno = false;
    //verificamos que la pila no este vacia
    if(this.tope > -1){
        this.array[this.tope] = null;
        this.tope --;
        retorno = true;
    } 
    return retorno;
}
```

En este caso cuando desapilamos tenemos que evaluar que la pila no este vacia, esto es el tope es mayor a -1.  eliminamos lo que hay en tope *(this.array[this.tope] = null)*, y decrementamos el *tope*. finalmente retorna true.

### implementacion tope

```java
public Object obtenerTope(){
	Object retorno = null;
    //verificamos que no tengamos la pilaVacia
    if(esVacia()){
        retorno = this.arreglo[this.tope];
    }
    return retorno;
}
```

retornamos el elemento tope de la pila. en caso de que este vacia devolvemos el elemento *nulo*. el modulo esVacia es un metodo que implementaremos ahora

### implementacion esVacia

```java
public boolean esVacia(){
	boolean retorno = true;
    if(this.tope > -1){
        retorno = false;
    }
    return retorno;
}
```

en caso de que el tope sea -1 retorna verdadero en caso contrario retorna falso

### implementacion vaciar

```java
//metodo 1
public void vaciar(){
	int i = this.tope;
    while(i > -1){
        this.arreglo[i] = null;
        i++;
    }
    this.tope = -1;
}

//metodo 2
public void vaciar2(){
    //como un arreglo es una estructura la desreferenciamos
    this.arreglo = null;
    //y referenciamos a una nueva
    this.arreglo = new Object[this.TANANIO];
    this.tope = -1;
}
```

Cualquiera de estos metodos vacian el arreglo de la pila y resetean el tope a -1. 

### implementacion clon

``` java
//metodo iterativo 1
public Pila clon(){
	//creamos la nueva pila y comenzamos a operar
    Pila clon = new Pila(this.TAMANIO);
    int i = 0;
    
    while(i <= this.tope){
        clon.arreglo[i] = this.arreglo[i];
        i++;
    }
    return clon;
}
```

usaremos un metodo que no es recursivo.  copiamos los elementos del arreglo de la pila actual a el arreglo de la pila destino donde *tope* es el limite de este copiado.

### implementacion de toString

```java
public String toString(){
	String retorno = "[";
    int i = 0;
    
    if(i <= this.tope){
        retorno = retorno + this.arreglo[i].toString;
        i++;
        if(i <= this.tope){
            retorno = retorno + ",";
        }
    }
    
    retorno = retorno + "]";
}
```

comanzamos en la base de la pila, concatenando el valor de cada uno de los elementos almacenados, lo que podemos hacer son dos metodos uno usa el *toString* (sobrescribiendo el metodo de toString de la clase Object) de cada elemento.



## Implementacion Pila Dinamica

La implemenatacion de una pila dinamica es mucho mejor, ya que esta no cuanta con un maximo para el tope. estas pilas crecen sin un control o definicion. para esto usamos otra estructura denominada nodo, el cual almacena un elemento y la referencia a otro nodo, el enlace. en estas pilas apilamos nodos, donde el nuevo nodo almacena el nuevo valor y la referencia a el tope actual, luego este nodo es el nuevo nodo.

### la clase Nodo

la clase nodo puede almacenar cualquier elemento, pero trabajaremos con datos **int** y **String** pero cuando se trabaja con TDA se necesaita saber el tipo de datos empleado (persona, empleado, etc'). 

![nodo](/home/franco/NetBeansProjects/estructurasDeDatos/img/nodo.png)

en el primer nodo esta anlazado a otro , el segundo esta enlasado a un nodo *null* o al elemento null.

### UML de Nodo

---

Nodo

---

-elemento: tipoElemento

-enlace: Nodo

---

+Nodo(tipoElemento, Nodo)

+getElemento():TipoElemento

+getEnlace():Nodo

+setElemento(elemento)

+setEnlace(Nodo)

---

```java
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
}
```

Ahora podemos pasar a las implementacion de la clase pila dinamica. donde se usan los nodos.

### Implementacion pila dinamica

en esta pila siempre trabajamos con el tope de la pila (como tiene que ser), las eliminaciones e inserciones se hacen sobre el tope. 

```java
public class Pila{
    private Nodo tope;
    
    public Pila(){
        this.tope = null;
    }
}
```

El metodo constructor instancia la pila vacia, donde el nodo tope es nulo.

### implementacion de apilar y desapilar

En el caso de apilar tenemos que ingresar un elemento y crear un nodo, el cual contenga el elemento y el enlace es el nodo actual (el tope).

```java
public boolean apilar(Object elemento){
    //creamos el nuevo nodo
    Nodo nuevo = new Nodo(elemento, this.tope);
    //remplazamos el nuevo tope
    this.tope = nuevo;
    //retornamos verdadero
    return true;
}
```

El metodo de desapilar lo que tenemos que hacer es setear como tope el enlace del nodo tope actual, de esta forma pasamos a tener de tope al que esta inmediatamente debado del tope actual de la pila. El que dejamos de usar como tope se *desreferencia* por lo cual el *pacman de java* se lo come.  En este caso una de las verificaciones que se mantiene es la de la pila vacia, la cual no se puede desapilar.

```java
public boolean desapilar(){
    boolean retorno = false;
    //verficamos que la pila no este vacia
    if(this.tope !null){
        //obtenemos el enlace del tope
        Nodo enlace = this.tope.getEnlace();
        //lo usamos como nuevo tope
        this.tope = enlace;
        retorno = true;
    }
    return retorno;
}
```



### implementacion de obtener tope

en este caso lo que tenemos que hacer es obtener el elemento del tope para el cual usaremos los metodos de la clase Nodo.

```java
public Object obtenerTope(){
    Object retorno = null;
    //verficamos si la pila no esta vacia
    if(this.tope != null){
        //del nodo tope obtenemos el nodo y del nodo el elemento
        retorno = this.tope.getElemento();
    }
    //retornamos el elemento null o un Object 
    return retorno;
}
```



### implementacion de metodo esVacia

para poder verificar afuera si una pila esta vacia usaremos este metodo. El cual verfiica si la pila esta vacia osea el tope es un *Object null*. 

```java
public boolean esVacia(){
    boolean retorno = false;
    if(this.tope == null){
        retorno = true;
    }
    return true;
}
```

### implementacion metodo vaciar

este metodo sirve para poder vaciar la pila que se creo. por lo cual podemos dar uso al *garbage colecto* o como lo llamo *pacman de java* el cual se "come" los espacios de memoria no referenciados.

```java
public void vaciar(){
    //tomamos el tope y desrefenciamos la pila completa
    this.tope = null;
}
```

Tambiem podemos optar por una opcion recursiva la cual va hacia la base de la pila y la va "desapilando" asta que este vacia

```java
public void vaciar(){
	//si no esta vacia desapila y llama
    while(this.tope != null){
        //obtenemos el enlace del tope
        Nodo enlace = this.tope.getEnlace();
        //lo usamos como nuevo tope
        this.tope = null;
        this.tope = enlace;
        //llamamos a la funcion de desapilar}
        vaciar();
    }
}
```

podemos emplear muchos otros algoritmos de desapilado, pero el primero hace uso de funciones propias del compilador de java como el *garbage colector*.

### implemetacion clon

```java
public PilaDinamica clone(){
    PilaDinamica clon = new PilaDinamica();
    this.cloneRecursivoPaso(clon, this.tope);
	return clon;
}

private void cloneRecursivoPaso(PilaDinamica pilaClon, Nodo enlace){        
	if(enlace != null){
        //obtenemos el elemento del tope
        Object elementoTope = enlace.getElemento();
        //nos movemos al siguiente enlace
        Nodo enlaceTope = enlace.getEnlace();
        //llamamos a la funcion recursivamente
        cloneRecursivoPaso(pilaClon, enlaceTope);
        //cuando salimos apilamos los elementos del nodo cuando salimos
    	pilaClon.tope = new Nodo(elementoTope, pilaClon.tope);
    }
}
```

En este metodo 

### Implementacion de toString

```java
public String toString(){
        String retorno = "Pila vacia";
        //si la pila no esta vacia
        retorno = "";
        //se ubica en el tope para recorrer la pila
        if(this.tope != null){
            retorno = "[";
            retorno += pasoToString(this.tope);
            retorno = retorno + "]";   
        }
    	return retorno;
    }
    
    private String pasoToString(Nodo aux){
        String retorno = "";
        //caso base pila vacia
        if(aux != null){
            //evaluamos el llamdo del enlace
            String llamado = pasoToString(aux.getEnlace());
            //si esta no esta vacia concatenamos
            if(llamado != ""){
                retorno = llamado + "," + aux.getElemento().toString();
            }else{
                //si lo esta colo devolvemos el valor actual
                retorno = aux.getElemento().toString();   
            }
        }
        return retorno;
    }
```

Este metodo retorna la pila en forma de string usando el toString de cada elemento. para poder mostrarlo en el orden en el que fueron apilados tenemos que usar ese paso recusivo. la salida es *pila vacia* si esta se encuantra vacia y si no *[E1, E2, ... , En]* donde *Ei* es el elemento apilado.

## Cola estatica

### Definicion

una cola es una estructura de estilo LIFO(last int, last out). donde el ultimo en entrar es el ultimo en salir. una cola es una estrucrua donde los elementos salen en orden en el que dueron ingresados. esto es:

si yo ingreso 1, 2, 3, 4. cuando quiero sacar tengo que sacar en el orden en que que fueron ingresados. 1, 2, 3, 4.

para poder incorporar este tipo de dinamismo a una estructura fija (estatica) tenemos que usar una forma de arreglo circular.

[1,2,3,null, null, null] => [null, 1, 2, 3, null, null] => [null, null, 1,2,3, null]=> y asi. 

