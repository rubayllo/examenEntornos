package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import interfaceVistas.Vistas;
import modelo.Modelo;

public class VistaTablaDB extends JFrame implements Vistas{

	private JPanel contentPane;
	private Controlador controlador;
	private Modelo modelo;
	private JTable table;
	private JButton btnTb1;
	private JButton btnTb;
	private JButton btnTb3;
	private JButton btnTb4;
	private DefaultTableModel modeloTabla;
	private JButton btnAad;
	private JButton btnVerSel;
	private JTextPane txtSelec;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaTablaDB frame = new VistaTablaDB();
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
	public VistaTablaDB() {
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				controlador.consultarQuery("SELECT * FROM world.city");
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 21, 406, 174);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int fila = table.getSelectedRow();
				int columnas = table.getColumnCount();
				String seleccion = "";
				for (int i = 1; i < columnas; i++) {
					seleccion += table.getValueAt(fila, i-1) + " ";
				}
				setTxtSelec(seleccion);
			}
		});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		
		btnTb1 = new JButton("Tb1");
		btnTb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.consultarQuery("SELECT * FROM world.city");
			}
		});
		btnTb1.setBounds(22, 194, 68, 29);
		contentPane.add(btnTb1);
		
		btnTb = new JButton("Tb2");
		btnTb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.consultarQuery("SELECT * FROM world.country");
			}
		});
		btnTb.setBounds(90, 194, 68, 29);
		contentPane.add(btnTb);
		
		btnTb3 = new JButton("Tb3");
		btnTb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.consultarQuery("SELECT * FROM world.countrylanguage");
			}
		});
		btnTb3.setBounds(157, 194, 68, 29);
		contentPane.add(btnTb3);
		
		btnTb4 = new JButton("Tb4");
		btnTb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.consultarQuery("SELECT * FROM world.users");
			}
		});
		btnTb4.setBounds(224, 194, 68, 29);
		contentPane.add(btnTb4);
		
		btnAad = new JButton("Añadir");
		btnAad.setBounds(292, 194, 136, 29);
		contentPane.add(btnAad);
		
		btnVerSel = new JButton("Ver Selección");
		btnVerSel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cambiarVista("vistaSeleccionados");
			}
		});
		btnVerSel.setBounds(292, 226, 136, 29);
		contentPane.add(btnVerSel);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 226, 270, 40);
		contentPane.add(scrollPane_1);
		
		txtSelec = new JTextPane();
		scrollPane_1.setViewportView(txtSelec);
	}

	public void setControlador(Object controlador) {
		this.controlador = (Controlador) controlador;
	}

	public void setModelo(Object modelo) {
		this.modelo = (Modelo) modelo;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
		this.table.setModel(this.modeloTabla);
	}

	public void setTxtSelec(String seleccion) {
		this.txtSelec.setText(seleccion);
	}
}
