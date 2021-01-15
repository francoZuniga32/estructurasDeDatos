package TPOfinal;
import lineales.dinamicas.*;

public class Vuelos {
	private String identificacion;
	private int codigo;
	private Aeropuerto aeropuertoOrigen;
	private Aeropuerto aeropuertoDestino;
	private String horaDeSalida;
	private String horaDeLlegada;
	private Lista programados;
	
	public Vuelos(String identificacionParam, int codigoParam) {
		this.identificacion = identificacionParam;
		this.codigo = codigoParam;
		this.programados = new Lista();
	}
	
	public Vuelos(String identificacionParam, int codigoParam, Aeropuerto origenParam, Aeropuerto destinoParam, String horaSalidaParam, String horaLlegadaParam) {
		this.identificacion = identificacionParam;
		this.codigo = codigoParam;
		this.aeropuertoOrigen = aeropuertoOrigen;
		this.aeropuertoDestino = aeropuertoDestino;
		this.horaDeLlegada = horaLlegadaParam;
		this.horaDeSalida = horaSalidaParam;
		this.programados = new Lista();
	}
	
	public String getIdentificacionCodigo() {
		return this.identificacion+this.codigo;
	}
	
	public Aeropuerto getAeropuertoOrigen() {
		return this.aeropuertoOrigen;
	}
	
	public Aeropuerto getAeropuertoDestino() {
		return this.aeropuertoDestino;
	}
	
	public String getHoraDeSalida() {
		return this.horaDeSalida;
	}
	
	public String getHoraDeLlegada() {
		return this.horaDeLlegada;
	}
	
	public Lista getProgramados() {
		return this.programados;
	}
	
	public void setAeropuertoOrigen(Aeropuerto aeropuerto) {
		this.aeropuertoOrigen = aeropuerto;
	}
	
	public void setAeropuertoDestino(Aeropuerto aeropuerto) {
		this.aeropuertoDestino = aeropuerto;
	}
	
	public void setHoraDeSalida(String horaDeSalida) {
		this.horaDeSalida = horaDeSalida;
	}
	
	public void setHoraDeLlegada(String horaDeLlegada) {
		this.horaDeLlegada = horaDeLlegada;
	}
	
	public void setProgramado(Programados programado) {
		this.programados.insertar(programado, this.programados.longitud() +1);
	}
}