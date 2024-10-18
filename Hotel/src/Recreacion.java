
public class Recreacion {

	private int id;
	private int capacidad;
	private int costoXhora;
	public Recreacion(int id, int capacidad, int costoXhora) {
		super();
		this.id = id;
		this.capacidad = capacidad;
		this.costoXhora = costoXhora;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getCostoXhora() {
		return costoXhora;
	}
	public void setCostoXhora(int costoXhora) {
		this.costoXhora = costoXhora;
	}
	@Override
	public String toString() {
		return "Recreacion [id=" + id + ", capacidad=" + capacidad + ", costoXhora=" + costoXhora + "]";
	}  
	
	
	
	
	
	
	
	
	
	
	
}
