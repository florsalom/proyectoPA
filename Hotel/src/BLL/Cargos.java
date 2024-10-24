package BLL;

public class Cargos {

	private int id;
	private String cargo;
	public Cargos(int id, String cargo) {
		super();
		this.id = id;
		this.cargo = cargo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	@Override
	public String toString() {
		return "Cargos [id=" + id + ", cargo=" + cargo + "]";
	}

	
	
	
}
