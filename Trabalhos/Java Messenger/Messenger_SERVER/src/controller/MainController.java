package controller;

import view.*;
import java.net.Socket;
import java.util.ArrayList;
import model.*;

public class MainController {
	private Window mainWindow;
	private AddGroup addGroup;
	private ArrayList<Groups> group;
	private static MainController instance;
	private Server server;
	
	private ArrayList<Thread> threads;
	
	public static MainController getInstance(){
		if(instance == null){
			instance = new MainController();
		}
		return instance;
	}
	
	public void serverRun(){
		server = new Server(12345);
		server.start();
	}
	
	public String getGroupsOptions(){
		String[] groupOptions =new String[this.group.size()];
		for(int count = 0 ; count < this.group.size(); count++){
			groupOptions[count] = this.group.get(count).getName();  
		}
		return String.join(":", groupOptions);
	}
	
	public void addClient2Group(Socket aux, String groupName,String userName){
		for(int count = 0; count < this.group.size(); count++){
			if(groupName == this.group.get(count).getName()){
				this.group.get(count).addClient(new Client(aux, userName));
			}
		}
	}
	
	public void initServerWindow(){
		mainWindow = new Window();
		serverRun();
		mainWindow.getFrame().setVisible(true);
		mainWindow.setIP(this.server.getAddress());
		group = new ArrayList<Groups>();
		threads = new ArrayList<Thread>();
		updateTable();
	}
	
	public void change2AddGroup(){
		addGroup = new AddGroup();
		addGroup.getFrame().setVisible(true);
	}
	public void addNewGroup(String name){
		Groups aux = new Groups(name.toString());
		this.group.add(aux);
		generateThread(aux);
		threads.get(group.size()-1).start();
	}
	
	public void addNewClient(String groupName, Client aux){
		for(int index = 0; index < group.size(); index++){
			if(this.group.get(index).getName() == groupName){
				this.group.get(index).addClient(aux);
			}
		}
	}
	
	public void removeGroup(int index){
		this.group.remove(index);
	}
	
	public ArrayList<Groups> getGroups(){
		return this.group;
	}
	
	public void updateTable(){
		mainWindow.getFrame().setVisible(true);
		mainWindow.updateTable(this.group);
	}
	
	public void sendMessage(String message){
		this.server.sendData(message.toString());
	}
	
	public String receiveMessage(){
		return this.server.receiveData().toString();
	}
	
	public void generateThread(Groups group){
		threads.add(new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					ArrayList<Client> clients = group.getClients();
					//System.out.println("Rodando Groupo: "+group.getName());
					for(int index = 0; index < clients.size(); index++){
						System.out.println(clients.get(index).getName());
						//String buffer = clients.get(index).receiveData();
						//clients.get(index).sendData(buffer);
					}
				}
			}
		})
	);
	}
}
