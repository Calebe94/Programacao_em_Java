package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.ScrollPaneConstants;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.MainController;
import model.Groups;

import javax.swing.JLabel;
import java.awt.Color;

public class Window {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel groupModel;
	private JScrollPane scrollPane;
	
	public Window() {
		initialize();
	}
	
	public JFrame getFrame(){
		return this.frame;
	}
	
	public void setIP(String IP){
		JLabel labelIP = new JLabel("IP:"+IP);
		labelIP.setForeground(Color.WHITE);
		labelIP.setBounds(36, 136, 169, 15);
		frame.getContentPane().add(labelIP);
	}
	
	public void updateTable(ArrayList<Groups> auxGroup){
		String[] columns = {"Groups"};
		groupModel = new DefaultTableModel();
		groupModel.setColumnIdentifiers(columns);
		try{
			for(int index = groupModel.getRowCount()-1; index >-1; index++){
				groupModel.removeRow(index);
			}
		}catch(Exception e){}
		Object[] auxObject = new Object[1];
		for(int index = groupModel.getRowCount(); index < auxGroup.size();index++){
			auxObject[0] = auxGroup.get(index).getName();
			this.groupModel.addRow(auxObject);
		}
		table.setModel(groupModel);
		scrollPane.setViewportView(table);
		getFrame().getContentPane().add(scrollPane);
	}
	private void initialize() {
		
		frame = new JFrame("Servidor");
		frame.getContentPane().setBackground(UIManager.getColor("MenuItem.acceleratorSelectionForeground"));
		frame.setBounds(100, 100, 600, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(254, 12, 313, 345);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setRowSelectionAllowed(false);
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setBackground(SystemColor.windowBorder);
		scrollPane.setViewportView(table);
		
		JButton buttonNewGroup = new JButton("Adiciona Grupo");
		buttonNewGroup.setBackground(SystemColor.inactiveCaption);
		buttonNewGroup.setBounds(36, 238, 169, 44);
		frame.getContentPane().add(buttonNewGroup);
		
		buttonNewGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainController.getInstance().change2AddGroup();
			}
		});
		
		JButton buttonRemoveGroup = new JButton("Remove Grupo");
		buttonRemoveGroup.setBackground(SystemColor.inactiveCaption);
		buttonRemoveGroup.setBounds(36, 294, 168, 44);
		frame.getContentPane().add(buttonRemoveGroup);
		buttonRemoveGroup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.getInstance().removeGroup(table.getSelectedRow());
				MainController.getInstance().updateTable();
			}
		});
		
		JLabel labelConnected = new JLabel("Conectado!");
		labelConnected.setForeground(Color.WHITE);
		labelConnected.setBounds(64, 96, 99, 15);
		frame.getContentPane().add(labelConnected);
		
	}
}
