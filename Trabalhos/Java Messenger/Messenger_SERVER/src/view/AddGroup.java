package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
//import javax.swing.table.DefaultTableModel;

import controller.MainController;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class AddGroup {

	private JFrame frame;
	private JTextField textGroupsName;
	private JButton buttonAdd;
	private JButton buttonCancel;
	public AddGroup() {
		initialize();
	}
	public JFrame getFrame(){
		return this.frame;
	}
	
	private void initialize() {
		
		frame = new JFrame("Novo Grupo");
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setForeground(Color.DARK_GRAY);
		frame.setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 301, 159);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		JLabel labelGroupName = new JLabel("Nome do Novo Grupo:");
		labelGroupName.setFont(new Font("Dialog", Font.BOLD, 16));
		labelGroupName.setHorizontalAlignment(SwingConstants.CENTER);
		labelGroupName.setBounds(12, 12, 266, 15);
		frame.getContentPane().add(labelGroupName);
		
		textGroupsName = new JTextField();
		textGroupsName.setBounds(12, 43, 276, 40);
		frame.getContentPane().add(textGroupsName);
		textGroupsName.setColumns(10);
		
		buttonAdd = new JButton("Adicionar");
		buttonAdd.setBackground(Color.LIGHT_GRAY);
		buttonAdd.setBounds(171, 95, 117, 25);
		frame.getContentPane().add(buttonAdd);
		buttonAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//MainController controller = MainController.getInstance();
				MainController.getInstance().addNewGroup(textGroupsName.getText().toString());
				frame.setVisible(false);
				frame.dispose();
				MainController.getInstance().updateTable();
			}
		});
		
		buttonCancel = new JButton("Cancelar");
		buttonCancel.setBackground(Color.LIGHT_GRAY);
		buttonCancel.setBounds(12, 95, 117, 25);
		frame.getContentPane().add(buttonCancel);
		
		buttonCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
			}
		});
		
	}
}
