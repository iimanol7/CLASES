package examen2;

import java.io.Serializable;
import java.util.Objects;

public class Equipo implements Comparable<Equipo>, Serializable{

	private static final long serialVersionUID = 202403051L;
	///////////////////////////////////
	//////PROGRAMADO POR IMANOL ///////
	///////////////////////////////////
	//defino la clase Equipo
	// propiedades
	private String codigo;
	private String nombre;
	private int creacion;
	private int plantilla;
	private double presupuesto;
	
	//default
	public Equipo() {
		this.codigo = "E00";
		this.nombre="Equipo 00";
		this.creacion=2024;
		this.plantilla=10;
		this.presupuesto=1000.0;
	}
	//personalizado
	public Equipo(String cod, String n, int c, int p, double pre) {
		this.codigo = cod;
		this.nombre=n;
		this.creacion=c;
		this.plantilla=p;
		this.presupuesto=pre;
	}
	//copia
	public Equipo(Equipo e) {
		this.codigo = e.codigo;
		this.nombre=e.nombre;
		this.creacion=e.creacion;
		this.plantilla=e.plantilla;
		this.presupuesto=e.presupuesto;
	}
	
	//Getters y setters
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCreacion() {
		return creacion;
	}
	public void setCreacion(int creacion) {
		this.creacion = creacion;
	}
	public int getPlantilla() {
		return plantilla;
	}
	public void setPlantilla(int plantilla) {
		this.plantilla = plantilla;
	}
	public double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	//TO STRING
	@Override
	public String toString() {
		return codigo+" "+nombre+" "+creacion+" "+plantilla+" "+presupuesto;
	}
	
	//equals y hascode
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
	@Override
	public int compareTo(Equipo other) {
		 
        if(this.creacion>other.creacion) {
        	return 1;
        }else if(this.creacion<other.creacion) {
        	return -1;
        }else {//si el resultado es 0
        	return (this.nombre.compareTo(other.nombre));
        }
		
	}
	
	
	
	
	
	
	
}
