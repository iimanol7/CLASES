package examen3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JugadadorMainCrear10 {

	public static void main(String[] args) {
		// Se conecta a la base de datos
		// crea una base de datos de objetos de la clase Trabajador
		// en el directorio db del proyecto
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:db/jugadores.odb");
		EntityManager em = emf.createEntityManager();
		
		// Creo 10 Objetos de tipo Jugador en la base de datos
		em.getTransaction().begin();
		String dni;
		String nombre;
		String apellidos;
		Fecha fn;
		int dorsal;
		double sueldo;
		int idEquipo;
		Jugador j1;
		Persona p1;
		for (int i = 0; i < 10; i++) {
			// creo los datos de un Jugador
			dni = ""+i;
			nombre = "N" + i;
			apellidos = "A1"+i+" A2"+i;
			fn = new Fecha(i+1,i+1,2024);
			dorsal = i+1;
			sueldo = 1000.0 * i;
			idEquipo = i % 4;
			p1 = new Persona(dni,nombre,apellidos,fn);
			j1 = new Jugador(p1, dorsal, sueldo, idEquipo);
			// inserto el Alumno en la Base de Datos
			em.persist(j1);
		}
		// Guardo los cambios en la Base de Datos
		em.getTransaction().commit();
		// Cierro la conexion con la base de datos 
		em.close();
		emf.close();
	}
}
