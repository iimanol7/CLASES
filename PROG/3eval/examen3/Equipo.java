package examen3;

public class Equipo {
	
	private int idEquipo;
    private String nombre;
    private int fundacion;
    private double presupuesto;

    // Eraikitzaile lehenetsia
	public Equipo() {
		this.idEquipo = 0;
		this.nombre = "Equipo 0";
		this.fundacion = 2000;
		this.presupuesto = 100000.0;
	}
	
	 // Eraikitzaile pertsonalizatua
	public Equipo(int idEquipo, String nombre, int fundacion, double presupuesto) {
		this.idEquipo = idEquipo;
		this.nombre = nombre;
		this.fundacion = fundacion;
		this.presupuesto = presupuesto;
	}
	
	//Eraikitzaile kopia
	public Equipo(Equipo t) {
		this.idEquipo = t.idEquipo;
		this.nombre = t.nombre;
		this.fundacion = t.fundacion;
		this.presupuesto = t.presupuesto;
	}
	
	// Getters and Setters
	public int getidEquipo() {
		return idEquipo;
	}

	public void setidEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getnombre() {
		return nombre;
	}

	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	public int getFundacion() {
		return fundacion;
	}

	public void setFundacion(int fundacion) {
		this.fundacion = fundacion;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	@Override
	public String toString() {
		return nombre + " (" + fundacion + ") - "	+ presupuesto + "€";
	}
    
}
