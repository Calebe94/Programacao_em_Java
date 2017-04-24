package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PieceRegister {

	private JFrame frame;
	private JTextField PiecesNameTextField;
	private JTextField ModelTextField;
	private JTextField YearInitialTextField;
	private JTextField YearFinalTextField;

	public PieceRegister() {
		initialize();
	}

	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 400);
		getFrame().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		JLabel PieceNameLabel = new JLabel("Nome da Peça:");
		PieceNameLabel.setBounds(12, 12, 115, 34);
		getFrame().getContentPane().add(PieceNameLabel);
		
		PiecesNameTextField = new JTextField();
		PiecesNameTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PiecesNameTextField.setBounds(207, 20, 221, 34);
		getFrame().getContentPane().add(PiecesNameTextField);
		PiecesNameTextField.setColumns(10);
		
		JLabel ModelLabel = new JLabel("Modelo do Carro:");
		ModelLabel.setBounds(12, 90, 134, 34);
		getFrame().getContentPane().add(ModelLabel);
		
		ModelTextField = new JTextField();
		ModelTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ModelTextField.setBounds(207, 224, 221, 34);
		getFrame().getContentPane().add(ModelTextField);
		ModelTextField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.setBounds(207, 90, 221, 34);
		getFrame().getContentPane().add(comboBox);
		
		JLabel YearTextField = new JLabel("Ano:");
		YearTextField.setBounds(12, 162, 92, 26);
		getFrame().getContentPane().add(YearTextField);
		
		YearInitialTextField = new JTextField();
		YearInitialTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		YearInitialTextField.setText("Inicial");
		YearInitialTextField.setBounds(207, 159, 72, 34);
		getFrame().getContentPane().add(YearInitialTextField);
		YearInitialTextField.setColumns(10);
		
		YearFinalTextField = new JTextField();
		YearFinalTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		YearFinalTextField.setText("Final");
		YearFinalTextField.setBounds(348, 159, 80, 34);
		getFrame().getContentPane().add(YearFinalTextField);
		YearFinalTextField.setColumns(10);
		
		JLabel ValueLabel = new JLabel("Valor:");
		ValueLabel.setBounds(12, 223, 72, 34);
		getFrame().getContentPane().add(ValueLabel);
		
		JButton CancelButton = new JButton("Cancelar");
		CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CancelButton.setBounds(183, 320, 116, 25);
		getFrame().getContentPane().add(CancelButton);
		
		JButton SaveButton = new JButton("Salvar");
		SaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SaveButton.setBounds(311, 320, 117, 25);
		getFrame().getContentPane().add(SaveButton);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
