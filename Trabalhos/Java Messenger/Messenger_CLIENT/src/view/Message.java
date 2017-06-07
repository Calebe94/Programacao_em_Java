package view;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.MainController;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;

public class Message {

	private JFrame frame;
	private JEditorPane editorMessage;
	
	public Message() {
		initialize();
	}
	
	public JFrame getFrame(){
		return this.frame;
	}

	private void initialize() {
		frame = new JFrame("Grupo");
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton buttonSend = new JButton("Enviar");
		buttonSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainController.getInstance().setMessage(editorMessage.getText().toString()); 
			}
		});
		buttonSend.setBounds(465, 280, 113, 49);
		frame.getContentPane().add(buttonSend);
		
		JScrollPane scrollMessages = new JScrollPane();
		scrollMessages.setBounds(12, 43, 265, 225);
		frame.getContentPane().add(scrollMessages);
		
		JTextPane textMessages = new JTextPane();
		textMessages.setEditable(false);
		scrollMessages.setViewportView(textMessages);
		
		JLabel lblMessages = new JLabel("Mensagens");
		lblMessages.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMessages.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessages.setBounds(12, 16, 265, 15);
		frame.getContentPane().add(lblMessages);
		
		JLabel lblMessage = new JLabel("Mensagem");
		lblMessage.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMessage.setBounds(22, 280, 100, 38);
		frame.getContentPane().add(lblMessage);
		
		JScrollPane scrollMembers = new JScrollPane();
		scrollMembers.setBounds(313, 43, 265, 225);
		frame.getContentPane().add(scrollMembers);
		
		JTextPane textPaneMembers = new JTextPane();
		scrollMembers.setViewportView(textPaneMembers);
		textPaneMembers.setText("Text\n");
		
		JScrollPane scrollMessage = new JScrollPane();
		scrollMessage.setBounds(128, 280, 325, 49);
		frame.getContentPane().add(scrollMessage);
		
		editorMessage = new JEditorPane();
		scrollMessage.setViewportView(editorMessage);
		editorMessage.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event){
				if(event.getKeyCode() == KeyEvent.VK_ENTER){
					System.out.println(editorMessage.getText().toString());
					editorMessage.setText("");
				}
			}
		});
		
		JLabel labelMembers = new JLabel("Membros");
		labelMembers.setFont(new Font("Dialog", Font.BOLD, 16));
		labelMembers.setBounds(400, 16, 93, 15);
		frame.getContentPane().add(labelMembers);
		
		
		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {}
			
			@Override
			public void windowIconified(WindowEvent e) {}
			
			@Override
			public void windowDeiconified(WindowEvent e) {}
			
			@Override
			public void windowDeactivated(WindowEvent e) {}

			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Janela Fechando!");
			}
			
		});
	}
}
