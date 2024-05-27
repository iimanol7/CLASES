package examen3;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Persona implements Serializable,Comparable<Persona>{

	private static final long serialVersionUID = 202405162L;
	
	// Defino la clase Persona
	// Propiedades o Atributos
	@Id
	protected String dni;
	protected String nombre;
	protected String apellidos;
	protected Fecha fechanacimiento;
	
	// constructor por defecto
	public Persona(){
		this.dni = "";
		this.nombre ="";
		this.apellidos = "";
		this.fechanacimiento = new Fecha(); // 1/1/2023
	}
	
	// constructor copia
	public Persona(Persona p){
		this.dni = p.dni;
		this.nombre = p.nombre;
		this.apellidos = p.apellidos;
		this.fechanacimiento = new Fecha(p.fechanacimiento);
	}
	
	// Constructores personalizados
	public Persona(String d, String n, String a){
		this.dni = d;
		this.nombre = n;
		this.apellidos = a;
		this.fechanacimiento = new Fecha(); // 1/1/2023
	}
	
	public Persona(String d, String n, String a, Fecha f){
		this.dni = d;
		this.nombre = n;
		this.apellidos = a;
		this.fechanacimiento = new Fecha(f);
	}
	
	// Getters and Setters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Fecha getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Fecha fechanacimiento) {
		this.fechanacimiento = new Fecha(fechanacimiento);
		//this.fechanacimiento = fechanacimiento;
	}

	// toString
	@Override
	public String toString() {
		return (dni + " " + nombre + " " + apellidos + " " + fechanacimiento);
	}

	// hashCode
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			// si son el mismo objeto
			return true;
		if (obj == null)
			// si obj no esta creado
			return false;
		if (getClass() != obj.getClass())
			// si son de distinta clase
			return false;
		// comparo las propiedades
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}

	// compareTo
	@Override
	public int compareTo(Persona other) {
		// comparo únicamente el campo dni
		return (this.dni.compareTo(other.dni));
	}
	
}
