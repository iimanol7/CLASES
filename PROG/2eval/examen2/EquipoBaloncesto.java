package examen2;

public class EquipoBaloncesto extends Equipo {

	private static final long serialVersionUID = 202403052L;
	/////////////////////////////////////////
	//////PROGRAMADO POR IMANOL (o no)///////
	/////////////////////////////////////////

	// defino la clase EquipoBaloncesto
	// propiedades
	private int ganados;
	private int perdidos;

	public EquipoBaloncesto() {
		super();
		this.ganados = 0;
		this.perdidos = 0;
	}

	public EquipoBaloncesto(Equipo e, int g, int p) {
		super(e);
		this.ganados = g;
		this.perdidos = p;
	}

	public EquipoBaloncesto(EquipoBaloncesto eq) {
		super(eq);
		this.ganados = eq.ganados;
		this.perdidos = eq.perdidos;
	}

	// GETTERS Y SETTERS
	public int getGanados() {
		return ganados;
	}

	public void setGanados(int ganados) {
		this.ganados = ganados;
	}

	public int getPerdidos() {
		return perdidos;
	}

	public void setPerdidos(int perdidos) {
		this.perdidos = perdidos;
	}

	public double porcentajeVictorias() {
		double partidos = this.ganados + this.perdidos;
		return this.ganados / partidos;
	}

	@Override
	public String toString() {
		return super.toString() + " " + ganados + " " + perdidos + " " + porcentajeVictorias();
	}

	public int compareTo(EquipoBaloncesto other) {

		if (this.ganados > other.ganados) {
			return 1;
		} else if (this.ganados < other.ganados) {
			return -1;
		} else {// si el resultado es 0
			if (this.perdidos > other.perdidos) {
				return -1;
			} else if (this.perdidos < other.perdidos) {
				return 1;
			}
		}
		return 0;

	}

}
