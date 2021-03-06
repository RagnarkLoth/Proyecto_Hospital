package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import controllers.Controller;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ConsultPerson extends JDialog implements ActionListener{
		
	private Controller controller;
	private JScrollPane scroll;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	String[][] dataTable = {};
	private String[] headboardTable = {
			"Nombre", "Documento", "Direccion", "Telefono", "Cargo", "D?as Hospitalizado", "Costo Medicamentos", "Nombre Compa?ia", "Costo Tratamiento", "Pago Total"
	};
	private JTableHeader header;
	private JButton btnCheckAll;
	private JButton btnIndividual;
	
	public ConsultPerson(boolean modal, MainWindow mainWindow) {
		super(mainWindow, modal);
		setBounds(100, 100, 1148, 388);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("CONSULTAS");
		startComponents();
		
	}

	private void startComponents() {
		
		table = new JTable(dataTable, headboardTable);
		table.setBackground(new Color(153, 255, 204));
		scroll = new JScrollPane();
		scroll.setLocation(0, 99);
		scroll.setSize(1132, 250);
		scroll.setViewportView(table);
		contentPanel.add(scroll);
		
		btnCheckAll = new JButton("CONSULTAR TODO");
		btnCheckAll.setBackground(new Color(255, 255, 204));
		btnCheckAll.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		btnCheckAll.setBounds(220, 32, 211, 38);
		btnCheckAll.addActionListener(this);
		contentPanel.add(btnCheckAll);
		
		btnIndividual = new JButton("CONSULTA INDIVIDUAL");
		btnIndividual.setBackground(new Color(255, 255, 204));
		btnIndividual.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		btnIndividual.setBounds(664, 32, 229, 38);
		btnIndividual.addActionListener(this);
		contentPanel.add(btnIndividual);
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCheckAll) {
			dataTable = controller.setDataTable();
			table = new JTable(dataTable, headboardTable) {
				public boolean isCellEditable(int rowIndex, int colIndex) {
					return false;
				}
			};
			table.getTableHeader().setReorderingAllowed(false);
			scroll.setViewportView(table);
			if(dataTable.length == 0) {
				JOptionPane.showMessageDialog(null,"No existen datos en el sistema, porfavor, ingresa uno", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
			}
 		}
		if(e.getSource() == btnIndividual) {
			controller.showQueryDocument();
		}
	}

	public void sendDocument(String tfDocument) {
		String result = controller.verifyDocuments(tfDocument);
		if(result.equals("ok")) {
			dataTable = controller.checkOne(tfDocument);
			table = new JTable(dataTable, headboardTable) {
				public boolean isCellEditable(int rowIndex, int colIndex) {
					return false;
				}
			};
			table.getTableHeader().setReorderingAllowed(false);
			scroll.setViewportView(table);
		}else{
			JOptionPane.showMessageDialog(null, "El documento que ingreso no esta registrado en el sistema, porfavor, registrate y vuelve a intentarlo", "ERROR CONSULTA", JOptionPane.ERROR_MESSAGE);
		}
	}

}
