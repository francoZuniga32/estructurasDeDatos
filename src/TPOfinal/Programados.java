package TPOfinal;

public class Programados {
	private String fecha;
	private int asientos;
	private int reservados;
	
	public Programados(String fechaParam, int asientosParam) {
		this.fecha = fechaParam;
		this.asientos = asientos;
		this.reservados = 0;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public boolean setAsientos(int asientos) {
		boolean retorno = false;
		if(asientos >= this.reservados) {
			this.asientos = asientos;
			retorno = true;
		}
		return retorno;
	}
	
	public boolean setReservados(int reservas) {
		boolean retorno = false;
		if(reservas <= this.asientos) {
			this.reservados = reservas;
			retorno = true;
		}
		return retorno;
	}
	
	public boolean reserva(int reserva) {
		boolean retorno = false;
		if(reserva < (this.asientos - this.reservados )) {
			this.reservados += reserva;
			retorno = true;
		}
		return retorno;
	}
	
	public String getFecha() {
		return this.fecha;
	}
	
	public int getAsientos() {
		return this.asientos;
	}
	
	public int getLibres() {
		return this.reservados;
	}
}
