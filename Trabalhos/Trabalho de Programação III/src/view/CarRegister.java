package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarRegister {

	private JFrame frame;
	private JTextField CarsNameTextField;
	private JTextField CarsModelTextField;
	private JLabel CarsYearLabel;
	private JTextField CarsYearTextField;
	private JButton CancelButton;
	private JButton SaveButton;

	
	public CarRegister() {
		initialize();
	}

	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel CarsNameLabel = new JLabel("Nome do Carro:");
		CarsNameLabel.setBounds(12, 33, 141, 37);
		getFrame().getContentPane().add(CarsNameLabel);
		
		CarsNameTextField = new JTextField();
		CarsNameTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CarsNameTextField.setBounds(233, 31, 179, 39);
		getFrame().getContentPane().add(CarsNameTextField);
		CarsNameTextField.setColumns(10);
		
		JLabel CarsModelLabel = new JLabel("Modelo:");
		CarsModelLabel.setBounds(12, 84, 141, 37);
		getFrame().getContentPane().add(CarsModelLabel);
		
		CarsModelTextField = new JTextField();
		CarsModelTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CarsModelTextField.setColumns(10);
		CarsModelTextField.setBounds(233, 82, 179, 39);
		getFrame().getContentPane().add(CarsModelTextField);
		
		CarsYearLabel = new JLabel("Ano:");
		CarsYearLabel.setBounds(12, 135, 141, 37);
		getFrame().getContentPane().add(CarsYearLabel);
		
		CarsYearTextField = new JTextField();
		CarsYearTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CarsYearTextField.setColumns(10);
		CarsYearTextField.setBounds(233, 133, 179, 39);
		getFrame().getContentPane().add(CarsYearTextField);
		
		CancelButton = new JButton("Cancelar");
		CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CancelButton.setBounds(175, 206, 117, 52);
		getFrame().getContentPane().add(CancelButton);
		
		SaveButton = new JButton("Salvar");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SaveButton.setBounds(311, 206, 117, 52);
		getFrame().getContentPane().add(SaveButton);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
