package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		
		btnTb1 = new JButton("Tb1");
		btnTb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.consultarQuery("SELECT * FROM world.city");
			}
		});
		btnTb1.setBounds(22, 207, 68, 29);
		contentPane.add(btnTb1);
		
		btnTb = new JButton("Tb2");
		btnTb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.consultarQuery("SELECT * FROM world.country");
			}
		});
		btnTb.setBounds(90, 207, 68, 29);
		contentPane.add(btnTb);
		
		btnTb3 = new JButton("Tb3");
		btnTb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.consultarQuery("SELECT * FROM world.countrylanguage");
			}
		});
		btnTb3.setBounds(157, 207, 68, 29);
		contentPane.add(btnTb3);
		
		btnTb4 = new JButton("Tb4");
		btnTb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.consultarQuery("SELECT * FROM world.users");
			}
		});
		btnTb4.setBounds(224, 207, 68, 29);
		contentPane.add(btnTb4);
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

}
