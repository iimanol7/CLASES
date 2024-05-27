package examen3;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "jugadores")
public class Jugador extends Persona{
	
	private static final long serialVersionUID = 202405161L;

  private int dorsal;
  private double sueldo;
  private int idEquipo;

  // constructor por defecto
  public Jugador() {
  	// propiedades de Persona
		super();
		// propiedades de Jugador
		this.dorsal = 0;
		this.sueldo = 100;
		this.idEquipo = 0;
	}
    
  // Constructores personalizados
	public Jugador(String idJugador, String nombre, String apellidos, int dorsal, double sueldo, int idEquipo) {
		// propiedades de Persona
		super(idJugador,nombre,apellidos);
		// propiedades de Jugador
		this.dorsal = dorsal;
		this.sueldo = sueldo;
		this.idEquipo = idEquipo;
	}
	
	public Jugador(Persona p, int dorsal, double sueldo, int idEquipo) {
		// propiedades de Persona
		super(p);
		// propiedades de Jugador
		this.dorsal = dorsal;
		this.sueldo = sueldo;
		this.idEquipo = idEquipo;
	}
	
	// constructor copia
	public Jugador(Jugador j) {
		// propiedades de Persona
		super(j);
		// propiedades de Jugador
		this.dorsal = j.dorsal;
		this.sueldo = j.sueldo;
		this.idEquipo = j.idEquipo;
	}

	// Getters and Setters
	public int getdorsal() {
		return dorsal;
	}

	public void setdorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public double getsueldo() {
		return sueldo;
	}

	public void setsueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public int getidEquipo() {
		return idEquipo;
	}

	public void setidEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	// toString
	@Override
	public String toString() {
		return nombre + " " + apellidos + " ("+ dorsal + ") " + sueldo + "€";
	}
    
	
}
