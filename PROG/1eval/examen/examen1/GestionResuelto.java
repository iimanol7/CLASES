package examen1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Collections;
import java.util.List;

public class GestionResuelto extends JFrame {

	private static final long serialVersionUID = 20231122L;
	private JPanel contentPane;
	private JTextField txtNumero;
	private JPanel panelCabecera;
	private JLabel lblNumero;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnLimpiar;

	private JPanel panelPie;
	private JLabel lblTotalNumeros;
	private JLabel lblTotalNumerosValor;
	private JLabel lblMedia;
	private JLabel lblMediaValor;

	private JPanel panelCentral;
	private JPanel panelPrimos;
	private JLabel lblPrimos;
	private JList<Integer> lstPrimos;
	private DefaultListModel<Integer> dlmPrimos;
	private JPanel panelNoPrimos;
	private JLabel lblNoPrimos;
	private JList<Integer> lstNoPrimos;
	private DefaultListModel<Integer> dlmNoPrimos;

	int valornum = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionPrimos frame = new GestionPrimos();
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
	public GestionResuelto() {
		setTitle("Examen1 - Gael Ortiz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panelCabecera = new JPanel();
		contentPane.add(panelCabecera, BorderLayout.NORTH);

		lblNumero = new JLabel("Número");
		panelCabecera.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtNumero.selectAll();
			}
		});
		txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNumero.setText("0");
		panelCabecera.add(txtNumero);
		txtNumero.setColumns(10);

		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String numerotexto = txtNumero.getText().trim();

				if (numerotexto.isEmpty()) {
				    JOptionPane.showMessageDialog(null, "Por favor, introduzca un número", "Campo Vacio", JOptionPane.ERROR_MESSAGE);
				} else {
				    int numero = Integer.parseInt(numerotexto);
				    if (dlmPrimos.contains(numero) || dlmNoPrimos.contains(numero)) {
				        JOptionPane.showMessageDialog(null, "Por favor, introduzca otro numero", "Error al Insertar", JOptionPane.ERROR_MESSAGE);
				    }
				    else {
				    	//Actualizar el valor total de los numeros de las listas
						valornum = valornum + numero;
						
						//Es primo
						if (numeroprimo(numero)) {
							dlmPrimos.addElement(numero);
						    ordenarListaDescendentemente(dlmPrimos);
						}
						//No es primo
						else {
							dlmNoPrimos.addElement(numero);
						    ordenarListaDescendentemente(dlmNoPrimos);


						}
						lblTotalNumerosValor.setText(String.valueOf(calcularTotales()));
						lblMediaValor.setText(String.format("%.2f", calcularMedia()));
				    }
				  }
				}
		});
		panelCabecera.add(btnInsertar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        int[] selectedIndicesP = lstPrimos.getSelectedIndices();
		        int[] selectedIndicesNP = lstNoPrimos.getSelectedIndices();

		        // Borrar elementos seleccionados en la lista de primos
		        //Se añade -1 porque los arrays empizan por 0,1... y .length empiza a contar por 1,2...
		        for (int i = selectedIndicesP.length - 1; i >= 0; i--) {
		        	//Al haber restado 1 al array i = elementos del array
		            valornum = valornum - dlmPrimos.get(selectedIndicesP[i]);
		            
		            dlmPrimos.removeElementAt(selectedIndicesP[i]);
		        }

		        // Borrar elementos seleccionados en la lista de no primos
		        for (int i = selectedIndicesNP.length - 1; i >= 0; i--) {
		            valornum = valornum - dlmNoPrimos.get(selectedIndicesNP[i]);
		            
		            dlmNoPrimos.removeElementAt(selectedIndicesNP[i]);
		        }
		        
		        //Si no hay Equipos en las listas
	            if (calcularTotales() == 0) {
	                lblMediaValor.setText("0,00");
	            } 
	            //Actualizar el valor de las Medias
	            else {
	                lblMediaValor.setText(String.format("%.2f", calcularMedia()));
	            }
	            
	            //Actualizar el valor de Numeros Totales
	            lblTotalNumerosValor.setText(String.valueOf(calcularTotales()));

	            
		        if (selectedIndicesP.length == 0 && selectedIndicesNP.length == 0) {
		            JOptionPane.showMessageDialog(null, "NO hay elementos seleccionados en las listas", "Error al Borrar", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		panelCabecera.add(btnBorrar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dlmPrimos.isEmpty() && dlmNoPrimos.isEmpty()){
					JOptionPane.showMessageDialog(null, "Las listas ya están vacias", "Error al vaciar las listas", JOptionPane.ERROR_MESSAGE);
				}
				else {
					dlmPrimos.removeAllElements();
					dlmNoPrimos.removeAllElements();
										
					lblTotalNumerosValor.setText("0");
					lblMediaValor.setText("0,00");
					
					valornum = 0;
					
					txtNumero.setText("0");
				}
			}
		});
		panelCabecera.add(btnLimpiar);

		panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));

		panelPrimos = new JPanel();
		panelCentral.add(panelPrimos, BorderLayout.WEST);
		panelPrimos.setLayout(new BorderLayout(0, 0));

		// creo el modelo de datos de la lista lstPrimos
		dlmPrimos = new DefaultListModel<Integer>();

		// creo la lista
		lstPrimos = new JList<Integer>();
		// asocio el modelo de datos a la lista
		lstPrimos.setModel(dlmPrimos);
		panelPrimos.add(lstPrimos, BorderLayout.CENTER);

		lblPrimos = new JLabel("Numeros Primos");
		lblPrimos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrimos.setHorizontalAlignment(SwingConstants.CENTER);
		panelPrimos.add(lblPrimos, BorderLayout.NORTH);

		panelNoPrimos = new JPanel();
		panelCentral.add(panelNoPrimos, BorderLayout.EAST);
		panelNoPrimos.setLayout(new BorderLayout(0, 0));

		lblNoPrimos = new JLabel("Números No Primos");
		lblNoPrimos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNoPrimos.setHorizontalAlignment(SwingConstants.CENTER);
		panelNoPrimos.add(lblNoPrimos, BorderLayout.NORTH);

		// creo el modelo de datos de la lista lstNoPrimos
		dlmNoPrimos = new DefaultListModel<Integer>();

		// creo la lista
		lstNoPrimos = new JList<Integer>();
		// asocio el modelo de datos a la lista
		lstNoPrimos.setModel(dlmNoPrimos);
		panelNoPrimos.add(lstNoPrimos, BorderLayout.CENTER);

		panelPie = new JPanel();
		contentPane.add(panelPie, BorderLayout.SOUTH);

		lblTotalNumeros = new JLabel("Total Numeros:");
		panelPie.add(lblTotalNumeros);

		lblTotalNumerosValor = new JLabel("0");
		lblTotalNumerosValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalNumerosValor.setHorizontalAlignment(SwingConstants.RIGHT);
		panelPie.add(lblTotalNumerosValor);

		lblMedia = new JLabel("Media:");
		panelPie.add(lblMedia);

		lblMediaValor = new JLabel("0,00");
		lblMediaValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMediaValor.setHorizontalAlignment(SwingConstants.RIGHT);
		panelPie.add(lblMediaValor);
		
		
	}
   public boolean numeroprimo(int numero) {
   	//Si el numero No es Primo | Porque es negativo | Porque no es ni 2 ni 3 pero es divisible por 2 o 3
   	if (numero <= 1 || (numero != 2 && numero != 3 && (numero % 2 == 0 || numero % 3 == 0))){
		boolean primo = false;
		return primo;	
   	}
   	//Si el numero es Primo
   	else {
   		boolean primo = true;
		return primo;
   	}
   }
   
   // Función que Calcula la media de los numeros
   public double calcularMedia() {
	   //TERNARIA |   Condicion      | Si se cumple hace division (double)   | Si NO se cumple
       return calcularTotales() != 0 ? (double) valornum / calcularTotales() : 0;
   }
   
   //Calcula los la cantidad de elementos en las listas
   public int calcularTotales() {
       return (dlmPrimos.size()) + (dlmNoPrimos.size());
   }
   
   private void ordenarListaDescendentemente(DefaultListModel<Integer> lista) {
	    // Obtener los elementos de la lista
	    List<Integer> elementos = Collections.list(lista.elements());

	    // Ordenar la lista en orden descendente
	    elementos.sort(Collections.reverseOrder());

	    // Limpiar la lista y añadir los elementos ordenados
	    lista.clear();
	    elementos.forEach(lista::addElement);
	}
}
