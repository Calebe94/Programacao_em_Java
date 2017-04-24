package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServiceRegister {

	private JFrame frame;
	private JTextField ServiceNameTextField;
	private JTextField ServiceValueTextField;

	public ServiceRegister() {
		initialize();
	}

	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 245);
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel ServiceNameLabel = new JLabel("Nome do Serviço");
		ServiceNameLabel.setBounds(12, 0, 138, 42);
		getFrame().getContentPane().add(ServiceNameLabel);
		
		ServiceNameTextField = new JTextField();
		ServiceNameTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ServiceNameTextField.setBounds(199, 12, 229, 30);
		getFrame().getContentPane().add(ServiceNameTextField);
		ServiceNameTextField.setColumns(10);
		
		JLabel ServiceValueLabel = new JLabel("Valor por Hora");
		ServiceValueLabel.setBounds(12, 73, 138, 30);
		getFrame().getContentPane().add(ServiceValueLabel);
		
		ServiceValueTextField = new JTextField();
		ServiceValueTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ServiceValueTextField.setColumns(10);
		ServiceValueTextField.setBounds(199, 73, 229, 30);
		getFrame().getContentPane().add(ServiceValueTextField);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setBounds(311, 166, 117, 25);
		getFrame().getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(176, 166, 117, 25);
		getFrame().getContentPane().add(btnCancelar);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
