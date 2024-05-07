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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

public class GestionPrimos extends JFrame implements FocusListener{

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
	private int  numero;
	private int division;
	private boolean esprimo;
	private int contador=0;
	int eliminadoP;
	int eliminadoNP;

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
	public GestionPrimos() {
		setTitle("Examen1 - Txema De Miguel");
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
		txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNumero.setText("0");
		panelCabecera.add(txtNumero);
		txtNumero.setColumns(10);
		txtNumero.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			 txtNumero.select(0, txtNumero.getText().length());
			}
			public void focusLost(FocusEvent e) {
			txtNumero.select(0, 0);
			}
			});

		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				numero = Integer.parseInt(txtNumero.getText());
				
				if(txtNumero.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Error al Insertar. El campo Numero no puede estar vacio");
				}else if (dlmPrimos.contains(numero)||dlmNoPrimos.contains(numero)){
					JOptionPane.showMessageDialog(null, "Error al Insertar. El Número "+numero+" ya está en una de las listas");
				}else if (numero<=1){
					dlmNoPrimos.addElement(numero);
				}else {
					
					numeroprimo();
					if (esprimo) {
						dlmPrimos.addElement(numero);
					}else {
						dlmNoPrimos.addElement(numero);
				}
					
			}
				CalcularTotales();	
			}
		});
		panelCabecera.add(btnInsertar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int indexP = lstPrimos.getSelectedIndex();
				int indexNP = lstNoPrimos.getSelectedIndex();
				
				if (indexP==-1&&indexNP==-1) {
					JOptionPane.showMessageDialog(null, "Error al Borrar. NO hay elementos seleccionados en las listas");
				}else if (indexP==-1||indexNP==-1) {
					
					if(indexP==-1) {
						dlmNoPrimos.remove(indexNP);	
					}else if (indexNP==-1){
						dlmPrimos.remove(indexP);
					}
				
				}else {
					eliminadoP = lstPrimos.getSelectedValue();
					eliminadoNP = lstNoPrimos.getSelectedValue();
					dlmPrimos.remove(indexP);
					dlmNoPrimos.remove(indexNP);
					
				}
			
				numero = -(eliminadoNP+eliminadoP);
				CalcularTotales();
	
			}
		});
		panelCabecera.add(btnBorrar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dlmPrimos.isEmpty()&&dlmNoPrimos.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Error al Borrar. NO hay elementos seleccionados en las listas");
				}else {
					dlmPrimos.removeAllElements();
					dlmNoPrimos.removeAllElements();
					
					txtNumero.setText("0");
					
					numero = 0;
					contador = 0;
					CalcularTotales();
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

		lblMediaValor = new JLabel("0.0");
		lblMediaValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMediaValor.setHorizontalAlignment(SwingConstants.RIGHT);
		panelPie.add(lblMediaValor);

	}
	

	public void numeroprimo() {
		division = 2;
		esprimo = true;
		while (division<numero && esprimo) {
			
			if (numero % division==0) {
				esprimo = false;
			}
			division = division + 1;
			}
		
	}
	public void CalcularTotales(){
		/*-----TOTAL NUMEROS---------*/
		int totalPrimos= dlmPrimos.getSize();
		int totalNoPrimos = dlmNoPrimos.getSize();
		int totalNumeros = totalPrimos + totalNoPrimos;
		String total = String.valueOf(totalNumeros);
		lblTotalNumerosValor.setText(total);
		/*-----CALCULAAR MEDIA---------*/
		//Total puntos
		contador = contador + numero;
		//MEDIA
		double totalNumerosD = totalNumeros;
		double totalSumaD= contador;
		
		double media = totalSumaD/totalNumerosD;
		String medialbl= String.valueOf(media);
		lblMediaValor.setText(medialbl);
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}
