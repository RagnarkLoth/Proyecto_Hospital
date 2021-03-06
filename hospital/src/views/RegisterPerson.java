package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import controllers.Controller;
import javax.swing.ImageIcon;

public class RegisterPerson extends JDialog implements ActionListener, KeyListener {
	
	private final JPanel contentPanel = new JPanel();
	private JTextField tfName;
	private JTextField tfDocument;
	private JTextField tfPhone;
	private JTextField tfCompanyName;
	private JTextField tfDays;
	private JTextField tfDrugsCosts;
	private JTextField tfCostOfTreatment;
	private JTextField tfTotalPay;
	private JButton btnSave;
	private JButton btnCalculate;
	private JComboBox cbTreatment;
	private JComboBox cbTypeUsed;
	private Controller controller;
	private JTextField tfDirection;

	public RegisterPerson(boolean modal, MainWindow mainWindow) {
		super(mainWindow, modal);
		setBounds(100, 100, 505, 484);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(240, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("REGISTRO");
		startComponents();
		
	}

	private void startComponents() {
		tfName = new JTextField();
		tfName.setBounds(25, 99, 194, 20);
		contentPanel.add(tfName);
		tfName.setColumns(10);
		
		JLabel lbName = DefaultComponentFactory.getInstance().createLabel("Nombre:");
		lbName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lbName.setBounds(25, 74, 92, 14);
		contentPanel.add(lbName);
		
		tfDocument = new JTextField();
		tfDocument.setBounds(25, 155, 132, 20);
		contentPanel.add(tfDocument);
		tfDocument.setColumns(10);
		tfDocument.addKeyListener(this);
		
		JLabel lbDocument = DefaultComponentFactory.getInstance().createLabel("Documento:");
		lbDocument.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lbDocument.setBounds(25, 130, 92, 14);
		contentPanel.add(lbDocument);
		
		tfPhone = new JTextField();
		tfPhone.setBounds(25, 211, 132, 20);
		contentPanel.add(tfPhone);
		tfPhone.setColumns(10);
		tfPhone.addKeyListener(this);

		
		JLabel lbPhone = DefaultComponentFactory.getInstance().createLabel("Telefono:");
		lbPhone.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lbPhone.setBounds(25, 186, 92, 14);
		contentPanel.add(lbPhone);
		
		cbTypeUsed = new JComboBox();
		cbTypeUsed.setBackground(new Color(255, 255, 204));
		cbTypeUsed.setBounds(25, 262, 132, 22);
		cbTypeUsed.addItem("TIPO");
		cbTypeUsed.addItem("Operario");
		cbTypeUsed.addItem("Minero");
		contentPanel.add(cbTypeUsed);
		
		JLabel lbTypeUsed = DefaultComponentFactory.getInstance().createLabel("Tipo Usuario:");
		lbTypeUsed.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lbTypeUsed.setBounds(25, 242, 92, 14);
		contentPanel.add(lbTypeUsed);
		
		JLabel lbCompanyName = new JLabel("Nombre Empresa:");
		lbCompanyName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lbCompanyName.setBounds(298, 12, 106, 14);
		contentPanel.add(lbCompanyName);
		
		tfCompanyName = new JTextField();
		tfCompanyName.setBounds(298, 30, 156, 20);
		contentPanel.add(tfCompanyName);
		tfCompanyName.setColumns(10);
		
		JLabel lbDays = new JLabel("Dias hospitalizado:");
		lbDays.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lbDays.setBounds(298, 65, 106, 14);
		contentPanel.add(lbDays);
		
		tfDays = new JTextField();
		tfDays.setBounds(298, 89, 36, 20);
		contentPanel.add(tfDays);
		tfDays.setColumns(10);
		tfDays.addKeyListener(this);
		
		JLabel lbDrugsCosts = new JLabel("Costo Medicamentos:");
		lbDrugsCosts.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lbDrugsCosts.setBounds(298, 126, 112, 14);
		contentPanel.add(lbDrugsCosts);
		
		tfDrugsCosts = new JTextField();
		tfDrugsCosts.setBounds(298, 150, 70, 20);
		contentPanel.add(tfDrugsCosts);
		tfDrugsCosts.setColumns(10);
		tfDrugsCosts.addKeyListener(this);
		
		JLabel lbTreatment = DefaultComponentFactory.getInstance().createLabel("Tratamiento:");
		lbTreatment.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lbTreatment.setBounds(298, 181, 92, 14);
		contentPanel.add(lbTreatment);
		
		cbTreatment = new JComboBox();
		cbTreatment.setBackground(new Color(255, 255, 204));
		cbTreatment.setBounds(298, 205, 156, 22);
		cbTreatment.addItem("TRATAMIENTO");
		cbTreatment.addItem("Neumoconiosis");
		cbTreatment.addItem("V?rtigo");
		cbTreatment.addItem("Problemas Respiratorios");
		cbTreatment.addActionListener(this);
		contentPanel.add(cbTreatment);
		
		JLabel lbCostOfTreatment = DefaultComponentFactory.getInstance().createLabel("Costo Tratamiento:");
		lbCostOfTreatment.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lbCostOfTreatment.setBounds(298, 238, 156, 14);
		contentPanel.add(lbCostOfTreatment);
		
		tfCostOfTreatment = new JTextField();
		tfCostOfTreatment.setBounds(298, 263, 106, 20);
		contentPanel.add(tfCostOfTreatment);
		tfCostOfTreatment.setColumns(10);
		tfCostOfTreatment.setEditable(false);
		
		JLabel lbTotalPay = new JLabel("TOTAL:");
		lbTotalPay.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 17));
		lbTotalPay.setBounds(25, 356, 92, 14);
		contentPanel.add(lbTotalPay);
		
		tfTotalPay = new JTextField();
		tfTotalPay.setBounds(25, 381, 92, 20);
		tfTotalPay.setEditable(false);
		contentPanel.add(tfTotalPay);
		tfTotalPay.setColumns(10);
		
		JLabel lbDirection = new JLabel("Direccion:");
		lbDirection.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
		lbDirection.setBounds(25, 300, 59, 14);
		contentPanel.add(lbDirection);
		
		tfDirection = new JTextField();
		tfDirection.setBounds(25, 325, 132, 20);
		contentPanel.add(tfDirection);
		tfDirection.setColumns(10);
		
		JLabel lbRegister = new JLabel("REGISTRO");
		lbRegister.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 30));
		lbRegister.setBounds(25, 12, 211, 41);
		contentPanel.add(lbRegister);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(RegisterPerson.class.getResource("/views/img/crossSmall.png")));
		lblNewLabel.setBounds(306, 314, 98, 56);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnSave = new JButton("GUARDAR");
				btnSave.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
				btnSave.setBackground(new Color(255, 255, 204));
				btnSave.setActionCommand("OK");
				btnSave.addActionListener(this);
				buttonPane.add(btnSave);
				getRootPane().setDefaultButton(btnSave);
			}
			
			btnCalculate = new JButton("CALCULAR");
			btnCalculate.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 11));
			btnCalculate.setBackground(new Color(255, 255, 204));
			btnCalculate.addActionListener(this);
			buttonPane.add(btnCalculate);
		}		
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSave) {
			String result = controller.validateFields(tfName.getText(), tfDirection.getText() ,tfDocument.getText(), tfPhone.getText(), cbTypeUsed.getSelectedItem(), tfCompanyName.getText(), tfDays.getText(), tfDrugsCosts.getText(), cbTreatment.getSelectedItem(), tfCostOfTreatment.getText(), tfTotalPay.getText());
			if(result.equals("error")) {
				JOptionPane.showMessageDialog(null, "Hay campos vacios, porfavor, llenarlos todos", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
			}else if(result.equals("error_dos")) {
				JOptionPane.showMessageDialog(null, "No se ha realizado el calculo, porfavor, preciona el boton calcular para realizar el total", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
			}else if(result.equals("ok")) {
				controller.saveData(tfName.getText(), tfDirection.getText(),tfDocument.getText(), tfPhone.getText(), cbTypeUsed.getSelectedItem(), tfCompanyName.getText(), tfDays.getText(), tfDrugsCosts.getText(), cbTreatment.getSelectedItem(), tfCostOfTreatment.getText(), tfTotalPay.getText());
				JOptionPane.showMessageDialog(null, "Se ha guardado correctamente", "CORRECTO", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(e.getSource() == btnCalculate) {
			String result = controller.validateFields(tfName.getText(), tfDirection.getText(),tfDocument.getText(), tfPhone.getText(), cbTypeUsed.getSelectedItem(), tfCompanyName.getText(), tfDays.getText(), tfDrugsCosts.getText(), cbTreatment.getSelectedItem(), tfCostOfTreatment.getText(), tfTotalPay.getText());
			if(result.equals("error")) {
				JOptionPane.showMessageDialog(null, "Hay campos vacios, porfavor, llenarlos todos", "ADVERTENCIA", JOptionPane.ERROR_MESSAGE);
			}else {
				tfTotalPay.setText(controller.calculateTotal(tfDays.getText(), tfDrugsCosts.getText(), tfCostOfTreatment.getText(),cbTypeUsed.getSelectedItem()));
			}
		}
	   if(e.getSource() == cbTreatment) {
		   String resultado = controller.insertCost(cbTreatment.getSelectedItem());
		   tfCostOfTreatment.setText(resultado);
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
