package views;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import java.awt.event.*;

import controllers.Controller;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class MainWindow extends JFrame implements ActionListener {
	
	private Controller controller;
	private JPanel contentPane;
	private JButton btnConsult;
	private JButton btnRegister; 
	private JLabel lblNewLabel;
	
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startComponents();
		setIconImage(new ImageIcon(getClass().getResource("img/cruz.png")).getImage());
		setTitle("INICIO");
		setBounds(100, 100, 637, 367);
	}
	
	private void startComponents() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		btnConsult = new JButton("CONSULTAR");
		btnConsult.setForeground(new Color(0, 0, 0));
		btnConsult.setBackground(new Color(255, 255, 204));
		btnConsult.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnConsult.setBounds(40, 21, 128, 40);
		btnConsult.addActionListener(this);
		contentPane.add(btnConsult);
		
		btnRegister = new JButton("REGISTRAR");
		btnRegister.setBackground(new Color(255, 255, 204));
		btnRegister.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		btnRegister.setBounds(475, 21, 115, 40);
		btnRegister.addActionListener(this);
		contentPane.add(btnRegister);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/views/img/hospital.jpg")));
		lblNewLabel.setBounds(0, 0, 621, 328);
		contentPane.add(lblNewLabel);
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConsult) {
			controller.showQuery();
		}
		if(e.getSource() == btnRegister) {
			controller.showRecord();
		}
	}
}
