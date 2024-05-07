package examen2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;

import examen3.Auto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.Color;
import javax.swing.JTable;

public class GestionEquiposBaloncesto extends JFrame implements ActionListener, MouseListener, WindowListener {

	private static final long serialVersionUID = 202403053L;
	private JPanel contenedor;
	private JButton btnSalir;
	private JButton btnInsertar;
	private JButton btnBorrar;

	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblPlantilla;
	private JLabel lblPresupuesto;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPlantilla;
	private JTextField txtPresupuesto;
	private JLabel lblCreacion;
	private JTextField txtCreacion;
	private JLabel lblGanados;
	private JTextField txtGanados;
	private JLabel lblPerdidos;
	private JTextField txtPerdidos;

	private Vector<String> columnas;
	private Vector<Vector<String>> datosTabla;
	private DefaultTableModel dtmTabla;
	private JTable tabla;
	private JScrollPane scrollPane;

	private JLabel lblTotalEquipos;
	private JLabel lblTotalEquiposValor;
	private JLabel lblPresupuestoMedio;
	private JLabel lblPresupuestoMedioValor;
	private JLabel lblPresupuestoTotal;
	private JLabel lblPresupuestoTotalValor;

	// array de clase donde van los objetos
	private ArrayList<EquipoBaloncesto> equipos;

	private boolean modificado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionEquiposBaloncesto frame = new GestionEquiposBaloncesto();
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
	public GestionEquiposBaloncesto() {
		setResizable(false);
		setForeground(new Color(0, 0, 128));
		setFont(new Font("Arial", Font.BOLD, 20));
		setTitle("GestionEquiposBaloncesto - Imanol Gullón");
		setLocationRelativeTo(null);
		setBounds(100, 100, 1324, 807);

		// controlo el cierre del JFrame
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedor);
		contenedor.setLayout(null);

		lblCodigo = new JLabel("Codigo");
		lblCodigo.setForeground(new Color(0, 0, 128));
		lblCodigo.setFont(new Font("Arial", Font.BOLD, 24));
		lblCodigo.setBounds(210, 22, 128, 40);
		contenedor.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setText("E00");
		txtCodigo.setForeground(new Color(0, 0, 128));
		txtCodigo.setFont(new Font("Arial", Font.BOLD, 24));
		txtCodigo.setSize(171, 40);
		txtCodigo.setLocation(335, 22);
		contenedor.add(txtCodigo);

		lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(0, 0, 128));
		lblNombre.setFont(new Font("Arial", Font.BOLD, 24));
		lblNombre.setLocation(210, 73);
		lblNombre.setSize(115, 40);
		contenedor.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setText("Equipo 00");
		txtNombre.setForeground(new Color(0, 0, 128));
		txtNombre.setFont(new Font("Arial", Font.BOLD, 24));
		txtNombre.setLocation(335, 74);
		txtNombre.setSize(368, 40);
		contenedor.add(txtNombre);

		lblCreacion = new JLabel("Creación");
		lblCreacion.setForeground(new Color(0, 0, 128));
		lblCreacion.setFont(new Font("Arial", Font.BOLD, 24));
		lblCreacion.setBounds(210, 124, 115, 40);
		contenedor.add(lblCreacion);

		txtCreacion = new JTextField();
		txtCreacion.setColumns(4);
		txtCreacion.setText("2024");
		txtCreacion.setHorizontalAlignment(SwingConstants.CENTER);
		txtCreacion.setForeground(new Color(0, 0, 128));
		txtCreacion.setFont(new Font("Arial", Font.BOLD, 24));
		txtCreacion.setBounds(332, 124, 63, 40);
		contenedor.add(txtCreacion);

		lblPlantilla = new JLabel("Plantilla");
		lblPlantilla.setForeground(new Color(0, 0, 128));
		lblPlantilla.setFont(new Font("Arial", Font.BOLD, 24));
		lblPlantilla.setLocation(210, 176);
		lblPlantilla.setSize(115, 40);
		contenedor.add(lblPlantilla);

		txtPlantilla = new JTextField();
		txtPlantilla.setColumns(10);
		txtPlantilla.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPlantilla.setText("10");
		txtPlantilla.setForeground(new Color(0, 0, 128));
		txtPlantilla.setFont(new Font("Arial", Font.BOLD, 24));
		txtPlantilla.setLocation(332, 176);
		txtPlantilla.setSize(98, 40);
		contenedor.add(txtPlantilla);

		lblPresupuesto = new JLabel("Presupuesto");
		lblPresupuesto.setForeground(new Color(0, 0, 128));
		lblPresupuesto.setFont(new Font("Arial", Font.BOLD, 24));
		lblPresupuesto.setBounds(208, 227, 164, 40);
		contenedor.add(lblPresupuesto);

		txtPresupuesto = new JTextField();
		txtPresupuesto.setText("1000.0");
		txtPresupuesto.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPresupuesto.setForeground(new Color(0, 0, 128));
		txtPresupuesto.setFont(new Font("Arial", Font.BOLD, 24));
		txtPresupuesto.setColumns(10);
		txtPresupuesto.setBounds(377, 227, 211, 40);
		contenedor.add(txtPresupuesto);

		btnInsertar = new JButton("Insertar");
		btnInsertar.setForeground(new Color(0, 0, 128));
		btnInsertar.setFont(new Font("Arial", Font.BOLD, 24));
		btnInsertar.setSize(128, 40);
		btnInsertar.setLocation(933, 22);
		contenedor.add(btnInsertar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setForeground(new Color(0, 0, 128));
		btnBorrar.setFont(new Font("Arial", Font.BOLD, 24));
		btnBorrar.setLocation(933, 73);
		btnBorrar.setSize(128, 40);
		contenedor.add(btnBorrar);

		btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(0, 0, 128));
		btnSalir.setFont(new Font("Arial", Font.BOLD, 24));
		btnSalir.setLocation(933, 175);
		btnSalir.setSize(128, 40);
		contenedor.add(btnSalir);

		// cargo los datos en la tabla
		// creo la tabla
		// creo la cabecera de la tabla

		/*
		 * // obtengo los datos de la tabla datosTabla = new Vector<Vector<String>>();
		 * 
		 * // creo la JTable dtmTabla = new DefaultTableModel(datosTabla, columnas) {
		 * 
		 * private static final long serialVersionUID = 6705737250484018343L;
		 * 
		 * @Override public boolean isCellEditable(int row, int column) { // hago que
		 * todas las celdas de la tabla NO sean editables return false; } };
		 */
		tabla = new JTable(dtmTabla);
		tabla.setFont(new Font("Arial", Font.BOLD, 20));
		tabla.setForeground(new Color(0, 0, 128));
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setRowHeight(30);
		scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(27, 393, 1250, 319);
		contenedor.add(scrollPane);

		lblTotalEquipos = new JLabel("Total Equipos:");
		lblTotalEquipos.setForeground(new Color(0, 0, 128));
		lblTotalEquipos.setFont(new Font("Arial", Font.BOLD, 20));
		lblTotalEquipos.setBounds(27, 717, 144, 40);
		contenedor.add(lblTotalEquipos);

		lblTotalEquiposValor = new JLabel("0");
		lblTotalEquiposValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalEquiposValor.setForeground(new Color(0, 0, 128));
		lblTotalEquiposValor.setFont(new Font("Arial", Font.BOLD, 20));
		lblTotalEquiposValor.setBounds(181, 717, 40, 40);
		contenedor.add(lblTotalEquiposValor);

		lblPresupuestoMedio = new JLabel("Presupuesto Medio:");
		lblPresupuestoMedio.setForeground(new Color(0, 0, 128));
		lblPresupuestoMedio.setFont(new Font("Arial", Font.BOLD, 20));
		lblPresupuestoMedio.setBounds(488, 717, 195, 40);
		contenedor.add(lblPresupuestoMedio);

		lblPresupuestoMedioValor = new JLabel("0.0");
		lblPresupuestoMedioValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPresupuestoMedioValor.setForeground(new Color(0, 0, 128));
		lblPresupuestoMedioValor.setFont(new Font("Arial", Font.BOLD, 20));
		lblPresupuestoMedioValor.setBounds(680, 717, 115, 40);
		contenedor.add(lblPresupuestoMedioValor);

		lblGanados = new JLabel("Ganados");
		lblGanados.setForeground(new Color(0, 0, 128));
		lblGanados.setFont(new Font("Arial", Font.BOLD, 24));
		lblGanados.setBounds(210, 278, 115, 40);
		contenedor.add(lblGanados);

		txtGanados = new JTextField();
		txtGanados.setText("0");
		txtGanados.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGanados.setForeground(new Color(0, 0, 128));
		txtGanados.setFont(new Font("Arial", Font.BOLD, 24));
		txtGanados.setColumns(10);
		txtGanados.setBounds(332, 278, 98, 40);
		contenedor.add(txtGanados);

		lblPerdidos = new JLabel("Perdidos");
		lblPerdidos.setForeground(new Color(0, 0, 128));
		lblPerdidos.setFont(new Font("Arial", Font.BOLD, 24));
		lblPerdidos.setBounds(210, 329, 115, 40);
		contenedor.add(lblPerdidos);

		txtPerdidos = new JTextField();
		txtPerdidos.setText("0");
		txtPerdidos.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPerdidos.setForeground(new Color(0, 0, 128));
		txtPerdidos.setFont(new Font("Arial", Font.BOLD, 24));
		txtPerdidos.setColumns(10);
		txtPerdidos.setBounds(332, 329, 98, 40);
		contenedor.add(txtPerdidos);

		lblPresupuestoTotal = new JLabel("Presupuesto Total:");
		lblPresupuestoTotal.setForeground(new Color(0, 0, 128));
		lblPresupuestoTotal.setFont(new Font("Arial", Font.BOLD, 20));
		lblPresupuestoTotal.setBounds(955, 717, 195, 40);
		contenedor.add(lblPresupuestoTotal);

		lblPresupuestoTotalValor = new JLabel("0.0");
		lblPresupuestoTotalValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPresupuestoTotalValor.setForeground(new Color(0, 0, 128));
		lblPresupuestoTotalValor.setFont(new Font("Arial", Font.BOLD, 20));
		lblPresupuestoTotalValor.setBounds(1149, 717, 128, 40);
		contenedor.add(lblPresupuestoTotalValor);
		btnBorrar.addActionListener(this);
		btnInsertar.addActionListener(this);
		btnSalir.addActionListener(this);
		tabla.addMouseListener(this);
		this.addWindowListener(this);

		/////////////////////////////////////////////////////
		// inicializo el array
		equipos = new ArrayList<>();

		modificado = false;

		cargarEquipos();
		createTable();
	

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o == btnInsertar) {
			// compruebo que el campo codigo este relleno
			if (txtCodigo.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "ERROR. El campo 'Código' debe rellenarse", "Error Clave Duplicada",
						JOptionPane.ERROR_MESSAGE);
			} else {
				// saco los datos introducidos
				String cod = txtCodigo.getText();
				String nom = txtNombre.getText();
				int cre = Integer.valueOf(txtCreacion.getText());
				int pla = Integer.valueOf(txtPlantilla.getText());
				double pre = Double.valueOf(txtPresupuesto.getText());
				int ga = Integer.valueOf(txtGanados.getText());
				int pe = Integer.valueOf(txtPerdidos.getText());

				// creo los objetos
				Equipo e1 = new Equipo(cod, nom, cre, pla, pre);
				EquipoBaloncesto equipo = new EquipoBaloncesto(e1, ga, pe);
				// compruebo que el objeto no se encuentra en el arraylist donde guardo todos
				// los objetos
				if (!equipos.contains(equipo)) {
					// si no está, lo añado a dicho arraylist
					equipos.add(equipo);
					// Ordeno el arraylist
					Collections.sort(equipos);
					// llamo a la clase para añadir los datos a la tabla
					createTable();
					calcularTotales();
					modificado = true;
				} else {
					JOptionPane.showMessageDialog(this, "ERROR. Ya existe un código: " + cod, "Error Clave Duplicada",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		if (o == btnBorrar) {

			// CON SINGLE SELECTION
			int selectedIndex = tabla.getSelectedRow();
			if (selectedIndex == -1) {
				JOptionPane.showMessageDialog(this, "ERROR. Debe seleccionar una fila para borrar", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				dtmTabla.removeRow(selectedIndex);
				equipos.remove(selectedIndex);
				calcularTotales();
				modificado = true;
			}

		}
		if (o == btnSalir) {
			// llamo al windowClosing
			windowClosing(null);
		}

	}

	/*----------------------------CREAR LA TABLA-----------------------------*/
	private void createTable() {

		columnas = new Vector<String>();

		columnas.add("Código");
		columnas.add("Nombre");
		columnas.add("Año Creación");
		columnas.add("Jugadores en Plantilla");
		columnas.add("Presupuesto");
		columnas.add("Ganados");
		columnas.add("Perdidos");
		columnas.add("Porcentaje Victorias");

		// inicializo el vector de filas(Vector de vectores) declarado a nivel de clase
		datosTabla = new Vector<>();

		// Por cada objeto en el array autos
		for (int i = 0; i < equipos.size(); i++) {
			// creo el vector hijo (guarda una fila)
			Vector<String> fila = new Vector<>();
			// añadimos las partes del objeto al vector
			fila.add(equipos.get(i).getCodigo());
			fila.add(equipos.get(i).getNombre());
			fila.add(String.valueOf(equipos.get(i).getCreacion()));
			;
			fila.add(String.valueOf(equipos.get(i).getPlantilla()));
			fila.add(String.valueOf(equipos.get(i).getPresupuesto()));
			fila.add(String.valueOf(equipos.get(i).getGanados()));
			fila.add(String.valueOf(equipos.get(i).getPerdidos()));
			fila.add(String.valueOf(equipos.get(i).porcentajeVictorias()));

			// añado dicha fila al vector de datos
			datosTabla.add(fila);
		}
		// inicializamos el dtm de nuevo con sus datos
		dtmTabla = new DefaultTableModel(datosTabla, columnas) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 7604096816700085422L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// hago que todas las celdas de la tabla NO sean editables
				return false;
			}
		};
		// aplico el modelo
		tabla.setModel(dtmTabla);
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		actualizarCampos();
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void actualizarCampos() {
		// sacamos en que fila se ha hecho click
		int seleccion = tabla.getSelectedRow();
		// si se ha hecho click en una fila
		if (seleccion >= 0) {
			// Establecemos los valores de los txt
			txtCodigo.setText((String) dtmTabla.getValueAt(seleccion, 0));
			txtNombre.setText((String) dtmTabla.getValueAt(seleccion, 1));
			txtCreacion.setText((String) dtmTabla.getValueAt(seleccion, 2));
			txtPlantilla.setText((String) dtmTabla.getValueAt(seleccion, 3));
			txtPresupuesto.setText((String) dtmTabla.getValueAt(seleccion, 4));
			txtGanados.setText((String) dtmTabla.getValueAt(seleccion, 5));
			txtPerdidos.setText((String) dtmTabla.getValueAt(seleccion, 6));
		}
	}

	/*--------------------------------VENTANA----------------------------------------------*/
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// si algo se ha modificado
		if (modificado) {
			// muestro opciones de guardado
			int opcion = JOptionPane.showConfirmDialog(null, "¿Quieres guardar los cambios realizados?", "Confirmación",
					JOptionPane.YES_NO_CANCEL_OPTION);
			// si pulsa en 'SI'
			if (opcion == JOptionPane.YES_OPTION) {
				guardarEquipos();
				System.exit(0);
				// si pulsa en 'NO'
			} else if (opcion == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
		} else
			System.exit(0); // si no se ha modificado nada
		// si no se ha modificado nada:

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	/*-----------------------------------SERIALIZACIÓN-----------------------------------------------------*/
	private void guardarEquipos() {
		try {
			FileOutputStream fos = new FileOutputStream("equiposbaloncesto.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// guardo la lista de autos
			oos.writeObject(equipos);
			oos.close();
			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private void cargarEquipos() {
		try {

			FileInputStream fis;
			fis = new FileInputStream("equiposbaloncesto.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			equipos = (ArrayList<EquipoBaloncesto>) ois.readObject();
			// pinto la tabla y actualizo los totales
			createTable();
			calcularTotales();

			ois.close();
			fis.close();
		} catch (EOFException e) {
			System.out.println("Archivo vacio");
		} catch (FileNotFoundException e) {
			System.out.println("no existe el archivo");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("no existe la clase");

		} catch (ClassCastException e) {
			System.out.println("el objeto no es el mismo");
		}

	}

	public void calcularTotales() {
		// total de equipos
		int tamaño = equipos.size();
		lblTotalEquiposValor.setText(String.valueOf(tamaño));
		
		//presupuesto total
		double totalPresupuesto = 0.0;
		for (int i = 0; i < equipos.size(); i++) {
			totalPresupuesto += equipos.get(i).getPresupuesto();
		}
		lblPresupuestoTotalValor.setText(String.valueOf(totalPresupuesto));
		
		//presupuesto medio
		if(totalPresupuesto!=0 || tamaño!=0) {
		lblPresupuestoMedioValor.setText(""+totalPresupuesto/tamaño);
		}else lblPresupuestoMedioValor.setText("0");
		

	}
}
