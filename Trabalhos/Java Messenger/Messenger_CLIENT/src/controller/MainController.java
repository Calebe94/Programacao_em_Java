package controller;

import java.util.ArrayList;
import model.Client;
import view.*;

public class MainController {
	private static MainController instance;

	private Main_Window mainWindow;
	private Message messageWindow;
	
	private Client client = null;
	private String message = null;
	private String groupSelection = null;
	private String[] groups = null;
	private ArrayList<String> membersOnline;
	
	public static MainController getInstance(){
		if(instance == null){
			instance = new MainController();
		}
		return instance;
	}

	public void initClientWindow(){
		membersOnline = new ArrayList<String>();
		mainWindow = new Main_Window();
		mainWindow.getFrame().setVisible(true);
	}

	public void change2messageWindow(){
		messageWindow = new Message();
		mainWindow.getFrame().setVisible(false);
		messageWindow.getFrame().setVisible(true);
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public void setGroupsCombobox(String options){
		this.groups =  options.split(":");
		mainWindow.updateComboBox(groups);
	}
	
	public void setSelection(String option){
		this.groupSelection = option;
	}
	
	public boolean hasSelection(){
		return (this.groupSelection == null);
	}
	
	public String getSelection(){
		try{
			return this.groupSelection;
		}catch (Exception e) {
		}
		return " ";
	}
	
	public void sendMessage(String message){
		client.sendData(message);
	}
	
	public String receiveMessage(){
		return client.receiveData();
	}
	
	public boolean connect(String ip, int port){
		try{
			client = new Client(ip, port);
			client.start();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			//System.exit(-1);
			return false;
		}
	}

	public ArrayList<String> getMembersOnline() {
		return membersOnline;
	}

	public void setMembersOnline(String membersOnline) {
		this.membersOnline.add( membersOnline);
	}
}
