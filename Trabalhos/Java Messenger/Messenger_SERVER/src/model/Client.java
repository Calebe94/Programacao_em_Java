package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	private Socket client;
	private String name;
	private OutputStream outToServer;
	private DataOutputStream out;
	private InputStream inFromServer;
	private DataInputStream in;
	public Client(Socket client,String name){
		this.client = client;
		this.name = name;
	}
	public Socket getClient() {
		return client;
	}
	public void setClient(Socket client) {
		this.client = client;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    public void sendData(String message){
        try{
            this.outToServer = client.getOutputStream();
            this.out = new DataOutputStream(outToServer);

            //this.out.writeUTF("Client Says: "+message);
            this.out.writeUTF(message.toString());
        }catch(IOException e){}
    }
    public String receiveData(){
        try{
            this.inFromServer = client.getInputStream();
            this.in = new DataInputStream(inFromServer);

            //System.out.println(this.in.readUTF());
            return this.in.readUTF();
        }catch (Exception e) {}
        return null;
    }
}
