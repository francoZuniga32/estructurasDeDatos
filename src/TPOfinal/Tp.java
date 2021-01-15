package TPOfinal;
import lineales.dinamicas.*;

import java.io.*;
import java.util.HashMap;

import conjuntitas.dinamico.*;
import grafos.GrafoEtiquetado;

public class Tp {
	static TecladoIn teclado = new TecladoIn();
	public static int menu() {
		int opcion = 0;
		System.out.println("-- Seleccione una de las opciones : --\n"
				+ "1. ABM (Altas-Bajas-Modificaciones) de aeropuertos\n"
				+ "2. ABM (Altas-Bajas-Modificaciones) de clientes\n"
				+ "3. ABM (Altas-Bajas-Modificaciones) de vuelos\n"
				+ "4. ABM (Altas-Bajas-Modificaciones) de pasajes\n"
				+ "9. salir");
		opcion = teclado.readLineInt();
		return opcion;
	}
	
	public static int ABMclienteMenu() {
		int opcion = 0;
		System.out.println("-- Seleccione una de las opciones : --\n"
				+ "1. Alta aeropuerto\n"
				+ "2. Banja aeropuerto\n"
				+ "3. Modificacion aeropuerto\n"
				+ "4. salir");
		opcion = teclado.readLineInt();
		return opcion;
	}
	
	public static boolean ABMCliente(int opcion, AVL clientes) {
		boolean retorno = false;
		switch (opcion) {
			case 1:
				retorno = altaCliente(clientes);
			break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
		}
		return retorno;
	}
	
	public static boolean altaCliente(AVL clientes) {
		boolean retorno = false;
		
		System.out.println("-- Ingresar datos del Usuarios --");
		System.out.println("Ingresar tipo dni:");
		String tipoDni = teclado.readLine();
		System.out.println("Ingresar numero de dni:");
		int dni = teclado.readInt();
		Cliente nuevoCliente = new Cliente(new Dni(tipoDni, dni));
		retorno = clientes.insertar(nuevoCliente);
		if(retorno) {
			System.out.println("Ingresar nombre: ");
			String nombreParam = TecladoIn.readLine();
			nuevoCliente.setNombre(nombreParam);
			System.out.println("Ingresar apellido: ");
			nuevoCliente.setApellido(teclado.readLine());
			System.out.println("Ingrese direccion: ");
			nuevoCliente.serDomicilio(TecladoIn.readLine());
			System.out.println("Ingrese fecha de nacimiento: ");
			nuevoCliente.setFechaNacimiento(TecladoIn.readLine());
			System.out.println("Ingrese telefono: ");
			nuevoCliente.setNombre(TecladoIn.readLine());
			System.out.println("El usuario fue creado con exito");
		}else {
			System.out.println("El usuario ya existe");
		}
		return retorno;
	}
	
	public static boolean bajaCliente(AVL clientes) {
		boolean retorno = false;
		
		System.out.println("Ingrese el tipo de dni:");
		String tipoDni = teclado.readLine();
		System.out.println("Ingrese el dni: ");
		int dni = teclado.readInt();
		retorno = clientes.eliminar((new Cliente(new Dni(tipoDni, dni)));
		if(!retorno) {
			System.out.println("El usuario no Existe!!");
		}else {
			System.out.println("El usuario fue eliminado con exito");
		}
		return retorno;
	}
	
	public static boolean modificarCliente(AVL clientes) {
		boolean retorno = false;
		
		System.out.println("Ingrese el tipo de dni:");
		String tipoDni = teclado.readLine();
		System.out.println("Ingrese el dni: ");
		int dni = teclado.readInt();
		Object usuario = clientes.recuperar(new Cliente(new Dni(tipoDni, dni)));
		if(usuario != null) {
			
		}else {
			System.out.println("El usuario no existe!!");
		}
		return retorno;
	}
	
	public static void main(String[] args) throws Exception {
		AVL tablaAeropuertos = new AVL();
		AVL tablaClientes = new AVL();
		GrafoEtiquetado aeropuertos = new GrafoEtiquetado();
		HashMap<Cliente, Lista> pasajesComprados = new HashMap<Cliente, Lista>();
	}
}
