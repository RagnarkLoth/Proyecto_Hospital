package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.Controller;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

public class DocumentPerson extends JDialog implements ActionListener, KeyListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField tfDocument;
	private Controller controller;
	private JButton btnConsult;

	public DocumentPerson(boolean modal, ConsultPerson consultPerson) {
		super(consultPerson, modal);
		setBounds(100, 100, 450, 192);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("DOCUMENTO");
		contentPanel.setBackground(new Color(240, 255, 255));
		startComponents();
	}
		
	private void startComponents() {
			tfDocument = new JTextField();
			tfDocument.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
			tfDocument.setBounds(94, 58, 244, 41);
			contentPanel.add(tfDocument);
			tfDocument.setColumns(10);
			tfDocument.addKeyListener(this);
			
			JLabel lbDocument = new JLabel("Documento:");
			lbDocument.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 19));
			lbDocument.setBounds(94, 22, 128, 25);
			contentPanel.add(lbDocument);
			
			btnConsult = new JButton("CONSULTAR");
			btnConsult.setBackground(new Color(255, 255, 204));
			btnConsult.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
			btnConsult.setBounds(161, 110, 122, 29);
			btnConsult.addActionListener(this);
			contentPanel.add(btnConsult);
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnConsult) {
			String result = controller.checkFied(tfDocument.getText());
			if(result.equals("error")) {
				JOptionPane.showMessageDialog(null, "El campo esta vacio, porfavor, llenalo", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
			}else if(result.equals("ok")) {
				controller.sendDocument(tfDocument.getText());
				tfDocument.setText("");;
				controller.toClose();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		String result = controller.onlyNumbers(e);
		if(result.equals("error")) {
			e.consume();
		}else {
			
		}		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
