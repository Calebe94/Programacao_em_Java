package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import controller.MainController;

import javax.swing.JComboBox;
import java.awt.Color;

public class Main_Window {

	private JFrame frame;
	private JTextField textIP;
	private JTextField textPorta;
	private JTextField textUserName;
	private JComboBox<String> comboBox;
	private JLabel labelConected;
	private JLabel labelGroup;
	private JButton buttonJoin;

	public Main_Window() {
		initialize();
	}
	public void connected(){
		labelGroup.setText("Selecione um Grupo");
		labelConected.setText("Conectado");
		comboBox.setVisible(true);
		buttonJoin.setVisible(true);
		labelGroup.setVisible(true);
		labelConected.setVisible(true);
	}
	public void connectionFailed(){
		labelConected.setText("Falha ao Conectar!");
		labelConected.setVisible(true);
		labelGroup.setText("Por Favor Tente Novamente!");
		labelGroup.setVisible(true);
	}
	
	public JFrame getFrame(){
		return this.frame;
	}
	
	public void updateComboBox(String[] options){
		for(int index = 0; index < options.length; index++){
			comboBox.addItem(options[index]);
		}
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelIP = new JLabel("IP:");
		labelIP.setBounds(12, 12, 70, 15);
		frame.getContentPane().add(labelIP);
		
		JLabel labelPorta = new JLabel("Porta:");
		labelPorta.setBounds(12, 60, 70, 15);
		frame.getContentPane().add(labelPorta);
		
		JLabel labelUserName = new JLabel("Username:");
		labelUserName.setBounds(12, 113, 88, 15);
		frame.getContentPane().add(labelUserName);
		
		JButton buttonConectar = new JButton("Conectar");
		buttonConectar.setBounds(128, 150, 120, 25);
		frame.getContentPane().add(buttonConectar);
		buttonConectar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(MainController.getInstance().connect(textIP.getText().toString(), Integer.parseInt(textPorta.getText().toString()))){
					connected();	
				}else{
					connectionFailed();
				}
			}
		});
		
		textIP = new JTextField();
		textIP.setBounds(118, 10, 173, 19);
		frame.getContentPane().add(textIP);
		textIP.setColumns(10);
		
		textPorta = new JTextField();
		textPorta.setBounds(118, 58, 173, 19);
		frame.getContentPane().add(textPorta);
		textPorta.setColumns(10);
		
		textUserName = new JTextField();
		textUserName.setBounds(118, 111, 173, 19);
		frame.getContentPane().add(textUserName);
		textUserName.setColumns(10);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(360, 108, 200, 24);
		frame.getContentPane().add(comboBox);
		comboBox.setVisible(false);
		
		labelConected = new JLabel("Conectado");
		labelConected.setForeground(Color.RED);
		labelConected.setBounds(405, 12, 170, 45);
		frame.getContentPane().add(labelConected);
		labelConected.setVisible(false);
		
		labelGroup = new JLabel("Selecione um Grupo");
		labelGroup.setBounds(360, 81, 300, 15);
		frame.getContentPane().add(labelGroup);
		labelGroup.setVisible(false);
		
		buttonJoin = new JButton("Entrar");
		buttonJoin.setBounds(405, 150, 117, 25);
		frame.getContentPane().add(buttonJoin);
		buttonJoin.setVisible(false);
		buttonJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] options = new String[2];
				options[0] = comboBox.getSelectedItem().toString();
				options[1] = textUserName.getText().toString();
				String nameAndGroup = String.join(":",options);
				//MainController.getInstance().sendMessage(comboBox.getSelectedItem().toString());
				MainController.getInstance().sendMessage(nameAndGroup.toString());
				MainController.getInstance().change2messageWindow();
			}
		});
	}
}
