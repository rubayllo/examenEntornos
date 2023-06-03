package practicas;

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

public class Vista extends JFrame {

	private Modelo modelo;
	private Controlador controlador;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modeloTabla;
	private JButton btnTabla1, btnTabla2, btnTabla3, btnTabla4;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Vista() {
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				modelo.recuperarDatos("Select * FROM world.city");
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
		scrollPane.setBounds(25, 18, 401, 177);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);

		
		btnTabla1 = new JButton("Tabla1");
		btnTabla1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.recuperarDatos("Select * FROM world.city");
			}
		});
		btnTabla1.setBounds(35, 207, 87, 29);
		contentPane.add(btnTabla1);
		
		btnTabla2 = new JButton("Tabla2");
		btnTabla2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.recuperarDatos("Select * FROM world.country");
			}
		});
		btnTabla2.setBounds(134, 207, 87, 29);
		contentPane.add(btnTabla2);
		
		btnTabla3 = new JButton("Tabla3");
		btnTabla3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.recuperarDatos("Select * FROM world.countrylanguage");
			}
		});
		btnTabla3.setBounds(233, 207, 87, 29);
		contentPane.add(btnTabla3);
		
		btnTabla4 = new JButton("Tabla4");
		btnTabla4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.recuperarDatos("Select * FROM world.users");
			}
		});
		btnTabla4.setBounds(332, 207, 87, 29);
		contentPane.add(btnTabla4);
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void setModeloTabla(DefaultTableModel modeloTabla) {
		this.modeloTabla = modeloTabla;
		table.setModel(this.modeloTabla);
	}

}
