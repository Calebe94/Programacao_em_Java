package model;

import java.util.ArrayList;

public class Groups {
	private String name;
	ArrayList<Client> clients;
	public Groups(String name){
		this.name = name;
		this.clients = new ArrayList<Client>();
	}
	public String getName() {
		return this.name;
	}
	public void addClient(Client client){
		this.clients.add(client);
	}
	public ArrayList<Client> getClients(){
		return this.clients;
	}

}
