package examen3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.util.List;
import java.util.Vector;

public class Examen3GestionJugadores extends JFrame implements ActionListener {

	private static final long serialVersionUID = 202405164L;

	private JPanel contenedor;
	private JButton btnSalir;
	private JButton btnBorrar;
	private JLabel lblInfo;

	private DefaultTableModel dtmTabla;
	private JTable tabla;

	private JScrollPane scrollPane;
	private JComboBox<Equipo> cmbEquipo;

	private Vector<String> columnas;
	private Vector<Vector<String>> datosTabla;

	private JLabel lblSumaSueldos;
	private JLabel lblMediaSueldosValor;

	private JLabel lblMediaSueldos;
	private JLabel lblNumeroJugadores;
	private JLabel lblNumeroJugadoresValor;
	private JLabel lblSumaSueldosValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Examen3GestionJugadores frame = new Examen3GestionJugadores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Examen3GestionJugadores() {
		// setType(Type.UTILITY);
		setForeground(new Color(0, 0, 128));
		setFont(new Font("Arial", Font.BOLD, 20));
		setResizable(false);
		setTitle("Examen3GestionJugadores - Imanol Gullon");

		setBounds(100, 100, 797, 513);
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedor);
		contenedor.setLayout(null);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(new Color(0, 0, 128));
		btnBorrar.setFont(new Font("Arial", Font.BOLD, 24));
		btnBorrar.setLocation(43, 11);
		btnBorrar.setSize(128, 40);
		contenedor.add(btnBorrar);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});
		btnSalir.setForeground(new Color(0, 0, 128));
		btnSalir.setFont(new Font("Arial", Font.BOLD, 24));
		btnSalir.setLocation(589, 11);
		btnSalir.setSize(128, 40);
		contenedor.add(btnSalir);

		lblInfo = new JLabel("No hay Jugadores");
		lblInfo.setForeground(new Color(255, 128, 0));
		lblInfo.setFont(new Font("Arial", Font.BOLD, 24));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setLocation(180, 11);
		lblInfo.setSize(399, 40);
		contenedor.add(lblInfo);

		lblMediaSueldosValor = new JLabel("0.0");
		lblMediaSueldosValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMediaSueldosValor.setForeground(new Color(255, 128, 0));
		lblMediaSueldosValor.setFont(new Font("Arial", Font.BOLD, 24));
		lblMediaSueldosValor.setBounds(675, 429, 96, 40);
		contenedor.add(lblMediaSueldosValor);

		lblMediaSueldos = new JLabel("Media Sueldos:");
		lblMediaSueldos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMediaSueldos.setForeground(new Color(0, 0, 128));
		lblMediaSueldos.setFont(new Font("Arial", Font.BOLD, 24));
		lblMediaSueldos.setBounds(496, 429, 179, 40);
		contenedor.add(lblMediaSueldos);

		lblNumeroJugadores = new JLabel("Jugadores:");
		lblNumeroJugadores.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroJugadores.setForeground(new Color(0, 0, 128));
		lblNumeroJugadores.setFont(new Font("Arial", Font.BOLD, 24));
		lblNumeroJugadores.setBounds(10, 429, 134, 40);
		contenedor.add(lblNumeroJugadores);

		lblNumeroJugadoresValor = new JLabel("0");
		lblNumeroJugadoresValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroJugadoresValor.setForeground(new Color(255, 128, 0));
		lblNumeroJugadoresValor.setFont(new Font("Arial", Font.BOLD, 24));
		lblNumeroJugadoresValor.setBounds(140, 429, 47, 40);
		contenedor.add(lblNumeroJugadoresValor);

		cmbEquipo = new JComboBox<Equipo>();
		cmbEquipo.setForeground(new Color(0, 0, 128));
		cmbEquipo.setFont(new Font("Arial", Font.BOLD, 20));
		cmbEquipo.setBounds(578, 12, 193, 38);
		// contenedor.add(cmbEquipo);

		lblSumaSueldos = new JLabel("Suma Sueldos:");
		lblSumaSueldos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSumaSueldos.setForeground(new Color(0, 0, 128));
		lblSumaSueldos.setFont(new Font("Arial", Font.BOLD, 24));
		lblSumaSueldos.setBounds(199, 429, 179, 40);
		contenedor.add(lblSumaSueldos);

		lblSumaSueldosValor = new JLabel("0.0");
		lblSumaSueldosValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSumaSueldosValor.setForeground(new Color(255, 128, 0));
		lblSumaSueldosValor.setFont(new Font("Arial", Font.BOLD, 24));
		lblSumaSueldosValor.setBounds(388, 429, 98, 40);
		contenedor.add(lblSumaSueldosValor);

		// creo el vector para los datos de la JTable
		datosTabla = new Vector<Vector<String>>();

		// creo el DefaultTableModel
		dtmTabla = new DefaultTableModel(datosTabla, columnas);

		// creo la JTable de calificaciones
		tabla = new JTable(dtmTabla);
		tabla.setFont(new Font("Arial", Font.BOLD, 20));
		tabla.setForeground(new Color(0, 0, 128));
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setRowHeight(30);
		btnBorrar.addActionListener(this);

		scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(43, 62, 685, 356);
		contenedor.add(scrollPane);

		createTable();
		actualizarTotales();

	}

	public void createTable() {
		// Se conecta a la base de datos
		// crea una base de datos si todavia no existe
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:db/jugadores.odb");
		EntityManager em = emf.createEntityManager();

		// si se ha conectado correctamente
		Vector<String> columnas = new Vector<String>();
		columnas.add("DNI");
		columnas.add("Nombre");
		columnas.add("Apellidos");
		columnas.add("Dorsal");
		columnas.add("sueldo");
		columnas.add("IdEquipo");

		// creo el vector para los datos de la tabla
		datosTabla = new Vector<Vector<String>>();
		Vector<String> fila = new Vector<String>();
		// ejecuto la consulta
		TypedQuery<Jugador> tq1 = em.createQuery("SELECT a FROM Jugador a", Jugador.class);
		List<Jugador> results = tq1.getResultList();
		for (Jugador a : results) {

			fila = new Vector<String>();
			fila.add(a.getDni());
			fila.add(a.getNombre());
			fila.add(a.getApellidos());
			fila.add("" + a.getdorsal());
			fila.add("" + a.getsueldo());
			fila.add("" + a.getidEquipo());
			fila.add("\n\n\n\n\n\n\n");
			datosTabla.add(fila);
		}

		// Cierro el EntityManager
		em.close();

		// Cierro el EntityManagerFactory
		emf.close();

		// creo el DefaultTableModel de la JTable
		dtmTabla = new DefaultTableModel(datosTabla, columnas);

		// creo una tabla y le añado el modelo por defecto
		tabla.setModel(dtmTabla);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o == btnBorrar) {
			// compruebo que haya algun Usuario seleccionado en la tabla
			int filas = tabla.getSelectedRowCount();
			if (filas == 0) {
				// si no hay ningun elemento seleccionado
				JOptionPane.showMessageDialog(this, "Error,Debe seleccionar una fila para borrar.",
						"Ningun elemento seleccionado", JOptionPane.ERROR_MESSAGE, null);

			} else {
				// Se conecta a la base de datos
				// crea una base de datos si todavia no existe
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:db/jugadores.odb");
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				// creo una consulta
				Query q;
				String consulta;
				String dni;

				// obtengo la posicion a borrar en la tabla
				int borrar = tabla.getSelectedRow();

				// lo borro de la base de datos a traves del dni
				dni = (String) dtmTabla.getValueAt(borrar, 0);
				consulta = "DELETE FROM Jugador a WHERE a.dni = '" + dni + "'";
				System.out.println(consulta);
				q = em.createQuery(consulta);
				q.executeUpdate();

				// informamos del borrado
				JOptionPane.showMessageDialog(this, "Se ha eliminado el usuario correctamente",
						"Usuario borrado correctamente", JOptionPane.INFORMATION_MESSAGE, null);

				// guardo los cambios de la base de datos
				em.getTransaction().commit();
				// lo borro de la tabla
				// dtmTabla.removeRow(borrar);
				createTable();
				actualizarTotales();

				// Ponemos los campos vacíos
				// txtNombre.setText("");
				// txtPass.setText("");
				// cmbPermisos.setSelectedIndex(-1);

				em.close();
				emf.close();
			}

		

		}

	}
	public void actualizarTotales() {
		lblNumeroJugadoresValor.setText("" + dtmTabla.getRowCount());

		double sumaSueldos = 0;
		for (int i = 0; i < dtmTabla.getRowCount(); i++) {
			double sueldo = Double.parseDouble((String) dtmTabla.getValueAt(i, 4));
			sumaSueldos += sueldo;
		}
		lblSumaSueldosValor.setText("" + sumaSueldos);
		
		if(sumaSueldos == 0) {
			lblMediaSueldosValor.setText("0.0");
			lblInfo.setText("No hay Registros");
		}else {
			lblMediaSueldosValor.setText(""+(sumaSueldos/(dtmTabla.getRowCount())));
			lblInfo.setText("Listado de jugadores");
		}

	
	}
}
