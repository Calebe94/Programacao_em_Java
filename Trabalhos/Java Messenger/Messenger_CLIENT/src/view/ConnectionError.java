package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.JButton;

public class ConnectionError {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectionError window = new ConnectionError();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConnectionError() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.RED);
		frame.getContentPane().setForeground(Color.RED);
		frame.setBounds(100, 100, 400, 170);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelCannotConnect = new JLabel("Impossível se Conectar ao Servidor!");
		labelCannotConnect.setBackground(new Color(255, 51, 0));
		labelCannotConnect.setBounds(79, 12, 265, 30);
		frame.getContentPane().add(labelCannotConnect);
		
		JLabel labelFirstText = new JLabel("Verifique se o IP");
		labelFirstText.setBounds(12, 54, 130, 15);
		frame.getContentPane().add(labelFirstText);
		
		JLabel labelSecondText = new JLabel("Está correto");
		labelSecondText.setBounds(292, 54, 102, 15);
		frame.getContentPane().add(labelSecondText);
		
		JLabel labelIP = new JLabel("");
		labelIP.setBounds(141, 54, 130, 15);
		frame.getContentPane().add(labelIP);
		
		JButton buttonOk = new JButton("OK");
		buttonOk.setBounds(141, 103, 117, 25);
		frame.getContentPane().add(buttonOk);
	}
}
