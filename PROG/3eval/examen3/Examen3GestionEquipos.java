package examen3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.objectdb.o.JOP;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Examen3GestionEquipos extends JFrame implements ActionListener, MouseListener, ItemListener {

	private static final long serialVersionUID = -202405211L;

	private JPanel contenedor;
	private JButton btnSalir;
	private JButton btnInsertar;
	private JButton btnBorrar;

	private JLabel lblIdJugador;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JTextField txtIdJugador;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JLabel lblEquipoInfo;

	private JLabel lblDorsal;
	private JTextField txtDorsal;

	private DefaultTableModel dtmTabla;
	private JTable tabla;

	private JScrollPane scrollPane;
	private JComboBox<String> cmbEquipoNombre;
	private JComboBox<Equipo> cmbEquipo;

	private Vector<String> columnas;
	private Vector<Vector<String>> datosTabla;

	private JLabel lblSumaSueldos;
	private JLabel lblBalanceValor;

	private JLabel lblEquipo;

	private JLabel lblBalance;
	private JTextField txtSueldo;

	private JLabel lblSueldo;
	private JLabel lblNumeroJugadores;
	private JLabel lblNumeroJugadoresValor;
	private JLabel lblSumaSueldosValor;

	private TableRowSorter<TableModel> metodoOrdenacion;
	private String equipoSeleccionado;

	ArrayList<Equipo> equipos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Examen3GestionEquipos frame = new Examen3GestionEquipos();
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
	public Examen3GestionEquipos() {
		// setType(Type.UTILITY);
		setForeground(new Color(0, 0, 128));
		setFont(new Font("Arial", Font.BOLD, 20));
		setResizable(false);
		setTitle("Examen3GestionEquipos - Imanol Gullon");

		setBounds(100, 100, 797, 717);
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedor);
		contenedor.setLayout(null);

		lblIdJugador = new JLabel("IdJugador:");
		lblIdJugador.setForeground(new Color(0, 0, 128));
		lblIdJugador.setFont(new Font("Arial", Font.BOLD, 24));
		lblIdJugador.setBounds(43, 112, 128, 40);
		contenedor.add(lblIdJugador);

		txtIdJugador = new JTextField();
		txtIdJugador.setColumns(10);
		txtIdJugador.setForeground(new Color(0, 0, 128));
		txtIdJugador.setFont(new Font("Arial", Font.BOLD, 24));
		txtIdJugador.setSize(400, 40);
		txtIdJugador.setLocation(168, 112);
		contenedor.add(txtIdJugador);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(0, 0, 128));
		lblNombre.setFont(new Font("Arial", Font.BOLD, 24));
		lblNombre.setLocation(43, 162);
		lblNombre.setSize(115, 40);
		contenedor.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(0, 0, 128));
		txtNombre.setFont(new Font("Arial", Font.BOLD, 24));
		txtNombre.setLocation(168, 163);
		txtNombre.setSize(400, 40);
		contenedor.add(txtNombre);
		txtNombre.setColumns(10);

		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setForeground(new Color(0, 0, 128));
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 24));
		lblApellidos.setLocation(43, 213);
		lblApellidos.setSize(128, 40);
		contenedor.add(lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setForeground(new Color(0, 0, 128));
		txtApellidos.setFont(new Font("Arial", Font.BOLD, 24));
		txtApellidos.setLocation(168, 214);
		txtApellidos.setSize(400, 40);
		contenedor.add(txtApellidos);
		txtApellidos.setColumns(10);

		lblDorsal = new JLabel("Dorsal:");
		lblDorsal.setForeground(new Color(0, 0, 128));
		lblDorsal.setFont(new Font("Arial", Font.BOLD, 24));
		lblDorsal.setLocation(43, 264);
		lblDorsal.setSize(115, 40);
		contenedor.add(lblDorsal);

		txtDorsal = new JTextField();
		txtDorsal.setForeground(new Color(0, 0, 128));
		txtDorsal.setFont(new Font("Arial", Font.BOLD, 24));
		txtDorsal.setLocation(168, 265);
		txtDorsal.setSize(400, 40);
		contenedor.add(txtDorsal);
		txtDorsal.setColumns(10);

		lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setForeground(new Color(0, 0, 128));
		lblSueldo.setFont(new Font("Arial", Font.BOLD, 24));
		lblSueldo.setBounds(43, 317, 115, 40);
		contenedor.add(lblSueldo);

		txtSueldo = new JTextField();
		txtSueldo.setForeground(new Color(0, 0, 128));
		txtSueldo.setFont(new Font("Arial", Font.BOLD, 24));
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(168, 315, 400, 40);
		contenedor.add(txtSueldo);

		btnInsertar = new JButton("Insertar");
		btnInsertar.setForeground(new Color(0, 0, 128));
		btnInsertar.setFont(new Font("Arial", Font.BOLD, 24));
		btnInsertar.setSize(128, 40);
		btnInsertar.setLocation(578, 112);
		contenedor.add(btnInsertar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(new Color(0, 0, 128));
		btnBorrar.setFont(new Font("Arial", Font.BOLD, 24));
		btnBorrar.setLocation(578, 163);
		btnBorrar.setSize(128, 40);
		contenedor.add(btnBorrar);

		btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(0, 0, 128));
		btnSalir.setFont(new Font("Arial", Font.BOLD, 24));
		btnSalir.setLocation(578, 317);
		btnSalir.setSize(128, 40);
		contenedor.add(btnSalir);

		lblEquipoInfo = new JLabel("No hay un Equipo Seleccionado");
		lblEquipoInfo.setForeground(new Color(255, 128, 0));
		lblEquipoInfo.setFont(new Font("Arial", Font.BOLD, 24));
		lblEquipoInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipoInfo.setLocation(43, 61);
		lblEquipoInfo.setSize(663, 40);
		contenedor.add(lblEquipoInfo);

		lblEquipo = new JLabel("Equipo:");
		lblEquipo.setForeground(new Color(0, 0, 128));
		lblEquipo.setFont(new Font("Arial", Font.BOLD, 24));
		lblEquipo.setBounds(43, 11, 115, 40);
		contenedor.add(lblEquipo);

		lblBalanceValor = new JLabel("0.0");
		lblBalanceValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBalanceValor.setForeground(new Color(255, 128, 0));
		lblBalanceValor.setFont(new Font("Arial", Font.BOLD, 24));
		lblBalanceValor.setBounds(651, 630, 120, 40);
		contenedor.add(lblBalanceValor);

		lblBalance = new JLabel("Balance:");
		lblBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBalance.setForeground(new Color(0, 0, 128));
		lblBalance.setFont(new Font("Arial", Font.BOLD, 24));
		lblBalance.setBounds(537, 630, 98, 40);
		contenedor.add(lblBalance);

		cmbEquipoNombre = new JComboBox<String>();
		cmbEquipoNombre.setForeground(new Color(0, 0, 128));
		cmbEquipoNombre.setFont(new Font("Arial", Font.BOLD, 20));
		cmbEquipoNombre.setBounds(168, 13, 400, 38);
		contenedor.add(cmbEquipoNombre);

		lblNumeroJugadores = new JLabel("Jugadores:");
		lblNumeroJugadores.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroJugadores.setForeground(new Color(0, 0, 128));
		lblNumeroJugadores.setFont(new Font("Arial", Font.BOLD, 24));
		lblNumeroJugadores.setBounds(10, 630, 134, 40);
		contenedor.add(lblNumeroJugadores);

		lblNumeroJugadoresValor = new JLabel("0");
		lblNumeroJugadoresValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroJugadoresValor.setForeground(new Color(255, 128, 0));
		lblNumeroJugadoresValor.setFont(new Font("Arial", Font.BOLD, 24));
		lblNumeroJugadoresValor.setBounds(140, 630, 47, 40);
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
		lblSumaSueldos.setBounds(199, 630, 179, 40);
		contenedor.add(lblSumaSueldos);

		lblSumaSueldosValor = new JLabel("0.0");
		lblSumaSueldosValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSumaSueldosValor.setForeground(new Color(255, 128, 0));
		lblSumaSueldosValor.setFont(new Font("Arial", Font.BOLD, 24));
		lblSumaSueldosValor.setBounds(388, 630, 139, 40);
		contenedor.add(lblSumaSueldosValor);

		// creo el DefaultTableModel
		dtmTabla = new DefaultTableModel();

		// creo la JTable
		tabla = new JTable();
		tabla.setFont(new Font("Arial", Font.BOLD, 20));
		tabla.setForeground(new Color(0, 0, 128));
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setRowHeight(30);

		// metodoOrdenacion = new TableRowSorter<TableModel>(dtmTabla);
		// tabla.setRowSorter(metodoOrdenacion);
		btnInsertar.addActionListener(this);
		btnBorrar.addActionListener(this);
		btnSalir.addActionListener(this);

		scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(43, 373, 685, 246);
		contenedor.add(scrollPane);
		tabla.addMouseListener(this);
		cmbEquipoNombre.addItemListener(this);
		txtIdJugador.setText("X");
		txtNombre.setText("Nombre X");
		txtApellidos.setText("Apellidos X");
		txtDorsal.setText("0");
		txtSueldo.setText("0.0");
		equipos = new ArrayList<Equipo>();
		comboBox();
		createTable();
		actualizarTotales();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o == btnInsertar) {
			if (txtIdJugador.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Introduce todos los campos");
			} else {

				try {
					// hago la conexion
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/examen3bd", "root", "");
					// creo el Statement
					Statement st = conexion.createStatement();

					// saco los datos
					String idJugador = txtIdJugador.getText();
					String nombre = txtNombre.getText();
					String nombreJ = txtApellidos.getText();
					String dorsal = txtDorsal.getText();
					String sueldo = txtSueldo.getText();
					// introduzco un nuevo registro
					String consulta = "INSERT INTO examen3bd.jugadores VALUES ('" + idJugador + "','" + nombre + "','"
							+ nombreJ + "', '" + dorsal + "', '" + sueldo
							+ "', (SELECT idEquipo FROM equipos WHERE nombre = '" + equipoSeleccionado + "'));";

					st.executeUpdate(consulta);

					// Cierro el statement
					st.close();

					// cierro la conexion
					conexion.close();

					JOptionPane.showMessageDialog(this, "El registro se ha introducido correctamente.",
							"Elemento introducido", JOptionPane.INFORMATION_MESSAGE, null);

					// actualizo la tabla
					createTable();
					actualizarTotales();

				} catch (SQLException i) {
					// si se produce una excepción SQL
					int errorcode = i.getErrorCode();
					if (errorcode == 1062) {
						// si es un error de clave duplicada
						JOptionPane.showMessageDialog(this,
								"Error. Ya existe un registro con el id: "+txtIdJugador.getText()+".", "Clave duplicada",
								JOptionPane.ERROR_MESSAGE, null);
					} else {
						// si se produce cualquier otro error sql
						JOptionPane.showMessageDialog(this,
								"Error SQL Numero " + i.getErrorCode() + ":" + i.getMessage(), "Clave duplicada",
								JOptionPane.ERROR_MESSAGE, null);
					}
				}
			}
		}

		if (o == btnBorrar) {
			// comprobamos que se haya seleccionado alguna fila
			int filaSeleccionada = tabla.getSelectedRow();

			if (filaSeleccionada == -1) {
				JOptionPane.showMessageDialog(this, "Error. Debe seleccionar una fila para borrar");
			} else {
				// si todo esta bien
				// hacemos la conexion
				try {

					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/examen3bd", "root", "");

					// creo el Statement
					Statement st = conexion.createStatement();

					// saco los datos
					String idJugador = (String) dtmTabla.getValueAt(filaSeleccionada, 0);

					// hacemos la consulta
					String consulta = "DELETE FROM examen3bd.jugadores WHERE idJugador='" + idJugador + "';";
					System.out.println(consulta);
					// la ejecutamos
					int registrosmodificados = st.executeUpdate(consulta);

					if (registrosmodificados > 0) {
						// si se ha eliminado correctamente
						JOptionPane.showMessageDialog(this, "El registro se ha borrado correctamente.",
								"Elemento eliminado", JOptionPane.INFORMATION_MESSAGE, null);

						createTable();
						actualizarTotales();
					}

					else {

						// si no se ha modificado el registro
						JOptionPane.showMessageDialog(this, "Error, no se ha borrado el registro.", "Error al borrar",
								JOptionPane.ERROR_MESSAGE, null);

					}

					// Cierro el statement
					st.close();

					// cierro la conexion
					conexion.close();

				}

				catch (SQLException i) {
					// si se produce una excepción SQL
					int errorcode = i.getErrorCode();
					if (errorcode == 1062) {
						// si es un error de clave duplicada
						JOptionPane.showMessageDialog(this,
								"Error Clave Duplicada. Ya existe un registro con esa clave.", "Clave duplicada",
								JOptionPane.ERROR_MESSAGE, null);
					} else {
						// si se produce cualquier otro error sql
						JOptionPane.showMessageDialog(this,
								"Error SQL Numero " + i.getErrorCode() + ":" + i.getMessage(), "Clave duplicada",
								JOptionPane.ERROR_MESSAGE, null);
					}
				}
			}
		}
		if (o == btnSalir) {
			System.exit(0);
		}

	}

	public void comboBox() {
		try {
			// nombre de la base de datos, "usuario", "contraseña"
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/examen3bd", "root", "");
			// creo el statement(para que recorra bidireccionalmente las tablas)
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// hago la consulta
			ResultSet rs = st.executeQuery("SELECT * FROM examen3bd.equipos;");

			// mientras haya registros
			while (rs.next()) {
				int idEquipo = Integer.parseInt(rs.getString("idEquipo"));
				String nombreEquipo = rs.getString("nombre");
				int fundacionEquipo = Integer.parseInt(rs.getString("fundacion"));
				double presupuesto = Double.parseDouble(rs.getString("fundacion"));
				cmbEquipoNombre.addItem(nombreEquipo);
				Equipo e = new Equipo(idEquipo, nombreEquipo, fundacionEquipo, presupuesto);
				equipos.add(e);
			}

			// cierro el statement
			rs.close();
			// cierro la conexion
			conexion.close();
			equipoSeleccionado = (String) cmbEquipoNombre.getSelectedItem();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al conectar");
		}
	}

	public void createTable() {
		// creo las columnas de la cabecera para calificaciones
		columnas = new Vector<String>();
		columnas.add("idJugador");
		columnas.add("nombre");
		columnas.add("apellidos");
		columnas.add("dorsal");
		columnas.add("sueldo");

		try {
			// inicializo el vector de filas(Vector de vectores) declarado a nivel de clase
			datosTabla = new Vector<>();
			// nombre de la base de datos, "usuario", "contraseña"
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/examen3bd", "root", "");

			// creo el statement(para que recorra bidireccionalmente las tablas)
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// hago la consulta
			ResultSet rs = st.executeQuery(
					"SELECT idJugador, j.nombre, apellidos, dorsal, sueldo FROM examen3bd.jugadores j, examen3bd.equipos e where j.idEquipo = e.idEquipo and e.idEquipo = (SELECT idEquipo FROM equipos WHERE nombre = '"
							+ equipoSeleccionado + "');");
			// mientras haya registros
			while (rs.next()) {
				// creo el vector que guarda cada fila
				Vector<String> fila = new Vector<>();
				fila.add(rs.getString("idJugador"));
				fila.add(rs.getString("nombre"));
				fila.add(rs.getString("apellidos"));
				fila.add(rs.getString("dorsal"));
				fila.add(rs.getString("sueldo"));

				datosTabla.add(fila);

			}

			// inicializamos el dtm de nuevo con sus datos
			dtmTabla = new DefaultTableModel(datosTabla, columnas) {

				@Override
				public boolean isCellEditable(int row, int column) {
					// hago que todas las celdas de la tabla NO sean editables
					return false;
				}
			};
			// aplicas el modelo
			tabla.setModel(dtmTabla);

			// cierro el statement
			rs.close();
			// cierro la conexion
			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al conectar");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// selecciono la fila y la convierto a la filaReal
		int fila = tabla.getSelectedRow();
		// int filaReal = tabla.convertRowIndexToModel(fila);
		// asigno los valores
		txtIdJugador.setText("" + dtmTabla.getValueAt(fila, 0));
		txtNombre.setText("" + dtmTabla.getValueAt(fila, 1));
		txtApellidos.setText("" + dtmTabla.getValueAt(fila, 2));
		txtDorsal.setText("" + dtmTabla.getValueAt(fila, 3));
		txtSueldo.setText("" + dtmTabla.getValueAt(fila, 4));

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		equipoSeleccionado = (String) cmbEquipoNombre.getSelectedItem();
		createTable();
		txtIdJugador.setText("X");
		txtNombre.setText("Nombre X");
		txtApellidos.setText("Apellidos X");
		txtDorsal.setText("0");
		txtSueldo.setText("0.0");

		actualizarTotales();

	}

	public void actualizarTotales() {
		lblNumeroJugadoresValor.setText("" + dtmTabla.getRowCount());

		double sumaSueldos = 0;
		for (int i = 0; i < dtmTabla.getRowCount(); i++) {
			double sueldo = Double.parseDouble((String) dtmTabla.getValueAt(i, 4));
			sumaSueldos += sueldo;
		}
		lblSumaSueldosValor.setText("" + sumaSueldos);
		double presupuesto = 0;

		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/examen3bd", "root", "");

			// creo el statement(para que recorra bidireccionalmente las tablas)
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// hago la consulta
			String consulta = "SELECT presupuesto FROM examen3bd.equipos e where e.idEquipo = (SELECT idEquipo FROM equipos WHERE nombre = '"
					+ equipoSeleccionado + "');";
			ResultSet rs = st.executeQuery(consulta);
			while (rs.next()) {
				presupuesto = Double.parseDouble(rs.getString("presupuesto"));
			}

			// cierro el statement
			rs.close();
			// cierro la conexion
			conexion.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error al conectar");
		}
		if (dtmTabla.getRowCount() == 0) {
			lblBalanceValor.setText("0.0");
		} else {
			lblBalanceValor.setText("" + (presupuesto - sumaSueldos));
		}
	}

}
